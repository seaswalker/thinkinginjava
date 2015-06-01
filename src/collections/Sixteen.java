package collections;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ��ϰ16 (P233)
 * ͳ��java�ļ���Ԫ����ĸ�ĸ���
 * @author skywalker
 *
 */
public class Sixteen {

	public static void main(String[] args) throws IOException {
		
		//ͳ��Ԫ����ĸ����
		int count = 0;
		//ÿ�������еĸ���
		int perCount = 0;
		
		Set<Character> vowels = new HashSet<Character>();
		vowels.add('a');
		vowels.add('e');
		vowels.add('i');
		vowels.add('o');
		vowels.add('u');
		
		FileInputStream fis = new FileInputStream(new File("D:/java/eclipse/ThinkinginJava/src/collections/Twelve.java"));
		InputStreamReader isr = new InputStreamReader(fis, "GBK");
		BufferedReader br = new BufferedReader(isr);
		String str = null;
		//ȫ������
		StringBuilder content = new StringBuilder();
		while((str = br.readLine()) != null) {
			content.append(str).append("\r\n");
		}
		
		//ƥ�䵥��
		Pattern pattern = Pattern.compile("\\w+");
		Matcher matcher = pattern.matcher(content);
		
		while(matcher.find()) {
			String word = matcher.group();
			for(char c : word.toCharArray()) {
				if(vowels.contains(c)) {
					perCount ++;
				}
			}
			count += perCount;
			System.out.println(word + "����" + perCount + "��Ԫ����ĸ");
			perCount = 0;
		}
		System.out.println("�ܼ�" + count + "��Ԫ����ĸ");
		
		br.close();
		isr.close();
		fis.close();
	}
	
}
