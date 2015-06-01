package loggers;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerTest {

	public static void main(String[] args) {
		//Logger.getGlobal().info("ÈÕÖ¾¼ÇÂ¼");
		
		Logger parent = Logger.getLogger("loggers");
		//Logger child = Logger.getLogger("loggers.child");
		parent.setLevel(Level.FINE);
		//System.out.println(parent.getLevel());
		parent.fine("parent fine");
		//System.out.println(child.getParent().getName());//loggers
		
		parent.entering("LoggerTest", "main");
	}
	
}
