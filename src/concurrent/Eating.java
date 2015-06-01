package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 哲学家进餐问题
 * 已成功死锁
 * @author skywalker
 *
 */
public class Eating {

	public static void main(String[] args) {
		Chopstick c1 = new Chopstick();
		Chopstick c2 = new Chopstick();
		Chopstick c3 = new Chopstick();
		Chopstick c4 = new Chopstick();
		Chopstick c5 = new Chopstick();
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		executorService.execute(new Person(c1, c5, 1));
		executorService.execute(new Person(c2, c1, 2));
		executorService.execute(new Person(c3, c2, 3));
		executorService.execute(new Person(c4, c3, 4));
		executorService.execute(new Person(c5, c4, 5));
		executorService.shutdown();
	}
	
}

/**
 * 哲学家
 * @author skywalker
 *
 */
class Person implements Runnable {
	
	private Chopstick right;
	private Chopstick left;
	private int id = 0;
	
	public Person(Chopstick right, Chopstick left, int id) {
		this.right = right;
		this.left = left;
		this.id = id;
	}
	
	@Override
	public void run() {
		try {
			while(!Thread.interrupted()) {
				//首先拿右边的筷子
				right.take();
				left.take();
				System.out.println("哲学家" + id + "正在吃饭...");
				TimeUnit.MILLISECONDS.sleep(500);
				System.out.println("哲学家" + id + "吃完了");
				right.drop();
				left.drop();
			}
		}catch(InterruptedException e) {
			System.out.println("哲学家被打断");
		}
	}
	
}

class Chopstick {
	private volatile boolean isTaken = false;
	
	public synchronized void take() throws InterruptedException {
		while(isTaken) {
			wait();
		}
		isTaken = true;
	}
	
	public synchronized void drop() {
		isTaken = false;
		notify();
	}
}
