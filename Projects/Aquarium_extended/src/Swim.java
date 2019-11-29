import java.util.HashMap;
import java.util.Random;

public class Swim {

	public static void main(String[] args) {
		int numberOfFishes = 3000;
		Aquarium Tank = new Aquarium(120, 25, 50); // (width, height, numberOfFishies
//		System.out.println(Tank);
		while (true) {
			showAqua(Tank);
			moveFish(Tank);
			yChangeByChance(Tank);
			getNewFish(Tank, numberOfFishes);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				System.out.println("ERROR for sleep");
			}
		}
	}

	private static void getNewFish(Aquarium tank, int numberOfFishes) {
		if (tank.getFishInRow().size() < numberOfFishes) {
			if (new Random().nextFloat() < (1 / 3f)) {
				tank.getNewFish();
			}
		}
	}

	public static void showAqua(Aquarium showTank) {
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ");
//		Collections.sort(showTank.getFishInRow()); //sort fishies, lowest y, lowest x
//		System.out.println(showTank.getFishInRow());
		String row = null;
		String fishBody = null;

		for (int y = 0; y < showTank.getHeight(); y++) {
			row = " ".repeat(showTank.getWidth()); // create empty row (with water :))
			for (int x = 0; x < showTank.getWidth(); x++) {// any fish on this coordinate?!
				for (int i = 0; i < showTank.getFishInRow().size(); i++) {
					if (showTank.getFishInRow().get(i).getPositionX() == x
							&& showTank.getFishInRow().get(i).getPositionY() == y) {// fish found!
						if (showTank.getFishInRow().get(i).isDirection()) {
							fishBody = showTank.getFishInRow().get(i).getBody();
						} else {
							fishBody = showTank.getFishInRow().get(i).getBodyReversed();
						}
						if (showTank.getFishInRow().get(i).getPositionX()
								+ showTank.getFishInRow().get(i).getBody().length() > showTank.getWidth()) {
							showTank.getFishInRow().get(i).setPositionX(
									showTank.getWidth() - showTank.getFishInRow().get(i).getBody().length());
						}
						row = (row.substring(0, showTank.getFishInRow().get(i).getPositionX()) + fishBody
								+ row.substring(showTank.getFishInRow().get(i).getPositionX() + fishBody.length(),
										showTank.getWidth()));
						if (showTank.getFishInRow().get(i).getBody().equals("Plop!")) {
							showTank.getFishInRow().remove(i);
						}
					}
				}
			}
			System.out.println("|" + row + "|");
		}
		System.out.println("|" + "-".repeat(showTank.getWidth()) + "|");// tank body
		if (showTank.getMin() > showTank.getFishInRow().size()) {
			showTank.setMin(showTank.getFishInRow().size());
		}
		if(showTank.getMax() < showTank.getFishInRow().size()) {
			showTank.setMax(showTank.getFishInRow().size());
		}
		
		System.out.println("Fish in Tank: (min/now/max) " + showTank.getMin() + "/" + showTank.getFishInRow().size() + "/" + showTank.getMax());

	}

	public static void moveFish(Aquarium showTank) { // move fishies
		HashMap<Integer, Integer> positionAllocated = new HashMap<Integer, Integer>(); // mark position as allocated
		for (int i = showTank.getFishInRow().size() - 1; i >= 0; i--) {
//			if (positionAllocated.get((Integer)tmpFish.getPositionX()) != ((Integer)tmpFish.getPositionY())) {
			if (positionAllocated.get((Integer) showTank.getFishInRow().get(i).getPositionX()) != ((Integer) showTank
					.getFishInRow().get(i).getPositionY())) {
//				positionAllocated.put(((Integer)tmpFish.getPositionX()), ((Integer)tmpFish.getPositionY()));
				positionAllocated.put((Integer) showTank.getFishInRow().get(i).getPositionX(),
						(Integer) showTank.getFishInRow().get(i).getPositionY());
			} else {
//					if (tmpFish != null &&							
//						showTank.getFishInRow().set(i, null);
//				showTank.getFishInRow().remove(i);
				showTank.getFishInRow().get(i).setBody("Plop!");
				showTank.getFishInRow().get(i).setBodyReverse("Plop!");
//						System.out.println(showTank.getFishInRow());
//						showTank.getFishInRow().get(i);
//						System.out.println(showTank.getFishInRow());
			}
//				}
//			}

			if (showTank.getFishInRow().get(i).isDirection()) {
				if (showTank.getFishInRow().get(i).getPositionX()
						+ showTank.getFishInRow().get(i).getBody().length() >= showTank.getWidth() - 1) {
					showTank.getFishInRow().get(i).setDirection(false);
				} else {
					showTank.getFishInRow().get(i).setPositionX(showTank.getFishInRow().get(i).getPositionX() + 1);
				}
			} else if (showTank.getFishInRow().get(i).getPositionX() == 0) {
				showTank.getFishInRow().get(i).setDirection(true);
			} else {
				showTank.getFishInRow().get(i).setPositionX(showTank.getFishInRow().get(i).getPositionX() - 1);
			}
		}
	}

	public static void yChangeByChance(Aquarium showTank) {
		for (Fish tmpFish : showTank.getFishInRow()) {
			float yChance = new Random().nextFloat();
			boolean yDirection = new Random().nextBoolean();
			if (yChance <= tmpFish.getyChance()) { // change row
				if (yDirection) {
					if (tmpFish.getPositionY() != 0)
						tmpFish.setPositionY(tmpFish.getPositionY() - 1);
				} else {
					if (tmpFish.getPositionY() != showTank.getHeight() - 1)
						tmpFish.setPositionY(tmpFish.getPositionY() + 1);
				}

			}
		}
	}
}