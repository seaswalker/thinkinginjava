package generic;

public class ClassName {

	public static void main(String[] args) {
		//new A<Integer>(10).printf();
		//new A<String>("hello").printf();
		Object object = "hello";
		System.out.println(object.getClass().getSimpleName());//String
	}
	
}

class A<T> {
	
	private T t;
	
	public A(T t) {
		this.t = t;
	}
	
	public void printf() {
		System.out.println(t.getClass().getSimpleName());
	}
	
}
