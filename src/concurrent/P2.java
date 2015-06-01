package concurrent;

/**
 * 656页练习2
 * @author skywalker
 *
 */
public class P2 {

	public static void main(String[] args) {
		for(int i = 1;i <= 10;i ++) {
			new Thread(new P2I1(i)).start();
		}
	}
	
}

class P2I1 implements Runnable {
	
	private int n = 0;
	
	private int getNum(int n) {
		if(n == 1 || n == 2) {
			return 1;
		}
		return getNum(n - 1) + getNum(n - 2);
	}
	
	public P2I1(int n) {
		this.n = n;
	}

	@Override
	public void run() {
		System.out.println("第" + n + "个数字是" + getNum(n));
	}
	
}
