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

###### 线程池的主要处理流程
![image](/pictures/线程池任务添加流程.png)