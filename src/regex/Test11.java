package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * appendReplacement���÷�
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
		//�������һ��ƥ�䵽��β֮������ݣ�����˴�m?��û��
		matcher.appendTail(sb);
		System.out.println(sb);
	}
}
