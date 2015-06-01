package regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * �ҳ����в��Դ�д��ĸ��ͷ�Ĵʣ����ظ��ؼ��������
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
		//Ҳ����set���ã���Ϊ�������ظ�
		List<String> finds = new ArrayList<String>();
		while(matcher.find()) {
			if(!finds.contains(matcher.group())) {
				finds.add(matcher.group());
			}
		}
		//9��
		System.out.println("���ҵ�" + finds.size() + "����");
	}
}
