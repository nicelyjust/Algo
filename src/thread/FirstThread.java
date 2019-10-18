package thread;

/**
 * @Desc 继承Thread,实现run方法,Thread实现了runnable接口
 * @Author lizeng
 * @CreateTime 2019/10/18 16:06
 **/
public class FirstThread extends Thread{
    public static void main(String[] args) {
        FirstThread firstThread = new FirstThread();
        firstThread.start();
    }

    private int i = 0;

    @Override
    public void run() {
        for (; i < 100; i++) {
            if (i % 2 == 0)
                System.out.println(getName() + "  " + i);
        }
    }
}
