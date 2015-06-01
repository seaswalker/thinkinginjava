package generic;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 真是类型的数组
 * @author skywalker
 *  
 */
public class Wrapper2<T> {

	public T[] array;
	
	@SuppressWarnings("unchecked")
	public Wrapper2(int size, Class<T> clazz) {
		//这样做的话运行时实际的类型就是T
		this.array = (T[]) Array.newInstance(clazz, size);
	}
	
	public T get(int index) {
		return this.array[index];
	}
	
	public void set(T t, int index) {
		this.array[index] = t;
	}
	
	public T[] req() {
		return this.array;
	}
	
	public static void main(String[] args) {
		Wrapper2<Integer> wrapper2 = new Wrapper2<Integer>(5, Integer.class);
		for(int i = 0;i < 5;i ++) {
			wrapper2.set(i + 1, i);
		}
		//正确
		Integer[] array = wrapper2.req();
		System.out.println(Arrays.toString(array));;
	}
	
}
