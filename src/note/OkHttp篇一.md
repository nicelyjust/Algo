### OKHttp源码解析(一)
#### 1 前言
OkHttp是Square公司开源的一个优秀的网络框架，而身为一名有梦想的程序猿怎么能不学习研读优秀源码呢？
我看过许多OkHttp源码分析的博客，剖析的角度和方式各有异同，但是每个人思维各异，
所以我想为什么不按照我自己习惯的思维模式去剖析OkHttp源码呢，本质上我仅仅是作为个人的复习笔记注记，但如果能帮到其他人的话,胜造七级浮屠。
#### 2 如何使用
下边是OkHttp的简单示例:

	// 3.1 构造OkHttpClient
    OkHttpClient client = new OkHttpClient();
    // 3.2 建造者模式构造request
    Request request = new Request.Builder()
                .url("www.baidu.com")
                .build();
    try {
		// 3.3 构造call实例
        Call call = client.newCall(request);
		// 4.4 同步|异步执行
        Response execute = call.execute();
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }
        });
        ResponseBody body = execute.body();
    } catch (IOException e) {
        e.printStackTrace();
    }
##### 3 流程分析
###### 3.1.1 OkHttpClient
无参构造函数,实际上调用了OkHttpClient(Builder builder)构造函数

    public OkHttpClient() {
      this(new Builder());
    }
	public Builder() {
	  // 分发器
      dispatcher = new Dispatcher();
	  // 支持的协议,HTTP1.0,HTTP2.0
      protocols = DEFAULT_PROTOCOLS;
	  //套接字及TLS配置
      connectionSpecs = DEFAULT_CONNECTION_SPECS;
      eventListenerFactory = EventListener.factory(EventListener.NONE);
      proxySelector = ProxySelector.getDefault();
      cookieJar = CookieJar.NO_COOKIES;
	  // 创建socket实例
      socketFactory = SocketFactory.getDefault();
      hostnameVerifier = OkHostnameVerifier.INSTANCE;
      certificatePinner = CertificatePinner.DEFAULT;
      proxyAuthenticator = Authenticator.NONE;
      authenticator = Authenticator.NONE;
      connectionPool = new ConnectionPool();
      dns = Dns.SYSTEM;
      followSslRedirects = true;
      followRedirects = true;
      retryOnConnectionFailure = true;
      connectTimeout = 10_000;
      readTimeout = 10_000;
      writeTimeout = 10_000;
      pingInterval = 0;
    }

    OkHttpClient(Builder builder) {
      this.dispatcher = builder.dispatcher;
	  ...
	  省略一系列属性赋值操作
	  ...
	}
###### 3.1.2 Dispatcher
既有传入一个线程池的构造函数,也有一个空构造函数

	  public Dispatcher(ExecutorService executorService) {
        this.executorService = executorService;
      }

      public Dispatcher() {
      }
接下来我们看看Dispatcher类的成员属性:

	  // 默认最大并发请求数 64
	  private int maxRequests = 64;
      private int maxRequestsPerHost = 5;
	  private @Nullable Runnable idleCallback;
	
	  /** Executes calls. Created lazily. */
	  // 执行请求,懒人法创建
	  private @Nullable ExecutorService executorService;
	
	  /** Ready async calls in the order they'll be run. */
	  //准备就绪将会被执行的异步请求任务集合
	  private final Deque<AsyncCall> readyAsyncCalls = new ArrayDeque<>();
	
	  /** Running asynchronous calls. Includes canceled calls that haven't finished yet. */
	  // 正在执行的异步请求任务集合
	  private final Deque<AsyncCall> runningAsyncCalls = new ArrayDeque<>();
	
	  /** Running synchronous calls. Includes canceled calls that haven't finished yet. */
	  // 正在执行的同步请求任务(包括canceled掉且未被finished的)集合
	  private final Deque<RealCall> runningSyncCalls = new ArrayDeque<>();
Dispatcher类的方法基本上都加了synchronized关键字,这里我们看一下几个重要的方法
	  
	  //异步执行请求任务
	  synchronized void enqueue(AsyncCall call) {
		//判断有没有超过最大的并发量
    	if (runningAsyncCalls.size() < maxRequests && runningCallsForHost(call) <  maxRequestsPerHost) {
      	  runningAsyncCalls.add(call);
		  //放入线程池执行
      	  executorService().execute(call);
    	} else {
          readyAsyncCalls.add(call);
    	}
  	  }
	  //创建线程池的方法
	  public synchronized ExecutorService executorService() {
	    if (executorService == null) {
		  //与默认newCacheExecutor线程池差不多,唯独线程构建方式不一样
	      executorService = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS,
	          new SynchronousQueue<Runnable>(), Util.threadFactory("OkHttp Dispatcher", false));
	    }
	    return executorService;
	  }
	  //同步执行请求任务
	  synchronized void executed(RealCall call) {
	    runningSyncCalls.add(call);
	  }
