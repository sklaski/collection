package determinantMatrix;

public class Matrix {

	public static int determinant(int[][] matrix) {
		int n = matrix.length;
		int[][] tmp = new int[matrix.length][matrix[0].length];
		int det = 0;
		
		if (matrix.length == 1) {
			det = matrix[0][0];
			return det;
		}

		if (n == 2) {
			det = (matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]);
			return det;
		}

		for (int i = 0; i < n; i++) {
			tmp = new int[n - 1][n - 1];

			for (int j = 1; j < n; j++) {
				for (int k = 0; k < n; k++) {
					if (k < i) {
						tmp[j - 1][k] = matrix[j][k];
					} else if (k > i) {
						tmp[j - 1][k - 1] = matrix[j][k];
					}
				}
			}

			// Rekursion
			det += (matrix[0][i] * Math.pow(-1, i) * determinant(tmp));
		}
		System.out.println(det);
		return det;

	}
}