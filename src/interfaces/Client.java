package interfaces;

/**
 * �ͻ���
 * ����ģʽ
 * @author skywalker
 *
 */
public class Client {

	public static void main(String[] args) {
		play(new CoinFactory());
		play(new DiceFactory());
	}
	
	public static void play(GameFactory gameFactory) {
		Game game = gameFactory.getGame();
		game.play();
	}
	
}
