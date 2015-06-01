package containers;

import java.util.HashSet;

/**
 * 测试HashSet的重复判断规则
 * @author skywalker
 *
 */
public class HashSetTest {
	
	public static void main(String[] args) {
		HashSet<SetType> set = new HashSet<SetType>();
		for(int i = 0;i < 2;i ++) {
			for(int j = 0;j < 5;j ++) {
				set.add(new SetType(j));
			}
		}
		System.out.println(set);
	}
	
}

class SetType {
	
	private int i;
	
	public SetType(int i) {
		this.i = i;
	}
	
	public int getI() {
		return i;
	}
	
	/*@Override
	public boolean equals(Object obj) {
		SetType o = (SetType) obj;
		return i == o.getI();
	}*/
	
	@Override
	public int hashCode() {
		return i;
	}
	
	@Override
	public String toString() {
		return i + "";
	}
	
}
