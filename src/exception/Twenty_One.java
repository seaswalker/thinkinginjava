package exception;

/**
 * ��ϰ21 (P275)
 * @author skywalker
 *
 */
public class Twenty_One extends Base {

	public Twenty_One() throws MyException {
		//�޷�����super�����ǵ�һ��
		super();
	}
	
	public static void main(String[] args) {
		try {
			new Twenty_One();
		} catch (MyException e) {
			System.out.println(e);
		}
	}
	
}

class Base {
	public Base() throws MyException {
		throw new MyException();
	}
}

class MyException extends Exception {
	private static final long serialVersionUID = 1L;
	@Override
	public String toString() {
		return "������";
	}
}
