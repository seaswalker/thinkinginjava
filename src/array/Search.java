package array;

import java.util.Arrays;
import java.util.Collections;

/**
 * ���ַ���������
 * @author skywalker
 *
 */
public class Search {

	public static void main(String[] args) {
		//�����鲻���ǻ�������
		Integer[] array = {1, 3, 5, 10, 7, 8, 4};
		Arrays.sort(array, Collections.reverseOrder());
		System.out.println(Arrays.toString(array));
	}
	
	public static void search() {
		int[] array = {1, 3, 5, 10, 7, 8, 4};
		int location = Arrays.binarySearch(array, 4);//-3
		System.out.println("λ����" + location);
	}
	
}
