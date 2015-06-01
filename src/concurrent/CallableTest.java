package concurrent;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 测试callable接口
 * @author skywalker
 *
 */
public class CallableTest {

	public static void main(String[] args) {
		ExecutorService executorService = null;
		try {
			executorService = Executors.newFixedThreadPool(5);
			//存放返回的结果集
			ArrayList<Future<String>> list = new ArrayList<Future<String>>();
			for(int i = 1;i <= 5;i ++) {
				//必须用submit提交
				list.add(executorService.submit(new Tank(i)));
			}
			
			//输出结果
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
		//jdk5 的睡眠方式
		TimeUnit.MILLISECONDS.sleep(100);
		return "I am Tank " + id;
	}
	
}
