package inners;

/**
 * ��ϰ20 (P203)
 * @author skywalker
 *
 */
public interface Twenty {

	public void hello();
	
	//Ƕ����
	class Test implements Twenty {

		@Override
		public void hello() {
			System.out.println("����Ƕ����");
		}
		
		public static void main(String[] args) {
			new Test().hello();
		}
		
	}
	
}
