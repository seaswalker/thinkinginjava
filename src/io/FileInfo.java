package io;

import java.io.File;

/**
 * ��ȡ�ļ���Ϣ
 * @author skywalker
 *
 */
public class FileInfo {
	
	private static String path = "C:/Users/xsdwe_000/Desktop/����.txt";

	public static void main(String[] args) {
		File file = new File(path);
		//C:\Users\xsdwe_000\Desktop
		System.out.println("parent : " + file.getParent());
		System.out.println("lastUpdateDate : " + file.lastModified());
		//10 ����Ϊ"hello java"��λbytes
		System.out.println("length : " + file.length());
		//������صĴ��̷����Ĵ�С����ʱ���صľ���C�̵Ĵ�С73.2GB
		System.out.println("size: " + file.getTotalSpace());
	}
	
}
