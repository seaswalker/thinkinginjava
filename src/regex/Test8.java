package regex;

import java.util.Arrays;

/**
 * �Ѷ�����the��you���ֿ�
 * @author skywalker
 *
 */
public class Test8 {

	private static String knights = 
			"Then, when you have found the shrubbery, you must " +
		    "cut down the mightiest tree in the forest... " +
		    "with... a herring!";
	
	public static void main(String[] args) {
		//�û��������
		String []array = knights.split("the|you");
		System.out.println(Arrays.toString(array));
	}
}
