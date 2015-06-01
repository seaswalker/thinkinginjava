package containers;

import java.util.Iterator;
import java.util.LinkedList;


/**
 * 480页 练习10 使用LinkedList实现SortedSet
 * @author skywalker
 *
 */
public class MySortedSet<E> extends LinkedList<E>  {

	private static final long serialVersionUID = 8386097335085732308L;
	private int index = 0;

	private int compare(E e1, E e2) {
		return e1.hashCode() - e2.hashCode();
	}
	
	public boolean add(E e) {
		if(!contains(e)) {
			Iterator<E> iterator = iterator();
			while(iterator.hasNext()) {
				if(compare(iterator.next(), e) < 0) {
					index ++;
				}
			}
			add(index, e);
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		MySortedSet<Integer> set1 = new MySortedSet<Integer>();
		set1.add(10);
		set1.add(9);
		set1.add(4);
		set1.add(5);
		
		System.out.println(set1);
		
		MySortedSet<String> set2 = new MySortedSet<String>();
		set2.add("Tom");
		set2.add("Jack");
		set2.add("Fuck");
		System.out.println(set2);
		System.out.println("Tom".hashCode());
		System.out.println("Jack".hashCode());
		System.out.println("Fuck".hashCode());
	}
	
}
