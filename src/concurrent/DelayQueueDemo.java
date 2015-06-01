package concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DelayQueueDemo {

	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		DelayQueue<DelayTask> tasks = new DelayQueue<DelayTask>();
		Random random = new Random();
		DelayTask task = null;
		for(int i = 0;i < 10;i ++) {
			task = new DelayTask(random.nextInt(1000));
			tasks.add(task);
			//service.execute(task);
		}
		service.execute(new DelayConsumer(tasks));
		DelayTask.initOrder();
		service.shutdown();
	}
	
}

/**
 * 延时任务消费
 * @author skywalker
 *
 */
class DelayConsumer implements Runnable {
	
	private DelayQueue<DelayTask> tasks;
	
	public DelayConsumer(DelayQueue<DelayTask> tasks) {
		this.tasks = tasks;
	}

	@Override
	public void run() {
		try {
			while(!Thread.interrupted()) {
				tasks.take().run();
			}
		}catch(InterruptedException e) {
			System.out.println("消费结束");
		}
	}
	
}

class DelayTask implements Runnable, Delayed {
	
	private static int counter = 0;
	private final int id = counter ++;
	//延时时间，单位毫秒
	private int delayTime;
	//到期时间
	private long expire;
	private static List<DelayTask> tasks = new ArrayList<DelayTask>();
	
	public DelayTask(int delayTime) {
		this.delayTime = delayTime;
		this.expire = System.currentTimeMillis() + delayTime;
		tasks.add(this);
	}
	
	@Override
	public void run() {
		try {
			TimeUnit.MILLISECONDS.sleep(delayTime);
			System.out.println(this + "完成 [" + expire + "]");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String toString() {
		return "任务" + id;
	}
	
	@Override
	public long getDelay(TimeUnit unit) {
		return expire - System.currentTimeMillis();
	}

	@Override
	public int compareTo(Delayed o) {
		Delayed delayed = (Delayed) o;
		return getDelay(TimeUnit.MILLISECONDS) > delayed.getDelay(TimeUnit.MILLISECONDS) ? 1 : 
			(getDelay(TimeUnit.MILLISECONDS) < delayed.getDelay(TimeUnit.MILLISECONDS) ? -1 : 0);
	}
	
	public static void initOrder() {
		for(DelayTask task : tasks) {
			System.out.println(task.toString() + task.expire);
		}
	}
	
}
