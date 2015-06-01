package concurrent;

/**
 * ≤‚ ‘join∑Ω∑®
 * @author skywalker
 *
 */
public class JoinTest {

	public static void main(String[] args) {
		Sleeper
			jack = new Sleeper("jack", 1000),
			tom = new Sleeper("tom", 1000);
		Joiner
			dock = new Joiner("dock", jack),
			fuck = new Joiner("fuck", tom);
		jack.start();
		tom.start();
		dock.start();
		fuck.start();
		jack.interrupt();
	}
	
}

class Sleeper extends Thread {
	
	private int time = 0;
	
	public Sleeper(String name, int time) {
		super(name);
		this.time = time;
	}
	
	@Override
	public void run() {
		try {
			sleep(time);
		} catch (InterruptedException e) {
			System.out.println("I am interrupted,isInterrupted : " + isInterrupted());
		}
		System.out.println(getName() + " wake up");
	}
	
}

class Joiner extends Thread {
	
	private Sleeper sleeper;
	
	public Joiner(String name, Sleeper sleeper) {
		super(name);
		this.sleeper = sleeper;
	}
	
	@Override
	public void run() {
		try {
			sleeper.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(getName() + " join completed");
	}
	
}
