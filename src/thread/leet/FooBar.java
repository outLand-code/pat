package thread.leet;

import java.util.concurrent.Semaphore;


/**
 * <p>Title:FooBar</p>
 * <p>Description: TODO</p>
 *
 * @author tianxiao.liu
 * @date 2019-10-18 11:55
 */
public class FooBar {

    private int n;
    public FooBar(int n) {
        this.n = n;
    }
    Semaphore foo = new Semaphore(1);
    Semaphore bar = new Semaphore(0);


    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printFoo.run() outputs "foo". Do not change or remove this line.
            foo.acquire();
            printFoo.run();
            bar.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printBar.run() outputs "bar". Do not change or remove this line.
            bar.acquire();
            printBar.run();
            foo.release();
        }
    }
}
