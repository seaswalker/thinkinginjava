package annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

/**
 * һ���򵥵�sql������
 * @author skywalker
 *
 */
public class ParseSql {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("create table ");
		Class<Entity> clazz = Entity.class;
		//��ȡ����
		Table table = clazz.getAnnotation((Class<Table>) Table.class);
		String tableName = null;
		if(table != null) {
			if(!table.value().equals("")) {
				tableName = table.value();
			}else {
				tableName = clazz.getSimpleName().toUpperCase();
			}
			sb.append(tableName).append(" (\r\n");
			
			//��ȡ�ֶ���
			Field[] fields = clazz.getDeclaredFields();
			Annotation[] annotations = null;
			for(Field field : fields) {
				annotations = field.getAnnotations();
				for(Annotation annotation : annotations) {
					if(annotation instanceof id) {
						//�������ڴ˼򵥴�������int����
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
		System.out.println("û��@Tableע��");
	}
	
}

/**
 * ʵ��
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
 * ������Ĭ�������SimpleName
 * @author skywalker
 *
 */
@Target(value = ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Table {
	public String value() default "";
}

/**
 * ����
 * @author skywalker
 *
 */
@Target(value = ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface id {
	public int value() default -1;
}

/**
 * �ֶ�
 * @author skywalker
 *
 */
@Target(value = ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface column {
	public String value() default "";
}
