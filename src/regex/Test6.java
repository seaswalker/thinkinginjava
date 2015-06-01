package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test6 {

	public static void main(String[] args) {
		Pattern pattern = Pattern.compile("(\\d+,)(\\d+)");
		Matcher matcher = pattern.matcher("234,45-67,432");
		while(matcher.find()) {
			//输出匹配的全部内容，等价于group(0)
			System.out.println(matcher.group());
			//第一组
			System.out.println(matcher.group(1));
			//第二组
			System.out.println(matcher.group(2));
			System.out.println("--------------");
		}
	}
}
