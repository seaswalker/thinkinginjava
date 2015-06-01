package io;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;

/**
 * �������ݶ�ȡ
 * @author skywalker
 *
 */
public class DataInputStreamTest {

	public static void main(String[] args) throws IOException {
		DataInputStream dis = new DataInputStream(new ByteArrayInputStream("���".getBytes()));
		int temp = 0;
		try {
			while((temp = dis.read()) != -1) {
				//�ֽ�תcharֻ�ܶԸ�Ӣ���ַ����ľ͹��ˣ�char��unicode��2���ֽڵ���byte��һ���ֽڣ�������2���ֽڴ洢
				System.out.print((char) temp);
			}
		}catch(EOFException e) {
			System.out.println("������");
		}
	}
	
}
