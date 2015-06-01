package io;

import java.io.File;
import java.io.FilenameFilter;

/**
 * �ļ�����������ʹ��
 * @author skywalker
 *
 */
public class FileFilter {
	
	private static String path = "D:/java/eclipse/Blog/src/blog/controller";

	public static void main(String[] args) {
		File directory = new File(path);
		File[] javaFiles = getFileNames(directory);
		for(File temp : javaFiles) {
			System.out.println(temp.getName());
		}
	}
	
	private static File[] getFileNames(File directory) {
		//ʹ��������
		return directory.listFiles(filter("About"));
	}
	
	/**
	 * ����һ��������������ļ����Ƿ��д�����
	 */
	private static FilenameFilter filter(final String filter) {
		return new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				if(name.contains(".")) {
					//������ʹ��name��name������һ���ļ���������·��
					String content = TextFile.read(dir.getAbsolutePath() + "/" + name);
					return content.contains(filter);
				}
				return false;
			}
		};
	}
	
}
