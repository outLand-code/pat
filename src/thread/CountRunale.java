package thread;

import java.util.concurrent.CountDownLatch;

/**
 * <p>Title:CountRunale</p>
 * <p>Description: TODO</p>
 *
 * @author tianxiao.liu
 * @date 2019-10-18 11:23
 */
public class CountRunale implements Runnable {

    private CountDownLatch countDownLatch;

    public CountRunale(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {

        try {
//            synchronized (countDownLatch) {
                /*** 每次减少一个容量*/
                countDownLatch.countDown();
                System.out.println("thread counts = "+Thread.currentThread().toString()+"==" + (countDownLatch.getCount()));
                Thread.sleep(1000);
//            }
            countDownLatch.await();
            System.out.println("concurrency counts = " + (100 - countDownLatch.getCount()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
