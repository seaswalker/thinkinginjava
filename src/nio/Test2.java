package nio;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;

public class Test2 {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		File file = new File("C:/Users/xsdwe_000/Desktop/����.txt");
		FileChannel chanel = new FileOutputStream(file).getChannel();
		ByteBuffer buffer = ByteBuffer.wrap(new byte[] {1, 2, 97, 100, 56, 66});
		chanel.write(buffer);
		chanel.close();
		System.out.println("����ɹ�");
		
		//������ԭʼbuffer�ϵ���
		buffer.rewind();
		CharBuffer charBuffer = buffer.asCharBuffer();
		while(charBuffer.hasRemaining()) {
			System.out.println(charBuffer.get());
		}
	}
	
}
