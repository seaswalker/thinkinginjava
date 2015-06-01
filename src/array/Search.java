package array;

import java.util.Arrays;
import java.util.Collections;

/**
 * 二分法搜索测试
 * @author skywalker
 *
 */
public class Search {

	public static void main(String[] args) {
		//此数组不可是基本类型
		Integer[] array = {1, 3, 5, 10, 7, 8, 4};
		Arrays.sort(array, Collections.reverseOrder());
		System.out.println(Arrays.toString(array));
	}
	
	public static void search() {
		int[] array = {1, 3, 5, 10, 7, 8, 4};
		int location = Arrays.binarySearch(array, 4);//-3
		System.out.println("位置是" + location);
	}
	
}
