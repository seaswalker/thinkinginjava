package inners;

/**
 * ��ϰ18 (P202)
 * @author skywalker
 *
 */
public class Eighteen {

	static class Inner {
		static int a = 10;
		
		public void hello() {
			System.out.println("����Ƕ����");
		}
	}
	
	public static void main(String[] args) {
		//Ƕ���಻��Ҫ�ⲿ��Ķ���������
		Inner inner = new Inner();
		inner.hello();
	}
	
}
