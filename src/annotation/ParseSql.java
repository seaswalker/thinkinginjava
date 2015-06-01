package annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

/**
 * 一个简单的sql解析器
 * @author skywalker
 *
 */
public class ParseSql {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("create table ");
		Class<Entity> clazz = Entity.class;
		//获取表名
		Table table = clazz.getAnnotation((Class<Table>) Table.class);
		String tableName = null;
		if(table != null) {
			if(!table.value().equals("")) {
				tableName = table.value();
			}else {
				tableName = clazz.getSimpleName().toUpperCase();
			}
			sb.append(tableName).append(" (\r\n");
			
			//获取字段名
			Field[] fields = clazz.getDeclaredFields();
			Annotation[] annotations = null;
			for(Field field : fields) {
				annotations = field.getAnnotations();
				for(Annotation annotation : annotations) {
					if(annotation instanceof id) {
						//主键，在此简单处理，就是int类型
						sb.append(" int ").append(field.getName()).append(" primary key,");
					}else if(annotation instanceof column) {
						sb.append(" varchar ").append(field.getName()).append(",");
					}
				}
			}
			sb.deleteCharAt(sb.length() - 1).append("\r\n)");
			
			System.out.println(sb.toString());
			return;
		}
		System.out.println("没有@Table注解");
	}
	
}

/**
 * 实体
 */
@Table
class Entity {
	
	@id
	private int id;
	@column
	private String name;
	@column
	private int age;
	
}

/**
 * 表名，默认是类的SimpleName
 * @author skywalker
 *
 */
@Target(value = ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Table {
	public String value() default "";
}

/**
 * 主键
 * @author skywalker
 *
 */
@Target(value = ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface id {
	public int value() default -1;
}

/**
 * 字段
 * @author skywalker
 *
 */
@Target(value = ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface column {
	public String value() default "";
}
