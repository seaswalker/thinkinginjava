package regex;

import java.util.Arrays;

/**
 * 使用String类的split方法重写SplitDemo
 * @author skywalker
 *
 */
public class Test14 {

	private static String input = "This!!unusual use!!of exclamation!!points";
	
	public static void main(String[] args) {
		//System.out.println(Arrays.toString(input.split("!!")));
		//只分割前三个
		System.out.println(Arrays.toString(input.split("!!", 3)));
	}
}
