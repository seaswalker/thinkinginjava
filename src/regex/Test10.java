package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ���Ը���ƥ�����
 * @author skywalker
 *
 */
public class Test10 {

	private static String str = "Java now has regular expressions";
	
	public static void main(String[] args) {
		//���ʱ߽緵��true������\\B�Ǵʱ߽��򷵻�false
		Pattern pattern = Pattern.compile("\\breg.*");
		Matcher matcher = pattern.matcher(str);
		System.out.println(matcher.lookingAt());
	}
}
