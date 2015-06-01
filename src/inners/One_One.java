package inners;

/**
 * 练习1 (P191)
 * @author skywalker
 *
 */
public class One_One {
	
	private String outerName = "我是外部";
	
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
		//创建内部类对象必须要有外部类对象
		One_One.Inner inner = new One_One().new Inner();
		//Outer.Inner inner = new Outer().getInner();
		System.out.println(inner);
	}
	
}
