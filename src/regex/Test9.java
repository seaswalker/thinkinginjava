package regex;

/**
 * 用下划线替代所有的元音字母
 * @author skywalker
 *
 */
public class Test9 {

	private static String knights = 
			"Then, when you have found the shrubbery, you must " +
		    "cut down the mightiest tree in the forest... " +
		    "with... a herring!";
	
	public static void main(String[] args) {
		//也可以用|，不过麻烦
		System.out.println(knights.replaceAll("[aeiouAEIUO]", "_"));
	}
}
