package containers;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAcessFileTest {

	public static void main(String[] args) throws IOException {
		RandomAccessFile raf = new RandomAccessFile(new File("C:/Users/xsdwe_000/Desktop/进度.txt"), "rw");
		//写入数据
		raf.writeBoolean(true);
		raf.writeByte(10);
		raf.writeChar('A');
		//raf.writeChars("hello eclipse");
		raf.writeDouble(10.345D);
		raf.writeFloat(10L);
		raf.writeInt(100);
		raf.writeUTF("This is String type");
		raf.close();
		
		read();
	}
	
	public static void read() throws IOException {
		RandomAccessFile raf = new RandomAccessFile(new File("C:/Users/xsdwe_000/Desktop/进度.txt"), "rw");
		System.out.println(raf.readBoolean());
		System.out.println(raf.readByte());
		System.out.println(raf.readChar());
		System.out.println(raf.readDouble());
		System.out.println(raf.readFloat());
		System.out.println(raf.readInt());
		System.out.println(raf.readUTF());
		raf.close();
	}
	
}
