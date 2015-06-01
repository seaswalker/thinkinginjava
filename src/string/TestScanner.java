package string;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.MatchResult;

/**
 * 测试扫描类
 * @author skywalker
 *
 */
public class TestScanner {

	private static String str = "hello world fuck the shit";
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(str);
		//必须整体匹配才行
		String pattern = "\\w*o\\w*";
		//Scanner in = new Scanner(new File("C:/Users/xsdwe_000/Desktop/缓存.txt"));
		//in.useDelimiter("\n");
		while(in.hasNext(pattern)) {
			
			in.next(pattern);
			MatchResult result = in.match();
			System.out.println(result.group());
		}
		in.close();
	}
}
