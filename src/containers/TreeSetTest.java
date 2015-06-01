package containers;

import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * 480页练习9
 * @author skywalker
 *
 */
public class TreeSetTest {

	public static void main(String[] args) {
		//字母排序，默认是字典排序，即大写总是在小写的前面
		SortedSet<String> set = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
		Collections.addAll(set, "balance About Cause dos".split(" "));
		
		System.out.println(set);
	}
	
}
