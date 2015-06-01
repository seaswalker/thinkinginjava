package inners.twenty_three;

public class B {

	private U []us = new U[10];
	private int i = 0;
	
	public void add(U u) {
		if(i < 10)
			us[i ++] = u;
	}
	
	public void clear() {
		for(int i = 0;i < 10;i ++) {
			us[i] = null;
		}
	}
	
	public void each() {
		for(U u : us) {
			if(u != null) {
				u.methodA();
				u.methodB();
				u.methodC();
			}
		}
	}
	
	public static void main(String[] args) {
		B b = new B();
		A a = new A();
		b.add(a.method());
		b.add(a.method());
		b.add(a.method());
		b.add(a.method());
		
		b.each();
	}
	
}
