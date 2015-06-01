package nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * ʹ����io�ķ�ʽ��д
 * @author skywalker
 *
 */
public class Test1 {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		File file = new File("C:/Users/xsdwe_000/Desktop/����.txt");
		
		FileChannel chanel = new FileOutputStream(file).getChannel();
		ByteBuffer buffer = ByteBuffer.wrap("hello nio".getBytes());
		chanel.write(buffer);
		//ָ��ָ����󣬶����
		//chanel.position(buffer.limit());
		chanel.write(ByteBuffer.wrap(" hello eclipse".getBytes()));
		chanel.close();
		System.out.println("д��ɹ�");
		
		//��ȡ
		ByteBuffer result = ByteBuffer.allocate(100);
		chanel = new FileInputStream(file).getChannel();
		chanel.read(result);
		//ָ���λ
		result.flip();
		while(result.hasRemaining()) {
			//getChar()�ᱨ��getCharֻ������asCharBuffer�����
			System.out.print((char) result.get());
		}
	}

}
