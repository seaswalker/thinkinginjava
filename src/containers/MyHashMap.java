package containers;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 自己实现HashMap
 * @author skywalker
 *
 */
public class MyHashMap<K, V> extends AbstractMap<K, V> {
	
	private static final int SIZE = 16;
	private int index = 0;
	private List<MapEntry<K, V>> list;
	
	//散列数组
	@SuppressWarnings("unchecked")
	private List<MapEntry<K, V>>[] buckets = new LinkedList[SIZE];

	@Override
	public Set<Map.Entry<K, V>> entrySet() {
		Set<Map.Entry<K, V>> set = new HashSet<Map.Entry<K,V>>();
		for(List<MapEntry<K, V>> temp : buckets) {
			//不可添加null
			if(temp != null) {
				set.addAll(temp);
			}
		}
		return set;
	}
	
	@Override
	public V put(K key, V value) {
		V oldValue = null;
		index = key.hashCode() % SIZE;
		list = buckets[index];
		if(list == null) {
			list = new LinkedList<MapEntry<K,V>>();
			buckets[index] = list;
		}else {
			System.out.println("产生了冲突");
			for(MapEntry<K, V> entry : list) {
				if(entry.getKey().equals(key)) {
					oldValue = entry.getValue();
					entry.setValue(value);
					return oldValue;
				}
			}
		}
		list.add(new MapEntry<K, V>(key, value));
		return null;
	}
	
	@Override
	public V get(Object key) {
		index = key.hashCode() % SIZE;
		list = buckets[index];
		for(MapEntry<K, V> entry : list) {
			if(key.equals(entry.getKey())) {
				return entry.getValue();
			}
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		buckets = new LinkedList[SIZE];
	}
	
	public static void main(String[] args) {
		MyHashMap<Integer, String> map = new MyHashMap<Integer, String>();
		map.put(1, "Tom");
		map.put(2, "Jack");
		map.put(3, "Jerry");
		//造成冲突
		map.put(17, "Skywalker");
		
		System.out.println(map.entrySet());
	}
	
}
