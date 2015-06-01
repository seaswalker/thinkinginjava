package collections;

import java.util.Stack;

/**
 * Á·Ï°15 (P231)
 * @author skywalker
 *
 */
public class Fifteen {

	public static void main(String[] args) {
		Stack<Character> chars = new Stack<Character>();
		chars.push('U');
		chars.push('n');
		chars.push('c');
		
		System.out.println(chars.pop());
		System.out.println(chars.pop());
		System.out.println(chars.pop());
	}
	
}
