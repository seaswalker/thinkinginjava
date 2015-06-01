package containers;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 自己实现的set
 * @author skywalker
 * @param <E>
 *
 */
public class MySet<E> extends AbstractSet<E> {
	
	private List<E> list = new LinkedList<E>();
	
	@Override
	public boolean add(E e) {
		if(!list.contains(e)) {
			list.add(e);
			return true;
		}
		return false;
	}
	
	@Override
	public boolean remove(Object o) {
		return list.remove(o);
	}

	@Override
	public Iterator<E> iterator() {
		return list.iterator();
	}

	@Override
	public int size() {
		return list.size();
	}

	public static void main(String[] args) {
		MySet<Integer> set = new MySet<Integer>();
		for(int i = 0;i < 3;i ++) {
			for(int j = 1;j <= 3;j ++) {
				set.add(j);
			}
		}
		
		Iterator<Integer> iterator = set.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
	
}
