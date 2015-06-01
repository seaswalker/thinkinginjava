package nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * 测试chanel
 * @author skywalker
 *
 */
public class Chanel {

	public static void main(String[] args) throws IOException {
		RandomAccessFile from = new RandomAccessFile("C:/Users/xsdwe_000/Desktop/进度.txt", "r");
		RandomAccessFile to = new RandomAccessFile("C:/Users/xsdwe_000/Desktop/to.txt", "rw");
		FileChannel fromChanel = from.getChannel();
		FileChannel toChanel = to.getChannel();
		
		//fromChanel.transferTo(0, fromChanel.size(), toChanel);
		toChanel.transferFrom(fromChanel, 0, fromChanel.size());
		
		System.out.println("转移成功");
		
		from.close();
		to.close();
	}
	
}
