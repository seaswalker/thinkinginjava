package inners.twenty_three;

/**
 * Á·Ï°23 (P205)
 * @author skywalker
 *
 */
public class A {

	public U method() {
		return new U() {
			
			@Override
			public void methodC() {
				System.out.println("A_C");
			}
			
			@Override
			public void methodB() {
				System.out.println("A_B");
			}
			
			@Override
			public void methodA() {
				System.out.println("A_A");
			}
		};
	}
	
}
