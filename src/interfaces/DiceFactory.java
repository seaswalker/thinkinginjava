package interfaces;

public class DiceFactory implements GameFactory {

	@Override
	public Game getGame() {
		return new Dice();
	}

}
