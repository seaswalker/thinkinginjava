package inners;

/**
 * ��ϰ21 (P203)
 * @author skywalker
 *
 */
interface In {
	
	public String display();

	class Inner {
		static void test(In to) {
			System.out.println(to.display());
		}
	}
	
}

public class TwentyOne implements In {

	@Override
	public String display() {
		return "hello";
	}
	
	public static void main(String[] args) {
		TwentyOne to = new TwentyOne();
		//ע��Ƕ����ķ��ʷ�ʽ����ͨ�ڲ���Ҳ������ôд����ֻ�ܻ���ڲ���������
		In.Inner.test(to);
	}
	
}


