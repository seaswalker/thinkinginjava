package io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/**
 * ���Դ˽ӿ�
 * @author skywalker
 *
 */
public class ExternalizableTest {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(new SomethingElse("A", "B"));
		
		ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()));
		System.out.println((SomethingElse) ois.readObject());
	}
	
}

class SomethingElse implements Externalizable {
	
	private String a;
	private String b;
	
	public SomethingElse(String a, String b) {
		this.a = a;
		this.b = b;
	}
	
	//˵���˽ӿڲ���ֱ�ӻָ�д��Ķ��������ݣ�����new��һ������Ȼ�����ó�Ա������ֵ
	public SomethingElse() {
		System.out.println("�޲ι�����������");
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(a);
		out.writeObject(b);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		a = (String) in.readObject();
		b = (String) in.readObject();
	}

	@Override
	public String toString() {
		return "SomethingElse [a=" + a + ", b=" + b + "]";
	}
	
}
