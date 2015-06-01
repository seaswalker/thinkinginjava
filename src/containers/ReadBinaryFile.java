package containers;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 读取二进制文件
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
	 * 字节数组转为十六进制字符串
	 */
	public static String byteToHex(byte[] array) {
		if(array == null || array.length < 1) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i < array.length;i ++) {
			//注意java的int是32位的
			sb.append(Integer.toHexString(array[i] & 0xFF));
		}
		return sb.toString();
	}
	
}
