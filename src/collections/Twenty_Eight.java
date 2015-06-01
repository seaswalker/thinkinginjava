package collections;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

/**
 * 练习28 (P238)
 * @author skywalker
 *
 */
public class Twenty_Eight {

	public static void main(String[] args) {
		//逆序，去掉参数就是正序
		Queue<Double> queue = new PriorityQueue<Double>(Collections.reverseOrder());
		Random random = new Random();
		for(int i = 0;i < 10;i ++) {
			queue.offer(random.nextDouble());
		}
		
		//显示
		while(queue.peek() != null) {
			System.out.println(queue.poll());
		}
	}
	
}
