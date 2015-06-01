package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 706页练习22
 * @author skywalker
 *
 */
public class P22 {

	public static void main(String[] args) {
		P22I1 p1 = new P22I1();
		ExecutorService executorService = Executors.newCachedThreadPool();
		executorService.execute(new P22I2(p1));
		executorService.execute(new P22I3(p1));
		executorService.shutdown();
		try {
			TimeUnit.MILLISECONDS.sleep(1000);
			executorService.shutdownNow();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}

class P22I1 {
	
	private volatile boolean isFixed = false;

	public boolean isFixed() {
		return isFixed;
	}

	public void setFixed(boolean isFixed) {
		this.isFixed = isFixed;
	}
	
	//等待修理
	public synchronized void waitForFix() throws InterruptedException {
		while(!isFixed) {
			wait();
		}
	}
	
	//等待坏掉
	public synchronized void waitForBroken() throws InterruptedException {
		while(isFixed) {
			wait();
		}
	}
	
	//修理
	public synchronized void fix() {
		isFixed = true;
		System.out.println("被修好了");
		notifyAll();
	}
	
	//坏了
	public synchronized void broke() {
		isFixed = false;
		System.out.println("又特么坏了");
		notifyAll();
	}
	
}

//坏车
class P22I2 implements Runnable {
	private P22I1 p1;

	public P22I2(P22I1 p1) {
		this.p1 = p1;
	}
	
	@Override
	public void run() {
		try {
			while(!Thread.interrupted()) {
				TimeUnit.MILLISECONDS.sleep(100);
				p1.broke();
				//等待修车
				p1.waitForFix();
			}
		} catch (InterruptedException e) {
			System.out.println("由中断退出");
		}
	}
}

//修车
class P22I3 implements Runnable {
	private P22I1 p1;

	public P22I3(P22I1 p1) {
		this.p1 = p1;
	}
	
	@Override
	public void run() {
		try {
			while(!Thread.interrupted()) {
				p1.fix();
				//等待坏车
				p1.waitForBroken();
			}
		}catch(InterruptedException e) {
			System.out.println("修车队退出");
		}
	}
}
