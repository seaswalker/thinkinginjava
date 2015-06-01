package inners;

/**
 * 练习7(P195)
 * @author skywalker
 *
 */
public class Seven {

	private String str = "unchanged";
	
	private void outer() {
		System.out.println("外部方法被调用");
		System.out.println("测试字符串为 " + str);
	}
	
	class Inner { 
		
		private void change() {
			str = "changed";
			outer();
		}
		
	}
	
	public static void main(String[] args) {
		Seven outer = new Seven();
		Seven.Inner inner = outer.new Inner();
		inner.change();
	}
	
}
