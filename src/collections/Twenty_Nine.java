package collections;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * ��ϰ29 (P238)
 * @author skywalker
 *
 */
public class Twenty_Nine {

	public static void main(String[] args) {
		Queue<SomeThing> queue = new PriorityQueue<SomeThing>();
		//������Ӷ��ʵ����û��ʵ��Comparable�ӿ�
		queue.offer(new SomeThing());
		queue.offer(new SomeThing());
		System.out.println("success," + queue.size());
	}
	
}

class SomeThing implements Comparable<SomeThing> {

	@Override
	public int compareTo(SomeThing o) {
		return 0;
	}
	
}
