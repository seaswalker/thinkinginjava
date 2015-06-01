package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 检测一个句子是否以大写字母开头并且句号结尾
 * @author skywalker
 *
 */
public class Test7 {

	public static void main(String[] args) {
		//注意中间是.而不是//w因为有空格
		Pattern pattern = Pattern.compile("^[A-Z].*\\.$");
		Matcher matcher = pattern.matcher("Hello world.");
		if(matcher.matches()) {
			System.out.println("句子通过！");
		}else {
			System.out.println("不符合");
		}
	}
}
