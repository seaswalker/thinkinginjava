package generic;

import java.util.List;

//类的继承结构
class Fruit {
}

class Apple extends Fruit {
}

class Jonathan extends Apple {
}

public class SuperTypeVildcards {
	
	static void writeTo( List<? super Apple> apples) {
       apples.add(new Apple());
       apples.add(new Jonathan());
       // Error
       //apples.add(new Fruit());
      }
}
