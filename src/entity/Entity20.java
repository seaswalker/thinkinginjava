package entity;

import java.util.Scanner;

/**
 * 联系20的实体类
 * @author skywalker
 *
 */
public class Entity20 {

	private int intNum;
	private long longNum;
	private float floatNum;
	private double doubleNum;
	private String str;
	
	public Entity20(String str) {
		Scanner in = new Scanner(str);
		this.intNum = in.nextInt();
		this.longNum = in.nextLong();
		this.floatNum = in.nextFloat();
		this.doubleNum = in.nextDouble();
		this.str = in.next();
		in.close();
	}
	
	@Override
	public String toString() {
		return "int:" + intNum + "\n"
				+ "long:" + longNum + "\n"
						+ "float:" + floatNum + "\n"
								+ "double:" + doubleNum + "\n"
										+ "str:" + str;
	}
}
