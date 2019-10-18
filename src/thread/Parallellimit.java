package thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>Title:Parallellimit</p>
 * <p>Description: TODO</p>
 *
 * @author tianxiao.liu
 * @date 2019-10-18 11:26
 */
public class Parallellimit {

    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();
        CountDownLatch latch=new CountDownLatch(100);

        for(int  i =0;i<101;i++){
            es.execute(new CountRunale(latch));
        }
    }
}
