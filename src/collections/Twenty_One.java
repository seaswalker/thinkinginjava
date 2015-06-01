package collections;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import util.FileUtil;

/**
 * 练习21 (P236)
 * 统计单词出现次数
 * @author skywalker
 *
 */
public class Twenty_One {

	public static void main(String[] args) throws IOException {
		//按照字母顺序排序
		Map<String, Integer> map = new TreeMap<String, Integer>(String.CASE_INSENSITIVE_ORDER);
		//获取内容
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
		
		//遍历输出
		for(String key : map.keySet()) {
			System.out.println(key + "出现" + map.get(key) + "次");
		}
		
	}
	
}
