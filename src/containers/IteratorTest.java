package containers;

import java.util.Collections;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * 测试游标的指针位置
 * @author skywalker
 *
 */
public class IteratorTest {

	public static void main(String[] args) {
		SortedSet<String> set = new TreeSet<String>();
		Collections.addAll(set, "one two three four five six seven egiht".split(" "));
		Iterator<String> iterator = set.iterator();
		String low = null;
		String high = null;
		for(int i = 0;i <= 6;i ++) {
			if(i == 3) {
				low = iterator.next();
			}else if(i == 6) {
				high = iterator.next();
			}else {
				iterator.next();
			}
		}
		System.out.println("low:" + low);
		System.out.println("high:" + high);
	}
	
}
