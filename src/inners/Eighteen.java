package inners;

/**
 * 练习18 (P202)
 * @author skywalker
 *
 */
public class Eighteen {

	static class Inner {
		static int a = 10;
		
		public void hello() {
			System.out.println("我是嵌套类");
		}
	}
	
	public static void main(String[] args) {
		//嵌套类不需要外部类的对象来创建
		Inner inner = new Inner();
		inner.hello();
	}
	
}
