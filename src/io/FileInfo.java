package io;

import java.io.File;

/**
 * 获取文件信息
 * @author skywalker
 *
 */
public class FileInfo {
	
	private static String path = "C:/Users/xsdwe_000/Desktop/进度.txt";

	public static void main(String[] args) {
		File file = new File(path);
		//C:\Users\xsdwe_000\Desktop
		System.out.println("parent : " + file.getParent());
		System.out.println("lastUpdateDate : " + file.lastModified());
		//10 内容为"hello java"单位bytes
		System.out.println("length : " + file.length());
		//这个返回的磁盘分区的大小，此时返回的就是C盘的大小73.2GB
		System.out.println("size: " + file.getTotalSpace());
	}
	
}
