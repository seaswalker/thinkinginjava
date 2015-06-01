package generic;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;

class Building {
}

class House extends Building {
}

public class ClassTypeCapture<T> {
	Class<T> kind;
	Map<String, Class<?>> map = new HashMap<String, Class<?>>();
	//创建数组
	//T [] array = new T[10]; 错误
	@SuppressWarnings("unchecked")
	T []array = (T[]) new Object[10];
	//或者
	@SuppressWarnings("unchecked")
	T []array2 = (T[]) Array.newInstance(kind, 10);

	public ClassTypeCapture(Class<T> kind) {
		this.kind = kind;
	}

	public boolean f(Object arg) {
		return kind.isInstance(arg);
	}
	
	public void addType(String typename, Class<?> kind) {
		map.put(typename, kind);
	}
	
	public Object createNew(String typename) {
		try {
			return Class.forName(typename);
		} catch (ClassNotFoundException e) {
			System.out.println("未找到指定的类");
		}
		return null;
	}

	public static void main(String[] args) {
		ClassTypeCapture<Building> ctt1 = new ClassTypeCapture<Building>(
				Building.class);
		System.out.println(ctt1.f(new Building()));
		System.out.println(ctt1.f(new House()));
		ClassTypeCapture<House> ctt2 = new ClassTypeCapture<House>(House.class);
		System.out.println(ctt2.f(new Building()));
		System.out.println(ctt2.f(new House()));
	}
} /*
 * Output: true true false true
 */// :~
