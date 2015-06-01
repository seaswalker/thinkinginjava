package containers;

import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * ���ȼ����в���
 * @author skywalker
 *
 */
public class PriorityQueueTest {

	public static void main(String[] args) {
		PriorityQueue<PQT> queue = new PriorityQueue<PQT>();
		queue.offer(new PQT(10));
		queue.offer(new PQT(8));
		queue.offer(new PQT(9));
		queue.offer(new PQT(1));
		
		/*while(queue.peek() != null) {
			//����˳�����
			System.out.println(queue.poll());
		}
*/		
		//System.out.println("ֱ�ӵ��ö��е�toString��");
		//�����Ļ����ǲ����ֵ
		//System.out.println(queue);
		
		//Ҳ�ǲ���ʱ��˳��
		Iterator<PQT> iterator = queue.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	} 
	
}

class PQT implements Comparable<PQT> {
	
	private Integer id;
	
	public PQT(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}

	@Override
	public int compareTo(PQT o) {
		return o.getId() > id ? 1 : (o.getId() == id ? 0 : -1);
	}
	
	@Override
	public String toString() {
		return id + "";
	}
	
}
