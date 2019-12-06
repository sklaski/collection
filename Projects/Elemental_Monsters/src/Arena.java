import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;

public class Arena {

	private static ArrayList<Monster> combatants = new ArrayList<Monster>();

	public static void main(String[] args) {

		// some monsters to work with!
		combatants.add(new GrassMonster("First", 15, 60));
		combatants.add(new FireMonster("Second", 22, 40));
		combatants.add(new WaterMonster("Third", 9, 200));
		combatants.add(new FireMonster("Forth", 32, 35));
		combatants.add(new WaterMonster("Cheater", 42, 400));
		while (true) {
			doRound();
		}

	}

	private static void doRound() {
		showMonsters();
		boolean maybeInput = true;
		String input = "";
		while (maybeInput) {
			System.out.println("Your next action:");
			System.out.print("Create a monster (m) / ");
			System.out.print("Pick Champion (p) / ");
			System.out.println("Quit (q)");
			try {
				input = IO.getStdinScanner().next();
			} catch (InputMismatchException e) {
				System.out.println("-".repeat(120));
				IO.getStdinScanner().next();
			}
			input = input.toLowerCase();
			String[] possibleInput = new String[] { "m", "p", "q" };
			List<String> possibleList = Arrays.asList(possibleInput);
			if (possibleList.contains(input)) {
				maybeInput = false;
			}

		}

		switch (input) {
		case "m":
			createMonster();
			break;
		case "p":
			pickUpFight();
			break;
		default:
			System.out.println("\n".repeat(2) + "Goodbye");
			System.exit(0);
			break;
		}
	}

	private static void createMonster() {
		System.out.println("Determine monster's freatures:");
		System.out.print("Name: ");
		String name = "";
		try {
			name = IO.getStdinScanner().next();
		} catch (InputMismatchException e) {
			System.out.println("-".repeat(120));
			IO.getStdinScanner().next();
		}
		System.out.print("Damage: ");
		int damage = 0;
		try {
			damage = IO.getStdinScanner().nextInt();
		} catch (InputMismatchException e) {
			System.out.println("-".repeat(120));
			IO.getStdinScanner().nextInt();
		}
		System.out.print("Life: ");
		int life = 0;
		try {
			life = IO.getStdinScanner().nextInt();
		} catch (InputMismatchException e) {
			System.out.println("-".repeat(120));
			IO.getStdinScanner().nextInt();
		}
		System.out.print("Type: ");
		String type = "";
		try {
			type = IO.getStdinScanner().next();
		} catch (InputMismatchException e) {
			System.out.println("-".repeat(120));
			IO.getStdinScanner().next();
		}

		// todo "sub"Monsters
		combatants.add(new Monster(name, damage, life, type));
	}

	private static void showMonsters() {
		System.out.println("\n".repeat(2));
		for (int i = 0; i < combatants.size(); i++) {
			System.out.println(
					"Nr. " + (i + 1) + " - " + combatants.get(i).getName() + ": Dam " + combatants.get(i).getDamage()
							+ " Life: " + combatants.get(i).getLife() + " Kind: " + combatants.get(i).getType());
		}
	}

	private static void pickUpFight() {
		int counterRounds = 0;
		if (combatants.isEmpty()) {
			System.out.println("\n".repeat(2) + "No monsters in arena -> nothing to pick from!!!");
		} else {
			showMonsters();
			System.out.println("Pick a number!");
			int combatant = 0;
			while (combatant == 0) {
				try {
					combatant = IO.getStdinScanner().nextInt();
				} catch (InputMismatchException e) {
					System.out.println("-".repeat(120));
					IO.getStdinScanner().nextInt();
				}
				if (combatant > combatants.size()) {
					combatant = 0;
				}
			}
			Monster champion = combatants.get(combatant - 1);
			Monster opponent = randomOpponent(champion);
			while ((!(opponent == null)) && champion.getLife() > 0 && opponent.getLife() > 0 && counterRounds < 120) { // fight
																														// to
																														// the
																														// death
				counterRounds++;
				champion.takeHit(opponent);
				opponent.takeHit(champion);

			}
			if (opponent != null) {
				if (opponent.getLife() <= 0 && 0 < champion.getLife()) {
					System.out.println("Your " + champion.getName() + " has won against " + opponent.getName() + "!");
				} else if (champion.getLife() <=0 && 0 < opponent.getLife()) {
					System.out.println(opponent.getName() + " has destroyed your champion " + champion.getName() + "!");
				} else if (champion.getLife() == opponent.getLife() && champion.getLife() >= 0) {
					System.out.println(
							"Amazing double KO between " + champion.getName() + " and " + opponent.getName() + "!");
				} else if (champion.getLife() == opponent.getLife() && champion.getLife() == 0) {
					System.out.println("Both monsters are dead now!");
				}else if (counterRounds == 500) {
					System.out.println("Timeout!");
				}
			}
			// clear up
			for (int i = combatants.size() - 1; i >= 0; i--) {
				if (combatants.get(i).getLife() <= 0) { // remove dead monsters
					combatants.remove(i);
				} else {
					combatants.get(i).setLife((int) (combatants.get(i).getLife() * 1.2)); // regenerate 20% of current
																							// life
					if (combatants.get(i).getMaxLife() < combatants.get(i).getLife()) { // clear "too much" hit points
						combatants.get(i).setLife(combatants.get(i).getMaxLife());
					}
					System.out.println(combatants.get(i).getName() + " regenerates to " + combatants.get(i).getLife());
				}
			}
		}

	}

	private static Monster randomOpponent(Monster champion) {
		if (combatants.isEmpty()) {
			System.out.println("You need to catch (create) some monsters!");
			return null;
		}
		if (combatants.size() == 1) {
			System.out.println(
					"\n".repeat(2) + champion.getName() + "wins be default as no enemy dares to challenge him!");
			return null;
		} else {
			boolean opponentFound = false;
			int randomNumber = 0;
			while (!opponentFound) {
				randomNumber = new Random().nextInt(combatants.size());
				opponentFound = true;
				if (champion.equals(combatants.get(randomNumber))) {
					opponentFound = false;
				}
			}
			return combatants.get(randomNumber);
		}
	}

}
