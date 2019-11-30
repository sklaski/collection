
public class Pile {
	private int pileSize;

	public Pile (int pileSize) {
		this.pileSize = pileSize;
	}

	public int getPileSize() {
		return pileSize;
	}

	@Override
	public String toString() {
		return "Pile [pileSize=" + pileSize + "]";
	}
}
