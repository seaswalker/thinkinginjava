package concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 信号量测试
 * 使用对象池的概念
 * 此例中把信号量可用连接数和可用的对象数联系在一起了
 * @author skywalker
 *
 */
public class SemaphoreDemo {

	public static void main(String[] args) {
		ObjectPool<SemObject> pool = new ObjectPool<SemObject>(SemObject.class, 5);
		ExecutorService service = Executors.newCachedThreadPool();
		for(int i = 0;i < 10;i ++) {
			service.execute(new PoolConsumer<SemObject>(pool));
		}
		service.shutdown();
	}
	
}

/**
 * 对象池消费者
 */
class PoolConsumer<T> implements Runnable {
	
	private ObjectPool<T> pool;

	public PoolConsumer(ObjectPool<T> pool) {
		this.pool = pool;
	}
	
	@Override
	public void run() {
		T item = pool.checkout();
		System.out.println(item + "被使用");
		pool.checkin(item);
	}
	
}

/**
 * 测试用对象
 */
class SemObject {
	
	private static int counter = 0;
	private int id = counter ++;
	
	@Override
	public String toString() {
		return "SemObject : " + id;
	}
	
}

/**
 * 对象池
 * @author skywalker
 */
class ObjectPool<T> {
	
	private List<T> pool = new ArrayList<T>();
	//检出
	private volatile boolean []checkout;
	private int size = 0;
	private Semaphore semaphore;
	
	public ObjectPool(Class<T> clazz, int size) {
		this.size = size;
		this.semaphore = new Semaphore(size, true);
		this.checkout = new boolean[size];
		initPool(clazz);
	}
	
	/**
	 * 初始化对象池
	 */
	private void initPool(Class<T> clazz) {
		try {
			for(int i = 0;i < size;i ++) {
				pool.add(clazz.newInstance());
			}
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取一个对象
	 */
	public T checkout() {
		//请求一个信号量
		try {
			semaphore.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return getItem();
	}
	
	private synchronized T getItem() {
		for(int i = 0;i < size;i ++) {
			if(!checkout[i]) {
				checkout[i] = true;
				return pool.get(i);
			}
		}
		return null;
	}
	
	/**
	 * 存入一个对象
	 */
	public void checkin(T item) {
		if(releaseItem(item)) {
			//释放一个信号量
			semaphore.release();
		}
	}
	
	/**
	 * 释放一个对象(已被线程用完)
	 */
	private synchronized boolean releaseItem(T item) {
		int index = pool.indexOf(item);
		if(index < 0 || !checkout[index]) {
			return false;
		}
		checkout[index] = false;
		return true;
	}
	
}
