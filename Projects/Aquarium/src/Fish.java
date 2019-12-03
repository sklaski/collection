public class Fish {

	private int positionX;
	private int positionY;
	private boolean direction;
	
	public Fish(int positionX, int positionY, boolean direction) {
		this.positionX = positionX;
		this.positionY = positionY;
		this.direction = direction;
	}
	
	public int getPositionX() {
		return this.positionX;
	}
	
	public int getPositionY() {
		return this.positionY;
	}
	
	public boolean isDirection() {
		return this.direction;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	public void setDirection(boolean direction) {
		this.direction = direction;
	}

	@Override
	public String toString() {
		return "Fish [positionX=" + positionX + ", positionY=" + positionY + ", direction=" + direction + "]";
	}
}
