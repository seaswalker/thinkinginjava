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
 * 练习16 (P233)
 * 统计java文件中元音字母的个数
 * @author skywalker
 *
 */
public class Sixteen {

	public static void main(String[] args) throws IOException {
		
		//统计元音字母总数
		int count = 0;
		//每个单词中的个数
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
		//全部内容
		StringBuilder content = new StringBuilder();
		while((str = br.readLine()) != null) {
			content.append(str).append("\r\n");
		}
		
		//匹配单词
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
			System.out.println(word + "含有" + perCount + "个元音字母");
			perCount = 0;
		}
		System.out.println("总计" + count + "个元音字母");
		
		br.close();
		isr.close();
		fis.close();
	}
	
}
