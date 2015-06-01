package exception;

/**
 * Á·Ï°18 (P269)
 * @author skywalker
 *
 */
public class Eighteen {
	void f() throws VeryImportantException {
		throw new VeryImportantException();
	}

	void dispose() throws HoHumException {
		throw new HoHumException();
	}
	
	void third() throws ThirdException {
		throw new ThirdException();
	}

	public static void main(String[] args) {
		Eighteen lm = new Eighteen();
		try {
			try {
				lm.f();
				lm.dispose();
			} finally {
				lm.third();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}

@SuppressWarnings("serial")
class VeryImportantException extends Exception {
	public String toString() {
		return "A very important exception!";
	}
}
@SuppressWarnings("serial")
class HoHumException extends Exception {
	public String toString() {
		return "A trivial exception";
	}
}
@SuppressWarnings("serial")
class ThirdException extends Exception {
	@Override
	public String toString() {
		return "a third exception";
	}
}
