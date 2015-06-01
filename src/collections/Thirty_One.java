package collections;

import java.util.Iterator;

/**
 * 练习31 (P243)
 * @author skywalker
 *
 */
public class Thirty_One implements Iterable<Integer> {

	private int[] eles = null;
	//当前位置指针
	private int current = 0;
	 
	public Thirty_One(int count) {
		count = count < 1 ? 1 : count;
		this.eles = new int[count];
		for(int i = 0;i < count;i ++) {
			eles[i] = i;
		}
	}

	@Override
	public Iterator<Integer> iterator() {
		return new Iterator<Integer>() {

			@Override
			public boolean hasNext() {
				return current < eles.length;
			}

			@Override
			public Integer next() {
				return eles[current ++];
			}
			
		};
	}
	
	public static void main(String[] args) {
		Thirty_One thirty_One = new Thirty_One(10);
		
		//两种写法都可以
		/*for(Integer i : thirty_One) {
			System.out.println(i);
		}*/
		
		Iterator<Integer> iterator = thirty_One.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
	
}
