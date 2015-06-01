package inners;

/**
 * 练习21 (P203)
 * @author skywalker
 *
 */
interface In {
	
	public String display();

	class Inner {
		static void test(In to) {
			System.out.println(to.display());
		}
	}
	
}

public class TwentyOne implements In {

	@Override
	public String display() {
		return "hello";
	}
	
	public static void main(String[] args) {
		TwentyOne to = new TwentyOne();
		//注意嵌套类的访问方式，普通内部类也可以这么写不过只能获得内部类的类对象
		In.Inner.test(to);
	}
	
}


