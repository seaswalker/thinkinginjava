package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * jdk5 Ö´ÐÐÆ÷²âÊÔ
 * @author skywalker
 *
 */
public class ExecuterTest {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		for(int i = 0;i < 5;i ++) {
			executorService.execute(new LiftOff());
		}
		executorService.shutdown();
	}
	
}
