package containers;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * һ�����������Map
 * @author skywalker
 * @param <K>
 *
 */
public class MyMap2<K, V> extends AbstractMap<K, V> {
	
	private List<K> keys = new LinkedList<K>();
	private List<V> values = new LinkedList<V>();
	
	public V get(Object key) {
		for(K k : keys) {
			if(k.equals(key)) {
				return values.get(keys.indexOf(k));
			}
		}
		return null;
	}
	
	/**
	 * �����key�Ѿ�������ô������ǰ��ֵ�����򷵻�null
	 */
	public V put(K key, V value) {
		V oldValue = null;
		int index = 0;
		//����Ѿ����ڴ�Ԫ��
		if(keys.contains(key)) {
			index = keys.indexOf(key);
			oldValue = values.get(index);
			//�滻
			values.set(index, value);
		}else {
			keys.add(key);
			values.add(value);
		}
		return oldValue;
	}

	@Override
	public Set<Map.Entry<K, V>> entrySet() {
		Set<Map.Entry<K, V>> entrySet = new HashSet<Map.Entry<K,V>>();
		for(K key : keys) {
			entrySet.add(new MapEntry<K, V>(key, values.get(keys.indexOf(key))));
		}
		return entrySet;
	}
	
	public static void main(String[] args) {
		testMap();
	}
	
	public static void testMyMap2() {
		MyMap2<Integer, String> map = new MyMap2<Integer, String>();
		map.put(1, "Tom");
		map.put(2, "Jack");
		map.put(3, "Jerry");
		
		System.out.println(map);
		System.out.println(map.get(2));
		System.out.println(map.entrySet());
	}
	
	/**
	 * ����Map.Entry�ĸı��Ƿ������Mapֵ�ĸı�
	 */
	public static void testMap() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "����");
		System.out.println("old : " + map.get(1));
		
		Iterator<Entry<Integer, String>> iterator = map.entrySet().iterator();
		iterator.next();
		iterator.remove();
		
		//null
		System.out.println(map.get(1));
		
		for(Entry<Integer, String> entry : map.entrySet()) {
			System.out.println("key : " + entry.getKey() + ", value : " + entry.getValue());
		}
		
	}

}

/**
 * ʵ���Լ���Map.Entry
 * @author skywalker
 */
class MapEntry<K, V> implements Map.Entry<K, V> {
	
	private K key;
	private V value;
	
	public MapEntry(K key, V value) {
		this.key = key;
		this.value = value;
	}

	@Override
	public K getKey() {
		return key;
	}

	@Override
	public V getValue() {
		return value;
	}

	@Override
	public V setValue(V value) {
		V oldValue = value;
		this.value = value;
		return oldValue;
	}
	
	@Override
	public String toString() {
		return "key : " + key + " value : " + value;
	}
	
}
