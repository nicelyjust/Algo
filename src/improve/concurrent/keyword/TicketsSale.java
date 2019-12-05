package improve.concurrent.keyword;

/**
 * @Desc
 * @Author lizeng
 * @CreateTime 2019/10/30 16:30
 **/
public class TicketsSale {
    public static void main(String[] args) {
        TicketRunnable t = new TicketRunnable();
        Thread thread1 = new Thread(t);
        Thread thread2 = new Thread(t);
        Thread thread3 = new Thread(t);
        Thread thread4 = new Thread(t);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
