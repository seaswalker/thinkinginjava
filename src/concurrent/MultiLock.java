package concurrent;

/**
 * 测试一下一个线程可以访问同一个对象的其它同步方法
 * @author skywalker
 *
 */
public class MultiLock {

	public synchronized static void f1(int count) {
		if(count -- > 0) {
			System.out.println("f1 调用 f2 count=" + count);
			f2(count);
		}
	}
	
	public synchronized static void f2(int count) {
		if(count -- > 0) {
			System.out.println("f2 调用 f2 count=" + count);
			f1(count);
		}
	}
	
	public static void main(String[] args) {
		new Thread() {
			@Override
			public void run() {
				f1(10);
			}
		}.start();
	}
	
}
