package containers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import util.FileUtil;

/**
 * 484页练习13 统计单词出现的个数
 * @author skywalker
 *
 */
public class WordCount {

	public static void main(String[] args) {
		//注意测试时把文件复制到桌面，在这里面不行，不知道为嘛
		String path = "C:/Users/xsdwe_000/Desktop/Enlish.txt";
		//保存单词以及出现的次数
		Map<String, Integer> map = new HashMap<String, Integer>();
		try {
			String content = FileUtil.readFile(path);
			Pattern pattern = Pattern.compile("\\b\\w+\\b");
			Matcher matcher = pattern.matcher(content);
			
			String word = null;
			while(matcher.find()) {
				word = matcher.group();
				if(map.containsKey(word)) {
					//使用此方法改变value
					map.replace(word, map.get(word) + 1);
				}else {
					map.put(word, 1);
				}
			}
			
			//迭代输出
			for(String key : map.keySet()) {
				System.out.println(key + "出现了" + map.get(key) + "次。");
			}
		} catch (IOException e) {
			System.out.println("文件路径有误！");
		}
		
	}
	
}
