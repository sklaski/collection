import java.util.ArrayList;
import java.util.Random;

public class Aquarium {

	private ArrayList<Fish> fishInRow = new ArrayList<>();
	public int width;
	public int height;
	public int min;
	public long max;

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public long getMax() {
		return max;
	}

	public void setMax(long max) {
		this.max = max;
	}

	public Aquarium() {
		this(10, 5, 3);
	}

	public Aquarium(int width, int height, int numFishes) {
//		if (width < numFishes) {
//			throw new IllegalArgumentException("Number of fishies can't exceed heigth of aquarium!");
//		}
		this.width = width;
		this.height = height;
		this.min = numFishes;
		this.max = 0;
		for (int y = 0; y < numFishes; y++) {
			addRandomFish();
//			addFish();
//			addShark();
//			addBlowfish();
//			addSwordfish();
		}
	}

	public void getNewFish() {
		addRandomFish();
	}
	
	private void addRandomFish() {
		int chance = new Random().nextInt(5) + 1;
//		chance = 7; //only "normal" fish
		switch (chance) {
		case 1:
			addShark();
			break;
		case 2:
			addBlowfish();
			break;
		case 3:
			addSwordfish();
			break;
		case 4:
			addKrill();
			break;
		default:
			addFish();
			break;
		}
	}

	private void addFish() {
		Fish fish = new Fish(randomX(), randomY(), randomDirection(), 1/3f, new String("><>"), new String("<><"));
		fishInRow.add(fish);
	}

	private void addShark() {
		Fish fish = new Shark(randomX(), randomY(), randomDirection());
		fishInRow.add(fish);
	}

	private void addBlowfish() {
		Fish fish = new Blowfish(randomX(), randomY(), randomDirection());
		fishInRow.add(fish);
	}

	private void addKrill() {
		Fish fish = new Krill(randomX(), randomY(), randomDirection());
		fishInRow.add(fish);
	}

	private void addSwordfish() {
		Fish fish = new Swordfish(randomX(), randomY(), randomDirection());
		fishInRow.add(fish);
	}

	public ArrayList<Fish> getFishInRow() {
		return fishInRow;
	}

	public int getWidth() {
		return this.width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return this.height;
	}

	@Override
	public String toString() {
		return "Aquarium [fishInRow=" + fishInRow + ", width=" + width + ", height=" + height + "]";
	}

	public void setHeight(int height) {
		this.height = height;
	}

	private int randomX() {
		return new Random().nextInt(getWidth());
	}

	private int randomY() {
		int returnY = 0;
//		boolean freeRow = false; //fish may share a row now
//		while (!freeRow) {
//			freeRow = true;
			int Y = new Random().nextInt(getHeight());
//			for (Fish i : fishInRow) {
//				if (i.getPositionY() == Y) {
//					freeRow = false;
//				}
//			}
			returnY = Y;
//		}
		return returnY;
	}

	private boolean randomDirection() {
		boolean rd = new Random().nextBoolean();
		return rd;
	}
}