package thread.leet;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.IntConsumer;

/**
 * <p>Title:Test</p>
 * <p>Description: TODO</p>
 *
 * @author tianxiao.liu
 * @date 2019-10-18 11:48
 */
public class Test {

    public static void main(String[] args) {
        FizzBuzz fizzBuzz=new FizzBuzz(15);
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    fizzBuzz.buzz(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("buzz");
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    fizzBuzz.fizz(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("fizz");
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t3=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    fizzBuzz.fizzbuzz(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("fizzbuzz");
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        IntConsumer printNumber=(x)->{
            System.out.println(x);
        };
        Thread t4=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    fizzBuzz.number(printNumber);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }

    public static void foo(){
        Foo foo = new Foo();
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    foo.second(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println(2);
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    foo.first(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println(1);
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    foo.third(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println(3);
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t3.start();
        t2.start();
        t1.start();
    }

    public static void foobar(){
        FooBar fooBar=new FooBar(100);
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    fooBar.foo(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("foo");
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    fooBar.bar(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("bar");
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
    }

    public static void ZeroEvenOdd(){
        ZeroEvenOdd zeroEvenOdd=new ZeroEvenOdd(100);
        IntConsumer NumberPrint = (x) -> { System.out.print(x); };
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    zeroEvenOdd.zero(NumberPrint);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    zeroEvenOdd.odd(NumberPrint);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t3=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    zeroEvenOdd.even(NumberPrint);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t3.start();
        t2.start();
    }

    public static void h2o(){
        H2O h2O=new H2O();

        ExecutorService es = Executors.newCachedThreadPool();

        for(int i=0;i<100;i++){
            es.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        h2O.hydrogen(new Runnable() {
                            @Override
                            public void run() {
                                System.out.print("H");
                            }
                        });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            es.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        h2O.oxygen(new Runnable() {
                            @Override
                            public void run() {
                                System.out.print("O");
                            }
                        });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

        }
    }
}
