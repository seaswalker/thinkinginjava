package exception;

/**
 * 练习22 (P275)
 * @author skywalker
 *
 */
public class Twenty_Two {

	public Twenty_Two() throws MyException {
		throw new MyException();
	}
	
	public static void main(String[] args) {
		try {
			new Twenty_Two();
			System.out.println("没有出错");
		} catch (MyException e) {
			System.out.println("构造器出错了");
		}
	}
	
}
