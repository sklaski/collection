public class Swim {

	public static void main(String[] args) {
		Aquarium Tank = new Aquarium(30, 15, 3);
//		System.out.println(Tank);
		showAqua(Tank);
	}

	public static void showAqua(Aquarium showTank) {
		while (true) {
			System.out.println(" ");
			System.out.println(" ");
			System.out.println(" ");
			String showXY;
			System.out.println(showTank);
			for (int y = 0; y < showTank.getHeight(); y++) {
				System.out.print("|");
				for (int x = 0; x < showTank.getWidth(); x++) {
					showXY = " ".repeat(3);
					for (int i = 0; i < showTank.getFishInRow().size(); i++) {
						if (showTank.getFishInRow().get(i).getPositionX() == x
								&& showTank.getFishInRow().get(i).getPositionY() == y) {
							if (showTank.getFishInRow().get(i).isDirection()) {
								showXY = "><>";
							} else {
								showXY = "<><";
							}
							break;
						}
					}
					System.out.print(showXY);
				}
				System.out.println("|");
			}
			System.out.println("|" + "_".repeat(showTank.getWidth() * 3) + "|");
			// move fishies
			for (int i = 0; i < showTank.getFishInRow().size(); i++) {
				if (showTank.getFishInRow().get(i).isDirection()) {
					if (showTank.getFishInRow().get(i).getPositionX() == showTank.getWidth() - 1) {
						showTank.getFishInRow().get(i).setDirection(false);
					} else {
						showTank.getFishInRow().get(i).setPositionX(showTank.getFishInRow().get(i).getPositionX() + 1);
					}
				} else {
					if (showTank.getFishInRow().get(i).getPositionX() == 0) {
						showTank.getFishInRow().get(i).setDirection(true);
					} else {
						showTank.getFishInRow().get(i).setPositionX(showTank.getFishInRow().get(i).getPositionX() - 1);
					}
				}
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("ERROR for sleep");
			}
		}
	}
}