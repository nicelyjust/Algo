package improve.concurrent.thread;

/**
 * @Desc 实现runnable接口
 * @Author lizeng
 * @CreateTime 2019/10/18 16:52
 **/
public class SecondThread implements Runnable{
    public static void main(String[] args) {
        Thread thread = new Thread(new SecondThread());
        thread.start();
    }
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0)
                System.out.println(Thread.currentThread().getName() + "  " + i);
        }
    }
}
