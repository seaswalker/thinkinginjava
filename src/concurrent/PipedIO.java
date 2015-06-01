package concurrent;

/**
 * 使用BlockQueue修改管道流
 */
import java.util.concurrent.*;
import java.util.*;

class Sender implements Runnable {
	private Random rand = new Random(47);
	private BlockingQueue<Character> bq;
	
	public Sender(BlockingQueue<Character> bq) {
		this.bq = bq;
	}

	public void run() {
		try {
			while (true)
				for (char c = 'A'; c <= 'z'; c++) {
					bq.add(c);
					TimeUnit.MILLISECONDS.sleep(rand.nextInt(500));
				}
		} catch (InterruptedException e) {
			System.out.println(e + " Sender sleep interrupted");
		}
	}
}

class Receiver implements Runnable {
	private BlockingQueue<Character> bq ;

	public Receiver(BlockingQueue<Character> bq) {
		this.bq = bq;
	}

	public void run() {
		try {
			while (true) {
				System.out.print("Read: " + bq.take() + ", ");
			}
		} catch (InterruptedException e) {
			System.out.print(e + " Receiver read exception");
		}
	}
}

public class PipedIO {
	public static void main(String[] args) throws Exception {
		BlockingQueue<Character> bq = new LinkedBlockingQueue<Character>();
		Sender sender = new Sender(bq);
		Receiver receiver = new Receiver(bq);
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(sender);
		exec.execute(receiver);
		TimeUnit.SECONDS.sleep(4);
		exec.shutdownNow();
	}
} /*
 * Output: (65% match) Read: A, Read: B, Read: C, Read: D, Read: E, Read: F,
 * Read: G, Read: H, Read: I, Read: J, Read: K, Read: L, Read: M,
 * java.lang.InterruptedException: sleep interrupted Sender sleep interrupted
 * java.io.InterruptedIOException Receiver read exception
 */// :~
