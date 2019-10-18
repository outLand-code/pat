package thread.leet;

import java.util.concurrent.CountDownLatch;

/**
 * <p>Title:Foo</p>
 * <p>Description: TODO</p>
 *
 * @author tianxiao.liu
 * @date 2019-10-18 10:46
 */
public class Foo {

    private CountDownLatch countDownLatchA;
    private CountDownLatch countDownLatchB;

    public Foo() {
        countDownLatchA = new CountDownLatch(1);
        countDownLatchB = new CountDownLatch(1);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        countDownLatchA.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        // printSecond.run() outputs "second". Do not change or remove this line.
        countDownLatchA.await();
        printSecond.run();
        countDownLatchB.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        // printThird.run() outputs "third". Do not change or remove this line.
        countDownLatchB.await();
        printThird.run();
    }

}
