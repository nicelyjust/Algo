##### 线程池的优势
Android开发中主线程不能执行耗时任务,耗时以及IO操作都需要通过异步来处理
1. 降低系统资源消耗,通过重用已存在的线程,降低线程创建和销毁造成的消耗;
2. 提高系统的响应速度,当有任务来时,无需等待新线程的创建便能立即执行;
3. 方便线程并发数量的管控以及线程池提供了更强大的功能;
##### 线程池核心类:ThreadPoolExecutor
我们通过ThreadPoolExecutor来创建一个线程池.

    ExecutorService service = new ThreadPoolExecutor(....);
     public ThreadPoolExecutor(int corePoolSize,
         int maximumPoolSize,
         long keepAliveTime,
         TimeUnit unit,
         BlockingQueue<Runnable> workQueue,
         ThreadFactory threadFactory,
         RejectedExecutionHandler handler)

###### ThreadPoolExecutor构造函数参数意义
- corePoolSize:核心线程数,默认情况下核心线程会一直存活在线程池里
- maximumPoolSize:线程池所容纳的最大线程数,核心线程数+非核心线程数
- keepAliveTime:非核心闲置的超时时长
- workQueue:线程池中保存等待执行的任务的阻塞队列
- threadFactory:创建新线程,线程工厂
- handler:异常处理器

##### 线程池的主要处理流程
![image](https://github.com/nicelyjust/Algo/blob/release/v1.0.0/pictures/threadPool.jpg)
##### 四种线程池类
1. newFixedThreadPool:全都是核心线程数,处于空闲状态的线程也不会被回收,除非这个线程池被关闭,任务队列也无大小限制

       public static ExecutorService newFixedThreadPool(int nThreads) {
           return new ThreadPoolExecutor(nThreads, nThreads,
                                          0L, TimeUnit.MILLISECONDS,
                                          new LinkedBlockingQueue<Runnable>());
       }
2. newCachedThreadPool:无核心线程,限制60s的线程将会被回收,SynchronousQueue相当于一个空集合
        
       public static ExecutorService newCachedThreadPool() {
       return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                                      60L, TimeUnit.SECONDS,
                                      new SynchronousQueue<Runnable>());
       }
3. newScheduledThreadPool:核心线程固定,非核心线程无固定,空闲时就会被回收
    
       public ScheduledThreadPoolExecutor(int corePoolSize) {
         super(corePoolSize, Integer.MAX_VALUE, 0, NANOSECONDS,
               new DelayedWorkQueue());
       }
       // 延迟一段时间执行
       service.schedule(new Runnable() {
        public void run() {
          
        }
       }, 3, TimeUnit.SECONDS);
       // 每隔一段时间重复执行
       service.scheduleAtFixedRate(new Runnable() {
          public void run() {
          }
       }, 3, 2, TimeUnit.SECONDS);
4. newSingleThreadExecutor:

       public static ExecutorService newSingleThreadExecutor() {
         return new FinalizableDelegatedExecutorService
             (new ThreadPoolExecutor(1, 1,
                                    0L, TimeUnit.MILLISECONDS,
                                    new LinkedBlockingQueue<Runnable>()));
       }
