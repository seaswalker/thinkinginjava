package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ���һ�������Ƿ��Դ�д��ĸ��ͷ���Ҿ�Ž�β
 * @author skywalker
 *
 */
public class Test7 {

	public static void main(String[] args) {
		//ע���м���.������//w��Ϊ�пո�
		Pattern pattern = Pattern.compile("^[A-Z].*\\.$");
		Matcher matcher = pattern.matcher("Hello world.");
		if(matcher.matches()) {
			System.out.println("����ͨ����");
		}else {
			System.out.println("������");
		}
	}
}
