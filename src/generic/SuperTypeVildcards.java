package generic;

import java.util.List;

//��ļ̳нṹ
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
