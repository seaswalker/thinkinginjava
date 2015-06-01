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
 * 打印出一个目录下所有类的名字
 * @author skywalker
 *
 */
public class Test19 {
	
	private static int count = 0;

	public static void main(String[] args) {
		File dir = new File("E:/文档/java/Thinking In Java 练习题答案 第四版/Strings");
		Pattern pattern = Pattern.compile("class[\\s]+(\\w+)");
		//匹配注释，注意这个注释是每一行开头的注释，比如//或*或/*
		Pattern notes = Pattern.compile("//|/\\*|\\*");
		printDir(dir, pattern, notes);
		System.out.println("共找到" + count + "个类。");
	}
	
	/**
	 * 打印一个目录
	 */
	private static void printDir(File dir, Pattern pattern, Pattern notes) {
		if(!dir.isDirectory()) {
			printFile(dir, pattern, notes);
		}else {
			File[] files = dir.listFiles();
			for(File temp : files) {
				if(temp.isDirectory()) {
					printDir(temp, pattern, notes);
				}else {
					printFile(temp, pattern, notes);
				}
			}
		}
	}
	
	/**
	 * 打印一个文件
	 */
	private static void printFile(File file, Pattern pattern, Pattern notes) {
		//如果是文件
		Reader reader = null;
		BufferedReader br = null;
		try {
			reader = new FileReader(file);
			br = new BufferedReader(reader);
			String temp = "";
			Matcher matcher = pattern.matcher(temp);
			Matcher notesM = notes.matcher(temp);
			while((temp = br.readLine()) != null) {
				//对每一行进行单独匹配
				matcher.reset(temp);
				notesM.reset(temp);
				while(matcher.find() && !notesM.find()) {
					count ++;
					System.out.println(matcher.group(1));
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				reader.close();
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
