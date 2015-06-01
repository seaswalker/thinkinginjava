package concurrent;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalTest {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		for(int i = 0;i < 5;i ++) {
			executorService.execute(new TLT());
		}
		executorService.shutdown();
	}
	
}

class TLT implements Runnable {

	@Override
	public void run() {
		for(int i = 0;i < 3;i ++) {
			System.out.println(ThreadLocalHolder.get());
		}
	}
	
}

class ThreadLocalHolder {
	
	private static Random random = new Random();
	
	private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>() {
		protected  synchronized Integer initialValue() {
			return random.nextInt(100);
		};
	};
	
	public static Integer get() {
		return threadLocal.get();
	}
	
}
