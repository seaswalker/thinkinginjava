package generic;

/**
 * ��ϰ9/10 (P362)
 * @author skywalker
 *
 */
public class Nine {

	public <BC, B> void print(BC a, B b, Character c) {
		System.out.println("A:" + a.getClass().getSimpleName() + "\r\n"
				 + "B:" + b.getClass().getSimpleName() + "\r\n"
				 + "C:" + c.getClass().getSimpleName() + "\r\n");
	}
	
	public static void main(String[] args) {
		//��̬�������治��������ķ�������
		Nine nine = new Nine();
		nine.print("hello", 45, 'A');
	}
	
}
