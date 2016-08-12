/**
 * 
 */
package org.qqq175.it_academy.jd1.hw3_2;

/**
 * Find 0 in matrix and replace all elements in row and column by 0 and prints
 * both matrix<br>
 * <i>Exercise 8</i>
 * 
 * @author qqq175
 */
public class MatrixZeroFinder {

    /**
     * main method
     * 
     * @param args
     */
    public static void main(String[] args) {
	int[][] matrix = { { 31, 15, 12, 22, 2, 14 }, { 10, 17, 8, 33, 3, 12 }, { 4, 18, 19, 27, 4, 0 },
		{ 32, 17, 31, 25, 5, 26 }, { 17, 0, 45, 41, 19, 35 }, { 39, 25, 47, 24, -2, 37 },
		{ 3, 7, 4, 4, -2, 1 } };
	System.out.println("Original matrix: ");
	printMatrix(matrix);

	matrix = zeroRowAndColumn(matrix);

	System.out.println("Result matrix: ");
	printMatrix(matrix);
    }

    /**
     * Find 0 in matrix and replace all elements in row and column by 0
     * 
     * @param matrix
     *            - size NxM only
     * @return changed matrix
     */
    public static int[][] zeroRowAndColumn(int[][] matrix) {
	/* create new matrix */
	int[][] resultMatrix = new int[matrix.length][matrix[0].length];
	/* copy matrix */
	for (int i = 0; i < matrix.length; i++) {
	    for (int j = 0; j < matrix[0].length; j++) {
		resultMatrix[i][j] = matrix[i][j];
	    }
	}
	/* Find 0 and replace columns and rows */
	for (int i = 0; i < matrix.length; i++) {
	    for (int j = 0; j < matrix[0].length; j++) {
		if (matrix[i][j] == 0) {
		    for (int k = 0; k < matrix.length; k++) { // zero column
			resultMatrix[k][j] = 0;
		    }
		    for (int k = 0; k < matrix[0].length; k++) { // zero row
			resultMatrix[i][k] = 0;
		    }
		}
	    }
	}

	return resultMatrix;
    }

    /**
     * Get matrix NxM and print it
     * 
     * @param matrix
     *            - int array [n][m]
     */
    public static void printMatrix(int[][] matrix) {
	for (int[] line : matrix) {
	    System.out.print("|");
	    for (int elem : line) {
		System.out.printf("% 5d ", elem);
	    }
	    System.out.println("\t|");
	}
    }

}
