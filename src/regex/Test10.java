package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 测试各种匹配情况
 * @author skywalker
 *
 */
public class Test10 {

	private static String str = "Java now has regular expressions";
	
	public static void main(String[] args) {
		//单词边界返回true，但是\\B非词边界则返回false
		Pattern pattern = Pattern.compile("\\breg.*");
		Matcher matcher = pattern.matcher(str);
		System.out.println(matcher.lookingAt());
	}
}
