package concurrent;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * ����callable�ӿ�
 * @author skywalker
 *
 */
public class CallableTest {

	public static void main(String[] args) {
		ExecutorService executorService = null;
		try {
			executorService = Executors.newFixedThreadPool(5);
			//��ŷ��صĽ����
			ArrayList<Future<String>> list = new ArrayList<Future<String>>();
			for(int i = 1;i <= 5;i ++) {
				//������submit�ύ
				list.add(executorService.submit(new Tank(i)));
			}
			
			//������
			for(Future<String> future : list) {
				System.out.println(future.get());
			}
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}finally {
			executorService.shutdown();
		}
	}
}

class Tank implements Callable<String> {
	
	private int id = 0;
	
	public Tank(int id) {
		this.id = id;
	}

	@Override
	public String call() throws Exception {
		//jdk5 ��˯�߷�ʽ
		TimeUnit.MILLISECONDS.sleep(100);
		return "I am Tank " + id;
	}
	
}
