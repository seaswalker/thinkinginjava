package inners;

/**
 * 练习22 (P205)
 * 实现反向遍历
 * @author skywalker
 *
 */
public class TwentyTwo {

	  private Object[] items;
	  private int next = 0;
	  public TwentyTwo(int size) { items = new Object[size]; }
	  public void add(Object x) {
	    if(next < items.length)
	      items[next++] = x;
	  }
	  
	  private class SequenceSelector implements Selector {
	    private int i = 0;
	    public boolean end() { return i == items.length; }
	    public Object current() { return items[i]; }
	    public void next() { if(i < items.length) i++; }
	  }
	  
	  public Selector selector() {
	    return new SequenceSelector();
	  }
	  
	  //实现反向遍历
	  private class ReverseSelector implements Selector {
		  
		private int i = 0;

		@Override
		public boolean end() {
			return i == 1;
		}

		@Override
		public Object current() {
			return items[i];
		}

		@Override
		public void next() {
			if(i > 0) {
				i --;
			}
		}
		  
	  }
	  
	  public Selector reverseSelector() {
		  return new ReverseSelector();
	  }
	  
	  public static void main(String[] args) {
		  TwentyTwo twentyTwo = new TwentyTwo(10);
	    for(int i = 0; i < 10; i++)
	    	twentyTwo.add(Integer.toString(i));
	    Selector selector = twentyTwo.selector();
	    while(!selector.end()) {
	      System.out.print(selector.current() + " ");
	      selector.next();
	    }
	} 
}

interface Selector {
	  boolean end();
	  Object current();
	  void next();
}	
