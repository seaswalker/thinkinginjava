package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * ��̬���������л�
 * @author skywalker
 *
 */
public class StaticSerializable {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		FileOutputStream fos = new FileOutputStream(new File("C:/Users/xsdwe_000/Desktop/����.txt"));
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(new SomeThing(10, "hello"));
		oos.close();
		
		FileInputStream fis = new FileInputStream(new File("C:/Users/xsdwe_000/Desktop/����.txt"));
		ObjectInputStream ois = new ObjectInputStream(fis);
		SomeThing someThing = (SomeThing) ois.readObject();
		//����������л���
		System.out.println(someThing);
		ois.close();
	}
	
}

class SomeThing implements Serializable {
	
	private static final long serialVersionUID = -3726491585340689540L;
	private static int a = 5;
	private String b;
	
	public SomeThing(int A, String B) {
		a = A;
		this.b = B;
	}
	
	

	@Override
	public String toString() {
		return "SomeThing [a =" + a + ",b=" + b + "]";
	}
	
}
