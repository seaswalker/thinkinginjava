package generic;

/**
 * 409ҳ��ϰ34
 * @author skywalker
 *
 */
public class Thirty_Four extends AB<Thirty_Four> {

	@Override
	public Thirty_Four testA(Thirty_Four t) {
		return t;
	}
	
	public static void main(String[] args) {
		System.out.println(new Thirty_Four().testB(new Thirty_Four()));
	}

}

/**
 * ���޶�����
 * @author skywalker
 */
abstract class AB<T extends AB<T>> {
	
	public abstract T testA(T t);
	
	public T testB(T t) {
		return testA(t);
	}
	
}
