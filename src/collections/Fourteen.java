package collections;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * 练习14 (P229)
 * @author skywalker
 *
 */
public class Fourteen {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();

		for(int i = 0;i < 10;i ++) {
			ListIterator<Integer> iterator = list.listIterator(list.size() / 2);
			//set方法会报错。。。set方法需要先调用一下next()或者previous()
			iterator.add(i);
			//list.add(list.size() / 2, i);
		}
		
		System.out.println(list);
	}
	
}
