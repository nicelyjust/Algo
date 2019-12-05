package improve.concurrent.keyword;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Desc
 * @Author lizeng
 * @CreateTime 2019/10/30 16:09
 **/
public class TicketRunnable implements Runnable{
    /*private int num = 50;
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (TicketRunnable.class) {
                if (num > 0) {
                    System.out.println(Thread.currentThread().getName() + ".....sale...." + num--);
                }
            }
        }
    }*/
    //volatile不能保证原子性,保证可见性以及禁止指令重排
    private volatile int num = 100;
    AtomicInteger atomicInteger = new AtomicInteger(num);
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (atomicInteger.get() > 0) {
                System.out.println(Thread.currentThread().getName() + ".....sale...." + atomicInteger.getAndDecrement());
            } else{
                break;
            }
        }
    }
}
