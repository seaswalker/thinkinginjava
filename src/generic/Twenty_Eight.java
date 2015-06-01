package generic;

/**
 * 395Ò³Á·Ï°28
 * @author skywalker
 *
 */
public class Twenty_Eight {
	
	public static <T> void testA(Generic1<? super T> g, T t) {
		g.test(t);
	}
	
	public static <T> T testB(Generic2<? extends T> g) {
		return g.test();	
	}

	public static void main(String[] args) {
		
	}
	
}

class Generic1<T> {
	
	public void test(T t) {
		
	}
	
}

class Generic2<T> {
	
	private T t;
	
	public Generic2(T t) {
		this.t = t;
	}
	
	public T test() {
		return t;
	}
}
