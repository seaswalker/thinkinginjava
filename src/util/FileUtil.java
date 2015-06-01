package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * �ļ�������
 * @author skywalker
 *
 */
public class FileUtil {

	/**
	 * ��һ���ļ���ȡ
	 * @param path �ļ�����·��
	 */
	public static String readFile(String path) throws IOException {
		
		FileInputStream fis = new FileInputStream(new File(path));
		InputStreamReader isr = new InputStreamReader(fis, "GBK");
		BufferedReader br = new BufferedReader(isr);
		String str = null;
		//ȫ������
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
