package nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 使用新io的方式读写
 * @author skywalker
 *
 */
public class Test1 {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		File file = new File("C:/Users/xsdwe_000/Desktop/进度.txt");
		
		FileChannel chanel = new FileOutputStream(file).getChannel();
		ByteBuffer buffer = ByteBuffer.wrap("hello nio".getBytes());
		chanel.write(buffer);
		//指针指向最后，多余的
		//chanel.position(buffer.limit());
		chanel.write(ByteBuffer.wrap(" hello eclipse".getBytes()));
		chanel.close();
		System.out.println("写入成功");
		
		//读取
		ByteBuffer result = ByteBuffer.allocate(100);
		chanel = new FileInputStream(file).getChannel();
		chanel.read(result);
		//指针回位
		result.flip();
		while(result.hasRemaining()) {
			//getChar()会报错，getChar只是用于asCharBuffer存入的
			System.out.print((char) result.get());
		}
	}

}
