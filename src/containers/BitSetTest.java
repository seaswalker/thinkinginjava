package containers;

import java.util.BitSet;

public class BitSetTest {

	public static void main(String[] args) {
		BitSet bitSet = new BitSet();
		bitSet.set(3, 6);
		bitSet.set(10);
		//3 4 5 10
		System.out.println(bitSet);
		
		//false
		System.out.println(bitSet.get(2));
	}
	
}
