package collections;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 练习29 (P238)
 * @author skywalker
 *
 */
public class Twenty_Nine {

	public static void main(String[] args) {
		Queue<SomeThing> queue = new PriorityQueue<SomeThing>();
		//不能添加多个实例，没有实现Comparable接口
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
