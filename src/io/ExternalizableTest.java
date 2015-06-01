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
 * 测试此接口
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
	
	//说明此接口不是直接恢复写入的二进制数据，而是new了一个对象，然后设置成员变量的值
	public SomethingElse() {
		System.out.println("无参构造器被调用");
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
