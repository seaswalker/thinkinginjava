package generic;

import java.util.Arrays;

/**
 * ��ϰ20 (P375) 
 * @author skywalker
 *
 */
public class Twenty implements If {

	public static void main(String[] args) {
		/*Class list1 = new ArrayList<String>(1).getClass();
		Class list2 = new ArrayList<Integer>(1).getClass();
		
		//true
		System.out.println(list1 == list2);*/
		
		//test(new Twenty());
		
		//T
		System.out.println(Arrays.toString(Test.class.getTypeParameters()));
		
	}
	
	//���Ա߽�
	public static <T extends If> void test(T t) {
		t.display("hello");
		t.print("hello");
	}

	@Override
	public void print(String str) {
		System.out.println("print()");
	}

	@Override
	public void display(String str) {
		System.out.println("display()");
	}
	
	public void shit(String str) {
		System.out.println("shit()");
	}
	
}

interface If {
	void print(String str);
	
	void display(String str);
}

//���Ի�ȡ���Ͳ���
class Test<T> {
	
}


