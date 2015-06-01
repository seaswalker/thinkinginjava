package io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * �������л��ӿ�
 * @author skywalker
 *
 */
public class SerializableTest {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(new SomethingFuck("A", "B"));
		
		ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()));
		System.out.println((SomethingFuck) ois.readObject());
	}
	
}

class SomethingFuck implements Serializable {

	private static final long serialVersionUID = 1064852991192267462L;
	
	private String a;
	private transient String b;
	
	public SomethingFuck(String a, String b) {
		this.a = a;
		this.b = b;
	}
	
	/**
	 * �������л��ӿڵ�Ĭ����Ϊ
	 */
	private void writeObject(ObjectOutputStream oos) throws IOException {
		//Ĭ����Ϊ
		oos.defaultWriteObject();
		//д��b
		oos.writeObject(b);
	}
	
	private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
		ois.defaultReadObject();
		b = (String) ois.readObject();
	}

	@Override
	public String toString() {
		return "Something [a=" + a + ", b=" + b + "]";
	}
	
}
