package adapters;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Scanner;

/**
 * 适配器
 * @author skywalker
 *
 */
public class AdapterChars extends Chars implements Readable {
	
	private int count;
	public AdapterChars(int count) {
		this.count = count;
	}

	//此方法会被不停地调用，在返回-1之前
	@Override
	public int read(CharBuffer cb) throws IOException {
		if(count -- == 0) {
			return -1;
		}
		CharSequence cs = getCharSequence();
		cb.append(cs);
		return cs.length();
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(new AdapterChars(7));
		while(scanner.hasNext()) {
			System.out.println(scanner.next());
		}
		scanner.close();
	}

}
