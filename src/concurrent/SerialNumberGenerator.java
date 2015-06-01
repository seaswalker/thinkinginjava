package concurrent;

public class SerialNumberGenerator {
	private static volatile int serialNumber = 0;

	//问题出在这个地方，有可能多个线程同时读取，现在安全了
	public synchronized static int nextSerialNumber() {
		return serialNumber++; // Not thread-safe
	}
} // /:~
