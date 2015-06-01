package concurrent;

public class VolatiteTest {

	public volatile int inc = 0;

	public void increase() {
		//原因就是自增操作不是原子操作，volatite保证的是修改后，另一个缓存中的值是最新的
		inc++;
	}

	public static void main(String[] args) {
		final VolatiteTest test = new VolatiteTest();
		for (int i = 0; i < 10; i++) {
			new Thread() {
				public void run() {
					for (int j = 0; j < 1000; j++)
						test.increase();
				};
			}.start();
		}

		while (Thread.activeCount() > 1)
			// 保证前面的线程都执行完
			Thread.yield();
		//一个小于1000的不确定的数
		System.out.println(test.inc);
	}

}
