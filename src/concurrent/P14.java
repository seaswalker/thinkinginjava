package concurrent;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 685ҳ��ϰ14 ����Timer��
 * @author skywalker
 *
 */
public class P14 {

	public static void main(String[] args) {
		for(int i = 0;i < 1000;i ++) {
			new Timer().schedule(new TimerTask() {
				@Override
				public void run() {
					System.out.println("һ��timer��ʱ��");
				}
			}, 2000);
		}
	}
	
}