###### 3.2 Request
Request类很简单同样也用到了建造者模式,

	//Request类的作用可以理解为组成请求报文
    public final class Request {
      final HttpUrl url;
	  //GET,POST,DELETE,PUT...
      final String method;
	  //请求头
  	  final Headers headers;
      final @Nullable RequestBody body;
      final Object tag;

      private volatile CacheControl cacheControl; // Lazily initialized.
    }
###### 3.3 RealCall
OkHttpClient类调用newCall方法:
	
	@Override public Call newCall(Request request) {
    	return new RealCall(this, request, false /* for web socket */);
    }
RealCall实现了Call接口,下面过一下Call接口:

	//初始化Call的原始Request实例
	Request request();
	//同步调用请求,阻塞直到可以处理响应或错误为止
	Response execute() throws IOException;
	//异步调用请求,Callback回调出Response
	void enqueue(Callback responseCallback);
	//取消本次Request
	void cancel();
	...
	//省略不太重要的方法
	...
	//OkHttpClient类实现了该接口
	interface Factory {
	  Call newCall(Request request);
	}
###### 4.4 同步|异步执行请求

	//同步执行
	@Override 
	public Response execute() throws IOException {
	    synchronized (this) {
	      if (executed) throw new IllegalStateException("Already Executed");
	      executed = true;
	    }
		...
		//省略不重要的代码
		...
	    try {
		  // 调用分发器的executed方法,看回 -> 3.1.2 Dispatcher
	      client.dispatcher().executed(this);
		  // 经过一系列的拦截器,下篇细讲
	      Response result = getResponseWithInterceptorChain();
	      if (result == null) throw new IOException("Canceled");
	      return result;
	    } finally {
	      client.dispatcher().finished(this);
	    }
	  }
	  //异步执行
	@Override 
	public void enqueue(Callback responseCallback) {
	    synchronized (this) {
	      if (executed) throw new IllegalStateException("Already Executed");
	      executed = true;
	    }
	    captureCallStackTrace();
		// 调用分发器的enqueue方法,看回 -> 3.1.2 Dispatcher
	    client.dispatcher().enqueue(new AsyncCall(responseCallback));
	}
异步执行,我们还需抽丝剥茧AsyncCall,AsyncCall是RealCall的内部类,继承了类NamedRunnable(实现了Runnable接口):
	//给线程设置名字的Runnable实现类
	public abstract class NamedRunnable implements Runnable {
	  protected final String name;
	
	  public NamedRunnable(String format, Object... args) {
	    this.name = Util.format(format, args);
	  }
	
	  @Override 
	  public final void run() {
		//设置线程名字
	    String oldName = Thread.currentThread().getName();
	    Thread.currentThread().setName(name);
	    try {
	      execute();
	    } finally {
		  //最后又将名字设置回去
	      Thread.currentThread().setName(oldName);
	    }
	  }
	
	  protected abstract void execute();
	}
接着着重看AsyncCall的execute()方法:

    @Override 
    protected void execute() {
      boolean signalledCallback = false;
      try {
		// 经过一系列的拦截器
        Response response = getResponseWithInterceptorChain();
        if (retryAndFollowUpInterceptor.isCanceled()) {
          signalledCallback = true;
          responseCallback.onFailure(RealCall.this, new IOException("Canceled"));
        } else {
          signalledCallback = true;
		  //成功的回调
          responseCallback.onResponse(RealCall.this, response);
        }
      } catch (IOException e) {
        if (signalledCallback) {
          // Do not signal the callback twice!
          Platform.get().log(INFO, "Callback failure for " + toLoggableString(), e);
        } else {
		  //失败的回调
          responseCallback.onFailure(RealCall.this, e);
        }
      } finally {
        client.dispatcher().finished(this);
      }
    }

##### 4 总结
通过上文我们已经对OkHttp的执行流程了然于心了,但是还有一个非常重要的方法-> getResponseWithInterceptorChain待剖析,下一篇见!