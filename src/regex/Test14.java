package regex;

import java.util.Arrays;

/**
 * ʹ��String���split������дSplitDemo
 * @author skywalker
 *
 */
public class Test14 {

	private static String input = "This!!unusual use!!of exclamation!!points";
	
	public static void main(String[] args) {
		//System.out.println(Arrays.toString(input.split("!!")));
		//ֻ�ָ�ǰ����
		System.out.println(Arrays.toString(input.split("!!", 3)));
	}
}
