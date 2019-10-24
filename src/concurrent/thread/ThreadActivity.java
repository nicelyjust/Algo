package concurrent.thread;

/** 线程的相关方法:join
 * @Desc
 * @Author lizeng
 * @CreateTime 2019/10/24 16:37
 **/
public class ThreadActivity extends Thread{
    public ThreadActivity(String name) {
        super(name);
    }

    public static void main(String[] args) {
        new ThreadActivity("新线程").start();
        for (int i = 0; i < 100; i++) {
            if (i == 20) {
                ThreadActivity threadActivity = new ThreadActivity("Join线程");
                threadActivity.start();
                try {
                    threadActivity.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(currentThread().getName() + "  ,第" + i + "执行");
        }

    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getName() + "  ,第" + i + "执行");
        }
    }
}
