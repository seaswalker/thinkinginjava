package collections;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import util.FileUtil;

/**
 * ��ϰ21 (P236)
 * ͳ�Ƶ��ʳ��ִ���
 * @author skywalker
 *
 */
public class Twenty_One {

	public static void main(String[] args) throws IOException {
		//������ĸ˳������
		Map<String, Integer> map = new TreeMap<String, Integer>(String.CASE_INSENSITIVE_ORDER);
		//��ȡ����
		String path = "D:/java/eclipse/ThinkinginJava/src/collections/Twelve.java";
		String content = FileUtil.readFile(path);
		
		Pattern pattern = Pattern.compile("\\w+");
		Matcher matcher = pattern.matcher(content);
		
		String word = null;
		while(matcher.find()) {
			word = matcher.group();
			Integer count = map.get(word);
			map.put(word, count == null ? 1 : count + 1);
		}
		
		//�������
		for(String key : map.keySet()) {
			System.out.println(key + "����" + map.get(key) + "��");
		}
		
	}
	
}
