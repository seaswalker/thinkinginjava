package inners;

/**
 * ��ϰ7(P195)
 * @author skywalker
 *
 */
public class Seven {

	private String str = "unchanged";
	
	private void outer() {
		System.out.println("�ⲿ����������");
		System.out.println("�����ַ���Ϊ " + str);
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
