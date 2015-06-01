package oop;

/**
 * ���Թ�����
 * @author skywalker
 * �����
 * 	base construt begins
	child draws :0
	base construt ends
	
	-------------------
	
	child construt begins
	child draws :10
	child construt ends
 *
 */
public class Constructor extends Base {
	
	private int num = 10;

	@Override
	void draw() {
		System.out.println("child draws :" + num);
	}
	
	public Constructor() {
		System.out.println("child construt begins");
		draw();
		System.out.println("child construt ends");
	}
	
	
	public static void main(String[] args) {
		new Constructor();
	}
	
}

class Base {
	
	void draw() {
		System.out.println("base draw");
	}
	
	Base() {
		System.out.println("base construt begins");
		//���õ����������д�ķ���
		draw();
		System.out.println("base construt ends");
	}
}
