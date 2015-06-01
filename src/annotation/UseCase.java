package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 定义一个注解
 * @author skywalker
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UseCase {

	public String value();
	
	public String name() default "";
	
}

class SomethingA {
	
	@UseCase(value = "hello")
	public void test() {
		
	}
	
}
