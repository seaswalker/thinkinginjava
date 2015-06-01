package containers;

import java.lang.ref.SoftReference;
import java.util.WeakHashMap;

/**
 * 测试java.lang.ref包下面的弱引用
 * @author skywalker
 *
 */
public class WeakLink {
	
	public static void main(String[] args) {
		SoftReference<String> softReference = new SoftReference<String>("测试");
		//get方法会获取对象的强引用
		System.out.println(softReference.get());
		
		testWeakHashMap();
	}
	
	/**
	 * 测试WeakHashMap
	 */
	public static void testWeakHashMap() {
		Key[] keys = new Key[10];
		WeakHashMap<Key, Value> map = new WeakHashMap<Key, Value>();
		for(int i = 0;i < 10;i ++) {
			Key key = new Key(Integer.toString(i));
			Value value = new Value(Integer.toString(i));
			if(i % 2 == 0) {
				keys[i] = key;
			}
			map.put(key, value);
		}
		//运行垃圾清理
		System.gc();
		
		System.out.println(map.size());
	}

}

class Element {
	private String id;

	public Element(String id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Element other = (Element) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	@Override
	protected void finalize() throws Throwable {
		System.out.println(getClass().getSimpleName() + id + "被干掉");
	}
	
}

class Key extends Element {

	public Key(String id) {
		super(id);
	}
	
}

class Value extends Element {

	public Value(String id) {
		super(id);
	}
	
}