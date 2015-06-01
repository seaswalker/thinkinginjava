package io;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;

/**
 * 测试数据读取
 * @author skywalker
 *
 */
public class DataInputStreamTest {

	public static void main(String[] args) throws IOException {
		DataInputStream dis = new DataInputStream(new ByteArrayInputStream("你好".getBytes()));
		int temp = 0;
		try {
			while((temp = dis.read()) != -1) {
				//字节转char只能对付英文字符中文就跪了，char是unicode，2个字节但是byte是一个字节，中文用2个字节存储
				System.out.print((char) temp);
			}
		}catch(EOFException e) {
			System.out.println("结束了");
		}
	}
	
}
