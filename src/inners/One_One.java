package inners;

/**
 * ��ϰ1 (P191)
 * @author skywalker
 *
 */
public class One_One {
	
	private String outerName = "�����ⲿ";
	
	public Inner getInner() {
		return new Inner();
	}

	class Inner {
		
		@Override
		public String toString() {
			return outerName;
		}
		
	}
	
	public static void main(String[] args) {
		//�����ڲ���������Ҫ���ⲿ�����
		One_One.Inner inner = new One_One().new Inner();
		//Outer.Inner inner = new Outer().getInner();
		System.out.println(inner);
	}
	
}
