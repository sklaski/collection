
public class Frequency {

	private String string;
	private int count;
	
	public Frequency(String string) {
		super();
		this.string = string;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getString() {
		return string;
	}

	@Override
	public String toString() {
		return "Frequency [string=" + string + ", count=" + count + "]";
	}
}
