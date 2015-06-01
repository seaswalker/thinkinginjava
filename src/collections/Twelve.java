package collections;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * ��ϰ12 (P228)
 * @author skywalker
 *
 */
public class Twelve {

	public static void main(String[] args) {
		List<Integer> first = new ArrayList<Integer>(10);
		List<Integer> second = new ArrayList<Integer>(10);
		
		for(int i = 1;i <= 10;i ++) {
			first.add(i);
		}
		
		//ע���α��λ�ã������������hasPrevious()����false
		ListIterator<Integer> firIterator = first.listIterator(first.size());
		while(firIterator.hasPrevious()) {
			second.add(firIterator.previous());
		}
		
		System.out.println(second);
	}
	
}
