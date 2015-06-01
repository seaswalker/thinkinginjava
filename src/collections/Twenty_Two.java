package collections;

import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import util.FileUtil;

/**
 * ��ϰ21 (P236)
 * ͳ�Ƶ��ʳ��ִ���
 * @author skywalker
 *
 */
public class Twenty_Two {

	public static void main(String[] args) throws IOException {
		Set<Counter> set = new TreeSet<Counter>();
		//��ȡ����
		String path = "D:/java/eclipse/ThinkinginJava/src/collections/Twelve.java";
		String content = FileUtil.readFile(path);
		
		Pattern pattern = Pattern.compile("\\w+");
		Matcher matcher = pattern.matcher(content);
		
		String word = null;
		while(matcher.find()) {
			word = matcher.group();
			for(Counter counter : set) {
				if(counter.getName().equals(word)) {
					counter.increment();
					continue;
				}
			}
			set.add(new Counter(word));
		}
		
		//�������
		for(Counter counter : set) {
			System.out.println(counter.getName() + "����" + counter.getCount() + "��");
		}
		
	}
	
}

/**
 * ������
 * TreeSet��Ҫʵ��Comparable�ӿ�
 */
class Counter implements Comparable<Counter> {
	
	private String name;
	private int count = 1;
	
	public Counter(String name) {
		this.name = name;
	}
	
	public Counter() {}
	
	public void increment() {
		this.count ++;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Counter other = (Counter) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public int compareTo(Counter o) {
		return this.name.compareTo(o.name);
	}

}
