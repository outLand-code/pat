package thread.leet;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * 请你实现一个有四个线程的多线程版  FizzBuzz， 同一个 FizzBuzz 实例会被如下四个线程使用：
 *
 * 线程A将调用 fizz() 来判断是否能被 3 整除，如果可以，则输出 fizz。
 * 线程B将调用 buzz() 来判断是否能被 5 整除，如果可以，则输出 buzz。
 * 线程C将调用 fizzbuzz() 来判断是否同时能被 3 和 5 整除，如果可以，则输出 fizzbuzz。
 * 线程D将调用 number() 来实现输出既不能被 3 整除也不能被 5 整除的数字。
 *

 */
public class FizzBuzz {
    private int n;

    public FizzBuzz(int n) {
        this.n = n;
    }
    Semaphore f =new Semaphore(0);
    Semaphore b =new Semaphore(0);
    Semaphore fb = new Semaphore(0);
    Semaphore nb=new Semaphore(1);
    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        for(int i=3;i<=n;i+=3){
            f.acquire();
            printFizz.run();
            nb.release();
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for(int i=5;i<=n;i+=5){
            b.acquire();
            printBuzz.run();
            nb.release();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for(int i=15;i<=n;i+=15){
            fb.acquire();
            printFizzBuzz.run();
            nb.release();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for(int i=0;i<=n;i++){
            nb.acquire();
            if(i%3==0&&i%5!=0){
                f.release();
            }
            else if(i%5==0&&i%3!=0){
                b.release();
            }
            else if(i>=15&&i%15==0){
                fb.release();
            }
            else{
                printNumber.accept(i);
                nb.release();
            }


        }
    }
}
