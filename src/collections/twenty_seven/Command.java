package collections.twenty_seven;

public class Command {

	private String name;
	
	public Command(String name) {
		this.name = name;
	}

	public void operation() {
		System.out.println(this.name);
	}
	
}
