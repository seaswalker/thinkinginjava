package regex;

/**
 * ���»���������е�Ԫ����ĸ
 * @author skywalker
 *
 */
public class Test9 {

	private static String knights = 
			"Then, when you have found the shrubbery, you must " +
		    "cut down the mightiest tree in the forest... " +
		    "with... a herring!";
	
	public static void main(String[] args) {
		//Ҳ������|�������鷳
		System.out.println(knights.replaceAll("[aeiouAEIUO]", "_"));
	}
}
