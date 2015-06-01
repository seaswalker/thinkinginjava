package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * 练习32 (P245)
 * @author skywalker
 *
 */
public class Thirty_Two implements Iterable<Integer> {

	private Integer []eles = null;
	private Random random = new Random();
	
	public Thirty_Two(int count) {
		count = count < 1 ? 1 : count;
		this.eles = new Integer[count];
		for(int i = 0;i < count;i ++) {
			eles[i] = random.nextInt(count);
		}
	}

	@Override
	public Iterator<Integer> iterator() {
		return new Iterator<Integer>() {
			int current = 0;
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
	
	//逆序遍历
	public Iterable<Integer> reversed() {
		return new Iterable<Integer>() {
			
			@Override
			public Iterator<Integer> iterator() {
				return new Iterator<Integer>() {
					int current = eles.length - 1;
					@Override
					public boolean hasNext() {
						return current > -1;
					}
					@Override
					public Integer next() {
						return eles[current --];
					}
				};
			}
		};
	}
	
	//随机读取
	public Iterable<Integer> randomized() {
		return new Iterable<Integer>() {
			
			@Override
			public Iterator<Integer> iterator() {
				//asList()不支持自动装箱
				List<Integer> list = new ArrayList<Integer>(Arrays.asList(eles));
				Collections.shuffle(list, random);
				return list.iterator();
			}
		};
	}
	
	public static void main(String[] args) {
		Thirty_Two thirty_Two = new Thirty_Two(10);
		
		System.out.println("正常遍历:");
		for(Integer i : thirty_Two) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		System.out.println("倒序遍历：");
		for(Integer i : thirty_Two.reversed()) {
			System.out.print(i + " ");
		}
		System.out.println();

		System.out.println("随机遍历：");
		for(Integer i : thirty_Two.randomized()) {
			System.out.print(i + " ");
		}
		
	}
	
}
