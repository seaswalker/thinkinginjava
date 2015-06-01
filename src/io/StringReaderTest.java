package io;

import java.io.IOException;
import java.io.StringReader;

/**
 * ≤‚ ‘StringReader
 * @author skywalker
 *
 */
public class StringReaderTest {

	public static void main(String[] args) throws IOException {
		StringReader sr = new StringReader("java c c# js");
		
		System.out.println(sr.ready());
		
		int temp = -1;
		while((temp = sr.read()) != -1) {
			System.out.print((char) temp);
		}
	}
	
}
