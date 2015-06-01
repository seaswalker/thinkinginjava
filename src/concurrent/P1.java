package concurrent;

/**
 * 656页练习1
 * @author skywalker
 *
 */
public class P1 {

	public static void main(String[] args) {
		for(int i = 0;i < 10;i ++) {
			new P1I1();
		}
	}
	
}

class P1I1 implements Runnable {
	
	public P1I1() {
		System.out.println("线程已经初始化");
		new Thread(this).start();
		System.out.println("线程已结束");
	}
	
	@Override
	public void run() {
		for(int i = 0;i < 3;i ++) {
			System.out.println("running...");
			Thread.yield();
		}
	}
	
}
