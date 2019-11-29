import java.util.ArrayList;
import java.util.Random;

public class Aquarium {

	private ArrayList<Fish> fishInRow = new ArrayList<>();
	public int width;
	public int height;
	
	public Aquarium() {
		this(10, 5, 3);
	}
		
	public Aquarium(int width, int height, int numFishes) {
		if(width < numFishes) {
			throw new IllegalArgumentException("Number of fishies can't exceed heigth of aquarium!");
		}
		this.width = width;
		this.height = height;
		for (int y = 0; y < numFishes; y++) {
			addFish(y);
		}
	}

	public void addFish(int y) {
		Fish fish = new Fish(randomX(), randomY(), randomDirection());
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
		boolean freeRow = false;
		int returnY = 0;
		while (!freeRow) {
			freeRow = true;
			int Y = new Random().nextInt(getHeight());
			for (Fish i : fishInRow) {
				if (i.getPositionY() == Y) {
					freeRow = false;
				}
			}
			returnY = Y;
		}
		return returnY;
	}
	
	private boolean randomDirection() {
		boolean rd = new Random().nextBoolean();
		return rd;
	}
}