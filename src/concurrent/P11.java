package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 678ҳ��ϰ11
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
		//Ӧ����ס���е�ҵ���߼�����
		synchronized (this) {
			while(conductor.hasTicket()) {
				System.out.println(this.getName() + "����һ��Ʊ�� ʣ��" + conductor.purseTicket() + "��");
			}
		}
	}
}

//��Ʊ
class Conductor {
	
	//Ʊ��
	private int tickets =  0;
	
	public Conductor(int tickets) {
		this.tickets = tickets;
	}
	
	//�жϻ���û��Ʊ
	public boolean hasTicket() {
		return tickets > 0;
	}
	
	//��Ʊ
	public int purseTicket() {
		return -- tickets;
	}
	
}
