package oop;

/**
 * 测试构造器
 * @author skywalker
 * 结果：
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
		//调用的是子类的重写的方法
		draw();
		System.out.println("base construt ends");
	}
}
