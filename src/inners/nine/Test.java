package inners.nine;

/**
 * �����ڲ��ڲ���ʵ�ֽӿ�
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
		
		//������д��
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
