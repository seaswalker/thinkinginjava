package concurrent;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 685页练习14 测试Timer类
 * @author skywalker
 *
 */
public class P14 {

	public static void main(String[] args) {
		for(int i = 0;i < 1000;i ++) {
			new Timer().schedule(new TimerTask() {
				@Override
				public void run() {
					System.out.println("一个timer到时了");
				}
			}, 2000);
		}
	}
	
}
