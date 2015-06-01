package regex;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 读取java文件中的所有注释
 */
public class Test17 {

	public static void main(String[] args) {
		File file = new File("C:/Users/xsdwe_000/Desktop/CookieUtil.java");
		StringBuffer sb = new StringBuffer();
		Reader reader = null;
		BufferedReader br = null;
		try {
			reader = new FileReader(file);
			br = new BufferedReader(reader);
			String temp = null;
			while((temp = br.readLine()) != null) {
				//BufferReader会丢失换行符
				sb.append(temp).append("\n");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				br.close();
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//System.out.println(sb);
		//打印出所有注释，此处千万不能用贪婪型
		//Pattern pattern = Pattern.compile("(/\\*[\\s\\S]*?\\*/)|(//.*)");
		//或者(?s)/\\*(.)*?\\*/
		Pattern pattern = Pattern.compile("((?s)/\\*(.)*?\\*/)|(//.*)");
		Matcher matcher = pattern.matcher(sb);
		while(matcher.find()) {
			System.out.println(matcher.group());
		}
	}
}
