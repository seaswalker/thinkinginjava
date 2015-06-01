package containers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * 可选方法
 * @author skywalker
 *
 */
public class Optional {

	public static void main(String[] args) {
		Collection<String> list = new ArrayList<String>();
		Collection<String> collection = Arrays.asList("hello", "world", "fuck");
		list.add("hello");
		//UnSurpportException
		collection.add("hello");
		System.out.println(collection.size());
	}
	
}
