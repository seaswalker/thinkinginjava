package collections;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

/**
 * ��ϰ28 (P238)
 * @author skywalker
 *
 */
public class Twenty_Eight {

	public static void main(String[] args) {
		//����ȥ��������������
		Queue<Double> queue = new PriorityQueue<Double>(Collections.reverseOrder());
		Random random = new Random();
		for(int i = 0;i < 10;i ++) {
			queue.offer(random.nextDouble());
		}
		
		//��ʾ
		while(queue.peek() != null) {
			System.out.println(queue.poll());
		}
	}
	
}
