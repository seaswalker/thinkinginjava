package concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * �ź�������
 * ʹ�ö���صĸ���
 * �����а��ź��������������Ϳ��õĶ�������ϵ��һ����
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
 * �����������
 */
class PoolConsumer<T> implements Runnable {
	
	private ObjectPool<T> pool;

	public PoolConsumer(ObjectPool<T> pool) {
		this.pool = pool;
	}
	
	@Override
	public void run() {
		T item = pool.checkout();
		System.out.println(item + "��ʹ��");
		pool.checkin(item);
	}
	
}

/**
 * �����ö���
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
 * �����
 * @author skywalker
 */
class ObjectPool<T> {
	
	private List<T> pool = new ArrayList<T>();
	//���
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
	 * ��ʼ�������
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
	 * ��ȡһ������
	 */
	public T checkout() {
		//����һ���ź���
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
	 * ����һ������
	 */
	public void checkin(T item) {
		if(releaseItem(item)) {
			//�ͷ�һ���ź���
			semaphore.release();
		}
	}
	
	/**
	 * �ͷ�һ������(�ѱ��߳�����)
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
