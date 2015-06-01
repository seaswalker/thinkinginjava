package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 690页练习15
 * @author skywalker
 *
 */
public class P15 {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		P15I2 p = new P15I2();
		for(int i = 1;i <= 3;i ++) {
			executorService.execute(new P15I1(i, p));
		}
		executorService.shutdown();
	}
	
}

class P15I2 {
	
	private Object object = new Object();
	
	public void A() {
		synchronized (object) {
			System.out.println("来自A");
		}
	}
	
	public void B() {
		synchronized (object) {
			System.out.println("来自B");
		}
	}
	
	public void C() {
		synchronized (object) {
			System.out.println("来自C");
		}
	}
	
}

class P15I1 extends Thread {
		
	private int flag = 0;
	private P15I2 p;
	
	public P15I1(int flag, P15I2 p) {
		this.flag = flag;
		this.p = p;
	}
	
	@Override
	public void run() {
		for(int i = 0;i < 5;i ++) {
			if(flag == 1) {
				p.A();
			}else if(flag == 2) {
				p.B();
			}else {
				p.C();
			}
		}
	}
	
}