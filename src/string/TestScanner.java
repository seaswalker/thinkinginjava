package string;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.MatchResult;

/**
 * ����ɨ����
 * @author skywalker
 *
 */
public class TestScanner {

	private static String str = "hello world fuck the shit";
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(str);
		//��������ƥ�����
		String pattern = "\\w*o\\w*";
		//Scanner in = new Scanner(new File("C:/Users/xsdwe_000/Desktop/����.txt"));
		//in.useDelimiter("\n");
		while(in.hasNext(pattern)) {
			
			in.next(pattern);
			MatchResult result = in.match();
			System.out.println(result.group());
		}
		in.close();
	}
}
