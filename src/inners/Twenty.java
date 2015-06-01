package inners;

/**
 * 练习20 (P203)
 * @author skywalker
 *
 */
public interface Twenty {

	public void hello();
	
	//嵌套类
	class Test implements Twenty {

		@Override
		public void hello() {
			System.out.println("来自嵌套类");
		}
		
		public static void main(String[] args) {
			new Test().hello();
		}
		
	}
	
}
