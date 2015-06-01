package regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 找出所有不以大写字母开头的词，不重复地计算其个数
 * @author skywalker
 *
 */
public class Test12 {

	private static String poem = 
			"Twas brillig, and the slithy toves\n" +
		    "Did gyre and gimble in the wabe.\n" +
		    "All mimsy were the borogoves,\n" +
		    "And the mome raths outgrabe.\n\n" +
		    "Beware the Jabberwock, my son,\n" +
		    "The jaws that bite, the claws that catch.\n" +
		    "Beware the Jubjub bird, and shun\n" +
		    "The frumious Bandersnatch.";
	
	public static void main(String[] args) {
		Pattern pattern = Pattern.compile("[A-Z]\\w+");
		Matcher matcher = pattern.matcher(poem);
		//也许用set更好，因为不允许重复
		List<String> finds = new ArrayList<String>();
		while(matcher.find()) {
			if(!finds.contains(matcher.group())) {
				finds.add(matcher.group());
			}
		}
		//9个
		System.out.println("共找到" + finds.size() + "个。");
	}
}
