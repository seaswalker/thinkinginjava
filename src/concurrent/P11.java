package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 678页练习11
 * @author skywalker
 *
 */
public class P11 {

	public static void main(String[] args) {
		ExecutorService es = Executors.newCachedThreadPool();
		Conductor conductor = new Conductor(10);
		P11I1 p = new P11I1(conductor);
		for(int i = 0;i < 4;i ++) {
			es.execute(p);
		}
		es.shutdown();
	}
	
}

class P11I1 extends Thread {
	
	private Conductor conductor;
	
	
	public P11I1(Conductor conductor) {
		this.conductor = conductor;
	}

	@Override
	public void run() {
		//应该锁住所有的业务逻辑代码
		synchronized (this) {
			while(conductor.hasTicket()) {
				System.out.println(this.getName() + "买了一张票， 剩余" + conductor.purseTicket() + "张");
			}
		}
	}
}

//售票
class Conductor {
	
	//票数
	private int tickets =  0;
	
	public Conductor(int tickets) {
		this.tickets = tickets;
	}
	
	//判断还有没有票
	public boolean hasTicket() {
		return tickets > 0;
	}
	
	//买票
	public int purseTicket() {
		return -- tickets;
	}
	
}
