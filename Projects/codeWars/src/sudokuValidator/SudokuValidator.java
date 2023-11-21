package sudokuValidator;

import java.util.ArrayList;
import java.util.Arrays;

public class SudokuValidator {
	public static boolean check(int[][] sudoku) {
		ArrayList<Integer[]> checkRow = new ArrayList<>();
		ArrayList<Integer[]> checkColumn = new ArrayList<>();
		ArrayList<Integer[]> sectionCube = new ArrayList<>();
		for (int i = 0; i < 9; i++) {
			checkRow.add(new Integer[9]);
			checkColumn.add(new Integer[9]);
			sectionCube.add(new Integer[9]);
		}
		for (int y = 0; y < sudoku.length; y++) {
			for (int x = 0; x < sudoku[y].length; x++) {
				System.out.print(sudoku[y][x]);
				if (Arrays.asList(checkRow.get(y)).contains(sudoku[y][x])) {
					System.out.println();
					System.out.println("Row: " + y);
					return false;
				}
				if (Arrays.asList(checkColumn.get(x)).contains(sudoku[y][x])) {
					System.out.println();
					System.out.println("Column: " + x);
					return false;
				}
				// =((ROUNDDOWN($G2/3))+(ROUNDDOWN(H$1/3)))+2*ROUNDDOWN($G2/3)
				if (Arrays.asList(sectionCube.get((x / 3) + (y / 3) + 2 * (y / 3))).contains(sudoku[y][x])) {
					System.out.println();
					System.out.println("sectionCube: " + ((x / 3) + (y / 3) + 2 * (y / 3)) + " - " + sudoku[y][x]
							+ " at " + y + ", " + x);
					for (int i = 0; i < 9; i++) {
						System.out.println(i + ": " + sectionCube.get((y / 3) + (x / 3) + 2 * (y / 3))[i]);
					}
					return false;
				}
				checkRow.get(y)[x] = sudoku[y][x];
				checkColumn.get(x)[y] = sudoku[y][x];
				int sectionNumber = (x / 3) + (y / 3) + 2 * (y / 3);
				int innerSection = (y - 3 * (y / 3)) * 3 + (x % 3);
				System.out.println("Section: " + sectionNumber + "-" + innerSection + " add: " + sudoku[y][x]);
				sectionCube.get((x / 3) + (y / 3) + 2 * (y / 3))[(y - 3 * (y / 3)) * 3 + (x % 3)] = sudoku[y][x];
				if (sudoku[y][x] == 0) {
					return false;
				}
			}
			System.out.println();
		}
		return true;
	}
}