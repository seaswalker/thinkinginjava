package collections;

import java.util.HashMap;
import java.util.Map;

/**
 * Á·Ï°18 (P235)
 * HashMapË³Ðò
 * @author skywalker
 *
 */
public class Eighteen {

	public static void main(String[] args) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>(10);
		for(int i = 0;i < 10;i ++) {
			map.put(i, i);
		}
		
		for(Integer i : map.keySet()) {
			Integer value = map.get(i);
			System.out.println("key : " + i + ",value : " + value);
		}
		
	}
	
}
