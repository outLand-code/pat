package thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**

 */
public class CountDownLatchTest {

    public static void main(String[] args) {
        final CountDownLatch latch=new CountDownLatch(2);
        System.out.println("主线程");
        ExecutorService es1 = Executors.newSingleThreadExecutor();
        es1.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("第一线程");
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                latch.countDown();
            }
        });
        es1.shutdown();

        ExecutorService es2 = Executors.newSingleThreadExecutor();
        es2.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("第二线程");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                latch.countDown();
            }
        });
        es2.shutdown();
        System.out.println("等待线程");
        ExecutorService es3 = Executors.newSingleThreadExecutor();
        es3.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    latch.await();
                    System.out.println("第三线程");
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                latch.countDown();
            }
        });
        es2.shutdown();
        System.out.println("完毕");
    }
}
