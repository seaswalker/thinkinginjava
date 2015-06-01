package generic;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试方法擦除
 * @author skywalker
 *
 */
public class Method extends TestMethod<String> {

	@Override
	public void doSomething(String t) {
		super.doSomething(t);
	}
	
	public static void main(String[] args) {
		List<?> list = new ArrayList<String>();
		//list.add(3); 编译错误
		list.add(null);
	}
	
}

class TestMethod<T> {
	
	//private static T t; 编译错误static和泛型不可混用
	
	public void doSomething(T t) {
		System.out.println("打印T");
	}
}
