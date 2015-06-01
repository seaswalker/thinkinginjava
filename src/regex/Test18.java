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
 * ��ӡ��һ��java�ļ������е���ͨ(��ע��)�ַ���
 * ������17�Ļ����ϰ�ƥ������ݻ��ɿմ�������
 * @author skywalker
 *
 */
public class Test18 {

	public static void main(String[] args) {
		//File file = new File("C:/Users/xsdwe_000/Desktop/CookieUtil.java");
		File file = new File("C:/Strings/Ex5(2).java");
		StringBuffer sb = new StringBuffer();
		Reader reader = null;
		BufferedReader br = null;
		try {
			reader = new FileReader(file);
			br = new BufferedReader(reader);
			String temp = null;
			while((temp = br.readLine()) != null) {
				//BufferReader�ᶪʧ���з�
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
		Pattern pattern = Pattern.compile("((?s)/\\*(.)*?\\*/)|(//.*)");
		Matcher matcher = pattern.matcher(sb);
		StringBuffer result = new StringBuffer();
		while(matcher.find()) {
			matcher.appendReplacement(result, "");
		}
		matcher.appendTail(result);
		System.out.println(result);
	}
}
