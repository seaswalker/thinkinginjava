package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * ����java�д������ؽ���
 * @author skywalker
 *
 */
public class ProcessTest {

	public static void main(String[] args) throws IOException {
		//��������Ҫ��Ϊ�ӿո񣬾�����cmd������Ҫ��
		//Process process = new ProcessBuilder("cmd", "/k" ,"systeminfo").start();
		//����д����һ�µģ����Ǵ��ֲ�֧�ֿɱ�����
		Process process = Runtime.getRuntime().exec(new String[] {"cmd", "/c", "java", "-version"});
		BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
		String temp = null;
		while((temp = br.readLine()) != null) {
			System.out.println(temp);
		}
		
		BufferedReader brError = new BufferedReader(new InputStreamReader(process.getErrorStream()));
		while((temp = brError.readLine()) != null) {
			System.out.println(temp);
		}
	}
	
}
