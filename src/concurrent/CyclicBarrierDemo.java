package concurrent;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * ����CyclicBarrier
 * ��CounterDownLatch����������������԰Ѽ���������reset()����
 * @author skywalker
 *
 */
public class CyclicBarrierDemo {

	public static void main(String[] args) {
		int size = 10;
		CyclicBarrier barrier = new CyclicBarrier(size, new Runnable() {
			//����������ɺ�Ҫ��������
			@Override
			public void run() {
				System.out.println("����BarrierTask��ִ����");
			}
		});
		ExecutorService service = Executors.newCachedThreadPool();
		for(int i = 0;i < size;i ++) {
			service.execute(new BarrierTask(barrier));
		}
		service.shutdown();
	}
	
}

class BarrierTask implements Runnable {
	
	private static Random random = new Random();
	private static int counter = 0;
	private final int id = counter ++;
	private CyclicBarrier barrier;
	
	public BarrierTask(CyclicBarrier barrier) {
		this.barrier = barrier;
	}

	@Override
	public void run() {
		try {
			TimeUnit.MILLISECONDS.sleep(random.nextInt(10) * 100);
			System.out.println("BarrierTask:" + id + "���");
			//�ȴ���������
			barrier.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
	
}
