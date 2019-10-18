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