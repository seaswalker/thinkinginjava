package containers;

/**
 * 自己实现Map
 * @author skywalker
 *
 */
public class MyMap<K, V> {

	private Object[][] map;
	private int index = 0;
	
	public MyMap(int size) {
		this.map = new Object[size][2];
	}
	
	public void put(K key, V value) {
		if(index == map.length) {
			throw new ArrayIndexOutOfBoundsException();
		}
		this.map[index ++] = new Object[] {key, value};
	}
	
	@SuppressWarnings("unchecked")
	public V get(K key) {
		for(int i = 0;i < map.length; i++) {
			if(key.equals(map[i][0])) {
				return (V) map[i][1];
			}
		}
		return null;
	}
	
	public int size() {
		return map.length;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i < map.length;i ++) {
			sb.append("key:").append(map[i][0]).append(",value:").append(map[i][1]);
			if(i < map.length - 1) {
				sb.append("\r\n");
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		MyMap<Integer, String> map = new MyMap<Integer, String>(3);
		map.put(1, "Tom");
		map.put(2, "Jack");
		map.put(3, "Fuck");
		System.out.println(map.toString());
		
		System.out.println("搜索结果：");
		System.out.println(map.get(3));
	}
	
}
