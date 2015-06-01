package generic;

/**
 * 二维元组，可以用来存放数据
 * 练习3 (P356)
 * @author skywalker
 *
 */
public class TwoTuple<BD, B> {

	public final BD first;
	public final B second;
	
	public TwoTuple(BD a, B b) {
		first = a;
		second = b;
	}
	
	@Override
	public String toString() {
		return "first:" + first + ",second:" + second;
	}
	
	public static void main(String[] args) {
		TwoTuple<String, Integer> tuple = new TwoTuple<String, Integer>("hello", 25);
		System.out.println(tuple);
	}
	
}
