package concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 测试CountDownLatch
 * @author skywalker
 *
 */
public class CountDownLatchDemo {
	
	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		//初始化被等待任务
		CountDownLatch latch = new CountDownLatch(20);
		for(int i = 0;i < 20;i ++) {
			service.execute(new TaskPortion(latch));
		}
		//等待任务
		for (int i = 0; i < 10; i++) {
			service.execute(new WaitTask(latch));
		}
		service.shutdown();
	}
}

/**
 * 被等待的任务
 * @author skywalker
 *
 */
class TaskPortion implements Runnable {
	
	private static int counter = 0;
	private final int id = counter ++;
	//计数器
	private CountDownLatch latch;
	
	public TaskPortion(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {
		try {
			doWork();
			latch.countDown();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void doWork() throws InterruptedException {
		TimeUnit.MILLISECONDS.sleep(500);
		System.out.println(this + "完成");
	}
	
	@Override
	public String toString() {
		return "TaskPortion:" + id;
	}
	
}

/**
 * 等待的任务
 * @author skywalker
 *
 */
class WaitTask implements Runnable {
	
	private static int counter = 0;
	private final int id = counter ++;
	private CountDownLatch latch;
	
	public WaitTask(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {
		try {
			latch.await();
			System.out.println("WaitTask:" + id + "执行");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
