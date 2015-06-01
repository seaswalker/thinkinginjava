package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 文件工具类
 * @author skywalker
 *
 */
public class FileUtil {

	/**
	 * 从一个文件读取
	 * @param path 文件绝对路径
	 */
	public static String readFile(String path) throws IOException {
		
		FileInputStream fis = new FileInputStream(new File(path));
		InputStreamReader isr = new InputStreamReader(fis, "GBK");
		BufferedReader br = new BufferedReader(isr);
		String str = null;
		//全部内容
		StringBuilder content = new StringBuilder();
		while((str = br.readLine()) != null) {
			content.append(str).append("\r\n");
		}
		br.close();
		isr.close();
		fis.close();
		return content.toString();
	}
	
}
