package improve.concurrent.thread;

/**
 * @Desc 守护线程用于服务用户线程,当程序中不存在用户线程后JVM将会退出,守护线程将会被关闭
 * @Author lizeng
 * @CreateTime 2019/10/30 14:45
 **/
public class DaemonTest {
    public static void main(String[] args) {
        DaemonThread daemonThread = new DaemonThread(true);
        daemonThread.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main thread is over!");
    }
}
