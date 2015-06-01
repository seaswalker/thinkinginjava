package containers;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * ��ȡ�������ļ�
 * @author skywalker
 *
 */
public class ReadBinaryFile {

	private static String path = "D:/java/eclipse/Blog/build/classes/blog/controller/AboutController.class";
	
	public static void main(String[] args) throws IOException {
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File(path)));
		byte[] array = new byte[bis.available()];
		bis.read(array);
		bis.close();
		System.out.println(byteToHex(array));
	}
	
	/**
	 * �ֽ�����תΪʮ�������ַ���
	 */
	public static String byteToHex(byte[] array) {
		if(array == null || array.length < 1) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i < array.length;i ++) {
			//ע��java��int��32λ��
			sb.append(Integer.toHexString(array[i] & 0xFF));
		}
		return sb.toString();
	}
	
}
