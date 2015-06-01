package containers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 测试Collections的此方法
 * @author skywalker
 *
 */
public class MaxMin {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("hello");
		list.add("world");
		
		System.out.println(Collections.max(list));
	}
	
}
