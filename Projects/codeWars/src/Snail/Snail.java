package Snail;


public class Snail {

	public static int[] snail(int[][] array) {
		System.out.println(array.toString());
		int[] returnString = new int[array.length * array.length];
		if (array[0].length == 0) {
			return new int[] {};
		}
		int returnCount = 0;
		int x = 0;
		int y = 0;
		int minY = 0;
		int maxY = array.length - 1;
		int minX = 0;
		int maxX = array[0].length - 1;

		while (minX <= maxX && minY <= maxY) {
			while (x <= maxX) { // right
				returnString[returnCount] =  array[y][x];
				returnCount++;
				x++;
			}
			minY++;
			x--;
			y++;
			while (y <= maxY) { // down
				returnString[returnCount] =  array[y][x];
				returnCount++;
				y++;
			}
			maxX--;
			y--;
			x--;
			while (x >= minX) { // left
				returnString[returnCount] =  array[y][x];
				returnCount++;
				x--;
			}
			maxY--;
			x++;
			y--;
			while (y >= minY) { // up
				returnString[returnCount] =  array[y][x];
				returnCount++;
				y--;
			}
			minX++;
			x++;
			y++;
		}
		
		return returnString;
	}
	
}