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
 * ��ӡ��һ��Ŀ¼�������������
 * @author skywalker
 *
 */
public class Test19 {
	
	private static int count = 0;

	public static void main(String[] args) {
		File dir = new File("E:/�ĵ�/java/Thinking In Java ��ϰ��� ���İ�/Strings");
		Pattern pattern = Pattern.compile("class[\\s]+(\\w+)");
		//ƥ��ע�ͣ�ע�����ע����ÿһ�п�ͷ��ע�ͣ�����//��*��/*
		Pattern notes = Pattern.compile("//|/\\*|\\*");
		printDir(dir, pattern, notes);
		System.out.println("���ҵ�" + count + "���ࡣ");
	}
	
	/**
	 * ��ӡһ��Ŀ¼
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
	 * ��ӡһ���ļ�
	 */
	private static void printFile(File file, Pattern pattern, Pattern notes) {
		//������ļ�
		Reader reader = null;
		BufferedReader br = null;
		try {
			reader = new FileReader(file);
			br = new BufferedReader(reader);
			String temp = "";
			Matcher matcher = pattern.matcher(temp);
			Matcher notesM = notes.matcher(temp);
			while((temp = br.readLine()) != null) {
				//��ÿһ�н��е���ƥ��
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
