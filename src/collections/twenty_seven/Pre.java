package collections.twenty_seven;

import java.util.LinkedList;
import java.util.Queue;

public class Pre {

	public static Queue<Command> prepare() {
		Queue<Command> commands = new LinkedList<Command>();
		Command command = null;
		for(int i = 0;i < 5;i ++) {
			command = new Command("µÚ" + i + "¸ö");
			commands.offer(command);
		}
		return commands;
	}
	
}
