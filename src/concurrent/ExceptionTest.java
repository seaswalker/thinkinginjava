package concurrent;

import java.util.concurrent.ThreadFactory;

/**
 * 测试异常
 * @author skywalker
 *
 */
public class ExceptionTest {

	public static void main(String[] args) {
		ET et = new ET();
		et.setUncaughtExceptionHandler(new Handler());
		et.start();
	}
	
}

class ET extends Thread {
	
	@Override
	public void run() {
		throw new RuntimeException();
	}
	
}

class Handler implements Thread.UncaughtExceptionHandler {

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.out.println("被我抓到了");
	}
	
}

/**
 * 线程工厂
*/
class MyThreadFactory implements ThreadFactory {

	@Override
	public Thread newThread(Runnable r) {
		return new Thread(r);
	}
	
}