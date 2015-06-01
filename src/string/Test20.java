package string;

import entity.Entity20;

/**
 * 310页练习20
 * @author skywalker
 *
 */
public class Test20 {

	public static void main(String[] args) {
		//7L 56f这种会报错
		Entity20 entity20 = new Entity20("3 7 34.5 23.4545 hello");
		System.out.println(entity20);
	}
}
