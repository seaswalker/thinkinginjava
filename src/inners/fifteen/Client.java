package inners.fifteen;

public class Client {

	public Person choosePerson(String name) {
		return new Person(name) {
		};
	}
	
	public static void main(String[] args) {
		Client client = new Client();
		client.choosePerson("skywalker");
	}
	
}
