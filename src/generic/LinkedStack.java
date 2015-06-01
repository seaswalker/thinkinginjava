package generic;

/**
 * 练习5 (P357)
 * @author skywalker
 */
public class LinkedStack<T> {
	//使用外围类的泛型参数
	private static class Node<T> {
		T item;
		Node<T> next;

		Node() {
			item = null;
			next = null;
		}

		Node(T item, Node<T> next) {
			this.item = item;
			this.next = next;
		}

		boolean end() {
			return item == null && next == null;
		}
	}

	private Node<T> top = new Node<T>(); // End sentinel

	public void push(T item) {
		top = new Node<T>(item, top);
	}

	public T pop() {
		T result = top.item;
		if (!top.end())
			top = top.next;
		return result;
	}

	public static void main(String[] args) {
		LinkedStack<String> lss = new LinkedStack<String>();
		for (String s : "Phasers on stun!".split(" "))
			lss.push(s);
		String s;
		while ((s = lss.pop()) != null)
			System.out.println(s);
	}
}
