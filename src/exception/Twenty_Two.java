package exception;

/**
 * ��ϰ22 (P275)
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
			System.out.println("û�г���");
		} catch (MyException e) {
			System.out.println("������������");
		}
	}
	
}
