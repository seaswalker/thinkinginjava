package containers;

import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * 480ҳ��ϰ9
 * @author skywalker
 *
 */
public class TreeSetTest {

	public static void main(String[] args) {
		//��ĸ����Ĭ�����ֵ����򣬼���д������Сд��ǰ��
		SortedSet<String> set = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
		Collections.addAll(set, "balance About Cause dos".split(" "));
		
		System.out.println(set);
	}
	
}
