package io;

import java.io.StringWriter;

/**
 * ≤‚ ‘StringWriter
 * @author skywalker
 *
 */
public class StringWriterTest {

	public static void main(String[] args) {
		String in = "hello java c# c c++ js";
		StringWriter sw = new StringWriter();
		
		for(String str : in.split(" ")) {
			sw.write(str);
			sw.append("\r\n");
		}
		
		System.out.println(sw.toString());
	}
	
}
