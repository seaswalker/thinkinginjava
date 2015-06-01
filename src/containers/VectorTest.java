package containers;

import java.util.Enumeration;
import java.util.Vector;

/**
 * ≤‚ ‘¿œµÙ—¿µƒ¿‡
 * @author skywalker
 *
 */
public class VectorTest {

	public static void main(String[] args) {
		Vector<String> vector = new Vector<String>();
		vector.add("hello");
		vector.add("test");
		vector.add("vector");
		
		Enumeration<String> enumeration = vector.elements();
		while(enumeration.hasMoreElements()) {
			System.out.println(enumeration.nextElement());
		}
	}
	
}
