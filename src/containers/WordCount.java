package containers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import util.FileUtil;

/**
 * 484ҳ��ϰ13 ͳ�Ƶ��ʳ��ֵĸ���
 * @author skywalker
 *
 */
public class WordCount {

	public static void main(String[] args) {
		//ע�����ʱ���ļ����Ƶ����棬�������治�У���֪��Ϊ��
		String path = "C:/Users/xsdwe_000/Desktop/Enlish.txt";
		//���浥���Լ����ֵĴ���
		Map<String, Integer> map = new HashMap<String, Integer>();
		try {
			String content = FileUtil.readFile(path);
			Pattern pattern = Pattern.compile("\\b\\w+\\b");
			Matcher matcher = pattern.matcher(content);
			
			String word = null;
			while(matcher.find()) {
				word = matcher.group();
				if(map.containsKey(word)) {
					//ʹ�ô˷����ı�value
					map.replace(word, map.get(word) + 1);
				}else {
					map.put(word, 1);
				}
			}
			
			//�������
			for(String key : map.keySet()) {
				System.out.println(key + "������" + map.get(key) + "�Ρ�");
			}
		} catch (IOException e) {
			System.out.println("�ļ�·������");
		}
		
	}
	
}
