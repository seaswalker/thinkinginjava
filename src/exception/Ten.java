package exception;

/**
 * ��ϰ10 (P263) 
 * @author skywalker
 *
 */
public class Ten {

	public static void g() throws FirstException {
		throw new FirstException();
	}
	
	public static void f() throws Exception {
		try {
			g();
		} catch (FirstException e) {
			//��װΪruntimeException
			//throw new RuntimeException(e);
			//�쳣��
			throw (Exception) new SecondException().initCause(e);
		}
	}
	
	public static void main(String[] args) {
		try {
			f();
		} catch (Exception e) {
			/*for(StackTraceElement ste : e.getStackTrace()) {
				System.out.println(ste);
			}*/
			e.printStackTrace();
		}
	}
	
}

class FirstException extends Exception {
	private static final long serialVersionUID = 1L;}
class SecondException extends Exception {
	private static final long serialVersionUID = 1L;}
