package containers;

import java.util.Arrays;
import java.util.List;

/**
 * 474ҳ��ϰ6 ����List����Ŀ�ѡ����
 * @author skywalker
 *
 */
public class ListOptional {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("Tom", "Jack", "Jerry");
		//list.add("Test");
		list.add(1, "shit");
		System.out.println(list);
	}
	
}
