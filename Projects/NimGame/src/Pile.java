import java.awt.List;
import java.util.ArrayList;

public class Pile {
	private long pileSize;

	public Pile(long pileSize) {
		super();
		this.pileSize = pileSize;
	}
		
	public long getPileSize() {
		return pileSize;
	}

	public void setPileSize(long pileSize) {
		this.pileSize = pileSize;
	}

	@Override
	public String toString() {
		return "Pile [pileSize=" + pileSize +"]";
	}
	
}
