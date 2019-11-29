import java.util.ArrayList;
import java.util.InputMismatchException;

public class play {

	public static ArrayList<Players> players = new ArrayList<>();
	public static ArrayList<Pile> pile = new ArrayList<>();
	public static int activePlayer = 0;
	public static int maxPlayers = 2;
	public static void main(String[] args) {
		
		initialize(); //get playernames and size of pile, create first pile
		doRounds(); //play a round, turn by turn

	}

	private static void initialize() {
		int numberOfPlayers = 0;
		String playerName = null;
		while (numberOfPlayers < maxPlayers) {
			playerName = null;
			while (playerName == null) {
				System.out.print("Please enter playername: ");
				try {
					playerName = IO.getStdinScanner().next();
				} catch (InputMismatchException e) {
					IO.getStdinScanner().next();
				}
			}
			numberOfPlayers++;
			players.add(new Players(playerName));
		}

		int pileSize = 0;
		System.out.println("Pilesize? ");
		while (pileSize == 0) {
			try {
				pileSize = IO.getStdinScanner().nextInt();
			} catch (InputMismatchException e) {
				IO.getStdinScanner().nextInt();
			}
		}
		pile.add(new Pile(pileSize));
//		System.out.println(players + " " + pileSize + pile);
	}
		
	
	private static void showPiles() {
		System.out.println("Piles (number: size) ");
		for (int i = 0; i < pile.size(); i++) {
			System.out.print((i + 1) + ": " + pile.get(i).getPileSize() + " ");
			if (i + 1 != pile.size()) {
				System.out.print("| ");
			}
		}
		System.out.println();
	}
	

	private static void doRounds() {
		boolean gameOver = false;
		int pickPile = 0;
		long pickNumber = 0;
		while (!gameOver) {
			pickNumber = 0;
			activePlayer++;
			if (activePlayer > maxPlayers) activePlayer = 1;
			showPiles();
			System.out.println("Player " + 1 + ": your turn to split!");
			while (pickPile == 0 || pickPile > pile.size()) {
				System.out.println("Pick a pile " + "1-" + pile.size() +": ");
				try {
					pickPile = IO.getStdinScanner().nextInt();
				} catch (InputMismatchException e) {
					IO.getStdinScanner().nextInt();
				}
			}

			while (pickNumber == 0 || pickNumber > pile.get(pickPile - 1)) {
				System.out.println("Pick a number " + "1-" + pile.get(pickPile) +": ");
				try {
					pickPile = IO.getStdinScanner().nextInt();
				} catch (InputMismatchException e) {
					IO.getStdinScanner().nextInt();
				}
			}
			System.out.println("pile: " + pickPile + " number: " + pickNumber);
			
			
			gameOver = true;
		}
	}
}