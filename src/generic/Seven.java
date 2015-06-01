package generic;

import java.util.Iterator;

/**
 * 练习7 (P361)
 * 面向对象的适配器模式
 * @author skywalker
 *
 */
public class Seven implements Iterable<Integer> {
	
	private Fibonacci fibonacci = new Fibonacci();
	private int n;
	public Seven(int n) {
		this.n = n;
	}
	
	@Override
	public Iterator<Integer> iterator() {
		return new Iterator<Integer>() {

			@Override
			public boolean hasNext() {
				return n > 0;
			}

			@Override
			public Integer next() {
				n --;
				return fibonacci.next();
			}
			
		};
	}
	
	public static void main(String[] args) {
		for(Integer i : new Seven(10)) {
			System.out.println(i);
		}
	}

}

class Fibonacci {
	private int count = 0;

	public Integer next() {
		return fib(count++);
	}

	private int fib(int n) {
		if (n < 2)
			return 1;
		return fib(n - 2) + fib(n - 1);
	}

	public static void main(String[] args) {
		Fibonacci gen = new Fibonacci();
		for (int i = 0; i < 18; i++)
			System.out.print(gen.next() + " ");
	}
}
