package generic;

import java.util.ArrayList;
import java.util.List;

/**
 * ���Է�������
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
		//list.add(3); �������
		list.add(null);
	}
	
}

class TestMethod<T> {
	
	//private static T t; �������static�ͷ��Ͳ��ɻ���
	
	public void doSomething(T t) {
		System.out.println("��ӡT");
	}
}
