package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * appendReplacement的用法
 * @author skywalker
 *
 */
public class Test11 {

	private static String str = "I am sabi, where are you from?";
	
	public static void main(String[] args) {
		Pattern pattern = Pattern.compile("[aeiou]");
		Matcher matcher = pattern.matcher(str);
		StringBuffer sb = new StringBuffer();
		while(matcher.find()) {
			matcher.appendReplacement(sb, matcher.group().toUpperCase());
		}
		//存入最后一次匹配到结尾之间的内容，否则此处m?就没了
		matcher.appendTail(sb);
		System.out.println(sb);
	}
}
