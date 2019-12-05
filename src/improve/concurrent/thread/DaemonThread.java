package improve.concurrent.thread;

/**
 * @Desc
 * @Author lizeng
 * @CreateTime 2019/10/30 15:03
 **/
public class DaemonThread extends Thread{
    public DaemonThread(boolean on) {
        super("DaemonThread");
        setDaemon(on);
    }

    int i = 0;
    @Override
    public void run() {
        try {
            while (true) {
                System.out.println(Thread.currentThread().getName() + "  " + i);
                i++;
            }
           }finally {
            System.out.println("finally!!!");
        }
    }
}