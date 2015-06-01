package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 706ҳ��ϰ22
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
	
	//�ȴ�����
	public synchronized void waitForFix() throws InterruptedException {
		while(!isFixed) {
			wait();
		}
	}
	
	//�ȴ�����
	public synchronized void waitForBroken() throws InterruptedException {
		while(isFixed) {
			wait();
		}
	}
	
	//����
	public synchronized void fix() {
		isFixed = true;
		System.out.println("���޺���");
		notifyAll();
	}
	
	//����
	public synchronized void broke() {
		isFixed = false;
		System.out.println("����ô����");
		notifyAll();
	}
	
}

//����
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
				//�ȴ��޳�
				p1.waitForFix();
			}
		} catch (InterruptedException e) {
			System.out.println("���ж��˳�");
		}
	}
}

//�޳�
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
				//�ȴ�����
				p1.waitForBroken();
			}
		}catch(InterruptedException e) {
			System.out.println("�޳����˳�");
		}
	}
}
