package concurrent;

public class VolatiteTest {

	public volatile int inc = 0;

	public void increase() {
		//ԭ�����������������ԭ�Ӳ�����volatite��֤�����޸ĺ���һ�������е�ֵ�����µ�
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
			// ��֤ǰ����̶߳�ִ����
			Thread.yield();
		//һ��С��1000�Ĳ�ȷ������
		System.out.println(test.inc);
	}

}
