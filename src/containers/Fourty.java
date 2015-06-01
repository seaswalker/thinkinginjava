package containers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 515页练习40
 * @author skywalker
 *
 */
public class Fourty {

	public static void main(String[] args) {
		List<FourtyTest> list = new ArrayList<FourtyTest>();
		list.add(new FourtyTest("A", "a"));
		list.add(new FourtyTest("b", "B"));
		list.add(new FourtyTest("C", "c"));
		
		//Collections.sort(list, Collections.reverseOrder());二分法仅支持正序排序
		Collections.sort(list);
		System.out.println(list);
		//二分查找
		System.out.println(Collections.binarySearch(list, new FourtyTest("b", "B")));
	}
	
}

class FourtyTest implements Comparable<FourtyTest> {
	
	private String str1;
	private String str2;
	
	public FourtyTest(String str1, String str2) {
		this.str1 = str1;
		this.str2 = str2;
	}

	@Override
	public int compareTo(FourtyTest o) {
		return str1.compareTo(o.str1);
	}
	
	@Override
	public String toString() {
		return "str1:" + str1 + ",str2:" + str2;
	}
	
}
