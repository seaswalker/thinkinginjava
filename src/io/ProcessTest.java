package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 测试java中创建本地进程
 * @author skywalker
 *
 */
public class ProcessTest {

	public static void main(String[] args) throws IOException {
		//参数不需要人为加空格，尽管在cmd中是需要的
		//Process process = new ProcessBuilder("cmd", "/k" ,"systeminfo").start();
		//两种写法是一致的，但是此种不支持可变数组
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
