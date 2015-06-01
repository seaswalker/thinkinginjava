package collections.twenty_seven;

import java.util.Queue;



public class Client {

	public static void main(String[] args) {
		Queue<Command> commands = Pre.prepare();
		while(commands.peek() != null) {
			commands.remove().operation();
		}
	}
	
}
