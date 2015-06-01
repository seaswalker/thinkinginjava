package generic;

/**
 * 389Ò³Á·Ï°25
 * @author skywalker
 *
 */
public class Twenty_Five implements IA, IB {

	public static <T extends IA> void testA(T t) {
		//A
		System.out.println(t.getClass().getInterfaces()[0].getSimpleName());
	}
	
	public static <E extends IB> void testB(E e) {
		//B
		System.out.println(e.getClass().getInterfaces()[0].getSimpleName());
	}
	
	public static void main(String[] args) {
		testA(new IA() {
		});
		
		testB(new IB() {
		});
	}
	
}

interface IA {
	
}

interface IB {}
