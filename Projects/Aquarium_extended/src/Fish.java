public class Fish implements Comparable<Fish> {

	private int positionX;
	private int positionY;
	private String body;
	private String bodyReverse;
	private float yChance;
	private boolean direction;

	public Fish(int positionX, int positionY, boolean direction, float yChance, String body, String bodyReverse) {
		this.positionX = positionX;
		this.positionY = positionY;
		this.direction = direction;
		this.yChance = yChance;
		this.body = body;
		this.bodyReverse = bodyReverse;
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

	public String getBodyReverse() {
		return bodyReverse;
	}

	public void setBodyReverse(String bodyReverse) {
		this.bodyReverse = bodyReverse;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public float getyChance() {
		return yChance;
	}

	public String getBody() {
		return this.body;
	}

	public String getBodyReversed() {
		return this.bodyReverse;
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
		return "Fish [positionX=" + positionX + ", positionY=" + positionY + ", body=" + body + ", bodyReverse="
				+ bodyReverse + ", yChance=" + yChance + ", direction=" + direction + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + positionX;
		result = prime * result + positionY;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Fish))
			return false;
		Fish other = (Fish) obj;
		if (positionX != other.positionX)
			return false;
		if (positionY != other.positionY)
			return false;
		return true;
	}

	@Override
	public int compareTo(Fish that) {
		if (this.getPositionY() - that.getPositionY() != 0) {
			return this.getPositionY() - that.getPositionY();
		}
		return this.getPositionX() - that.getPositionX();
	}
}
