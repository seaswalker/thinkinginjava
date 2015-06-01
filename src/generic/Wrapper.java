package generic;

/**
 * ²âÊÔ·ºĞÍÊı×é
 * @author skywalker
 *
 */
public class Wrapper<T> {
	
	private T[] array;

	@SuppressWarnings("unchecked")
	public Wrapper(int size) {
		this.array = (T[]) new Object[size];
	}
	
	public void put(int index, T t) {
		this.array[index] = t;
	}
	
	public T get(int index) {
		return this.array[index];
	}
	
	public T[] array() {
		return this.array;
	}
	
	public static void main(String[] args) {
		Wrapper<Integer> wrapper = new Wrapper<Integer>(5);
		for(int i = 0;i < 5;i ++) {
			wrapper.put(i, i + 1);
		}
		//ClassCastException
		//Integer[] array = wrapper.array();
		Object[] array = wrapper.array();
		System.out.println(array[2]);
	}
	
}
