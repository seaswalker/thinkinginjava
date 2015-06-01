package concurrent;

public class SerialNumberGenerator {
	private static volatile int serialNumber = 0;

	//�����������ط����п��ܶ���߳�ͬʱ��ȡ�����ڰ�ȫ��
	public synchronized static int nextSerialNumber() {
		return serialNumber++; // Not thread-safe
	}
} // /:~
