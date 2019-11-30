import java.util.ArrayList;
import java.util.InputMismatchException;

public class Play {

	private static ArrayList<Pile> stackOfPiles = new ArrayList<Pile>(); // piles with number > 2, to split

	public static void main(String[] args) {

		initialize(); // create players & first pile
		doRounds();

	}

	private static void initialize() {
		// for start have a fixed size for first pile
		stackOfPiles.add(new Pile(12));
		stackOfPiles.add(new Pile(3));
	}

	private static void doRounds() {
		while (!stackOfPiles.isEmpty()) {
			checkPiles(); // check for piles with a size of 1 or 2
			splitPile();
		}
	}

	private static void checkPiles() {
		for (int i = stackOfPiles.size() -1; i >= 0; i--) {
			if (stackOfPiles.get(i).getPileSize() <= 2) {
				stackOfPiles.remove(i);
			}
		}
		if (stackOfPiles.isEmpty()) {
			System.out.println();
			System.out.println("No more piles! Last player lost!");
			System.exit(0);
		}
	}

	private static void showPiles() {
		System.out.println();
		System.out.println("Splitable Piles (Worth):");
		for (int i = 0; i < stackOfPiles.size(); i++) {
			System.out.print(stackOfPiles.get(i).getPileSize() + " ");
		}
		System.out.println();
	}

	private static void splitPile() {
		String splitter = "";
		String[] pick = null;
		while (splitter == "") { // input for choice
			showPiles();
			System.out.println("Pick a number to split and a pile (3/22 = three of twentytwo)");
			try {
				splitter = IO.getStdinScanner().next();
			} catch (InputMismatchException e) {
				IO.getStdinScanner().next();
			}
			pick = splitter.split("/");
			boolean pileValueOK = false;
			for (int i = 0; i < stackOfPiles.size(); i++) {
				if (Integer.parseInt(pick[1]) == stackOfPiles.get(i).getPileSize()) {
					pileValueOK = true;
					if (Integer.parseInt(pick[0]) >= stackOfPiles.get(i).getPileSize()) {
						System.out.println("Pick cannot be equal or more than pile itself");
						splitter = "";
					}
				}
			}
			if (splitter != "" && pileValueOK == false) {
				System.out.println("There is no pile with a count of " + pick[1]);
				splitter = "";
			} else if (Integer.parseInt(pick[0]) * 2 == Integer.parseInt(pick[1])) {
				System.out.println("You are not allowed to split into equal piles!");
				splitter = "";
			}

		}
		for (int i = 0; i < stackOfPiles.size(); i++) {
			if(stackOfPiles.get(i).getPileSize() == Integer.parseInt(pick[1])) {
				stackOfPiles.remove(i); // remove pile of choice
				break;
			}
		}
		stackOfPiles.add(new Pile(Integer.parseInt(pick[0]))); // create 1. new pile
		stackOfPiles.add(new Pile(Integer.parseInt(pick[1]) - Integer.parseInt(pick[0]))); // create 2. new pile
		System.out.println("-".repeat(120));
		System.out.println();
	}

}
