package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 706页练习21
 * @author skywalker
 *
 */
public class P21 {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		P21I1 p1 = new P21I1();
		executorService.execute(p1);
		executorService.execute(new P21I2(p1));
		executorService.shutdown();
	}
	
}

class P21I1 implements Runnable {
	
	public synchronized void suspend() {
		try {
			this.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void rssume() {
		this.notify();
	}
	
	@Override
	public void run() {
		System.out.println("我要等待了");
		suspend();
		System.out.println("呵呵哒，我自由了");
	}
}

class P21I2 implements Runnable {
	
	private P21I1 p21i1;
	
	public P21I2(P21I1 p21i1) {
		this.p21i1 = p21i1;
	}
	
	@Override
	public void run() {
		try {
			TimeUnit.MILLISECONDS.sleep(1000);
			p21i1.rssume();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
