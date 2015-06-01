package concurrent;

/**
 * Ä£·Â·¢Éä
 * @author skywalker
 *
 */
public class LiftOff extends Thread {
	
	private static int counter = 0;
	private int id = 0;
	
	public LiftOff() {
		this.id = counter;
		counter ++;
	}

	@Override
	public void run() {
		String str = null;
		for(int i = counter;i >= 0;i --) {
			str = (i == 0) ? "liftoff!" : Integer.toString(i);
			System.out.println("#" + id + "(" + str + "),");
			Thread.yield();
		}
	}
	
}
