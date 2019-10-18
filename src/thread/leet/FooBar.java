package thread.leet;

import java.util.concurrent.Semaphore;


/**
 两个不同的线程将会共用一个 FooBar 实例。其中一个线程将会调用 foo() 方法，另一个线程将会调用 bar() 方法。

 请设计修改程序，以确保 "foobar" 被输出 n 次。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/print-foobar-alternately
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
