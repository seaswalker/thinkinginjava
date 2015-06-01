package regex;

import java.util.Arrays;

/**
 * 把段落在the和you处分开
 * @author skywalker
 *
 */
public class Test8 {

	private static String knights = 
			"Then, when you have found the shrubbery, you must " +
		    "cut down the mightiest tree in the forest... " +
		    "with... a herring!";
	
	public static void main(String[] args) {
		//用或操作就行
		String []array = knights.split("the|you");
		System.out.println(Arrays.toString(array));
	}
}
