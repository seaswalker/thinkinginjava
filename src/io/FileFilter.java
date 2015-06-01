package io;

import java.io.File;
import java.io.FilenameFilter;

/**
 * 文件名过滤器的使用
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
		//使用匿名类
		return directory.listFiles(filter("About"));
	}
	
	/**
	 * 产生一个过滤器，检测文件中是否含有此内容
	 */
	private static FilenameFilter filter(final String filter) {
		return new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				if(name.contains(".")) {
					//不可以使用name，name仅仅是一个文件名，不含路径
					String content = TextFile.read(dir.getAbsolutePath() + "/" + name);
					return content.contains(filter);
				}
				return false;
			}
		};
	}
	
}
