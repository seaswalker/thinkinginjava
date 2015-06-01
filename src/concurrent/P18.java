package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 699页练习18
 * @author skywalker
 *
 */
public class P18 {

	public static void main(String[] args) throws InterruptedException {
		ExecutorService executorService = Executors.newCachedThreadPool();
		Future<?> future = executorService.submit(new P18I1());
		//此方法必须调用
		executorService.shutdown();
		TimeUnit.MILLISECONDS.sleep(100);
		future.cancel(true);
	}
	
}


class P18I1 implements Runnable {

	@Override
	public void run() {
		try {
			TimeUnit.MILLISECONDS.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("被中断了");
		}
	}
	
}