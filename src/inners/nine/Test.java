package inners.nine;

/**
 * 方法内部内部类实现接口
 * @author skywalker
 *
 */
public class Test {
	
	public Nine test() {
		/*class Inner implements Nine {

			@Override
			public void doSomething() {
				System.out.println("do something");
			}
			
		}
		return new Inner();*/
		
		//匿名类写法
		return new Nine() {
			
			@Override
			public void doSomething() {
				System.out.println("do something");
			}
		};
	}

	public static void main(String[] args) {
		Nine nine = new Test().test();
		nine.doSomething();
	}
	
}
