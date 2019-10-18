package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/** FutureTask + callable,Thread依然是载体
 * @Desc
 * @Author lizeng
 * @CreateTime 2019/10/18 17:09
 **/
public class ThirdThread implements Callable<String> {
    public static void main(String[] args) {

        ThirdThread thirdThread = new ThirdThread();
        FutureTask<String> futureTask = new FutureTask<>(thirdThread);
        new Thread(futureTask,"agrs name").start();
        try {
            String s = futureTask.get();
            System.out.println(s);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(2000);
        return Thread.currentThread().getName();
    }
}
