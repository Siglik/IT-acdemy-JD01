package org.qqq175.it_academy.jd1.hw3;
import java.util.Arrays;

/**
 * 
 */

/**
 * Class prints matrix diagonals
 * @author qqq175
 *
 */
public class MatrixDiagonalsExtractor {

	/**
	 * Main class
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 5;
		double[][] matrix = new double[n][n];
		
		fillMatrixRandom(matrix);
		System.out.println("Random generated matrix:");
		printMatrix(matrix);
		
		System.out.println("\nMain diagonal elements: " + Arrays.toString(getMainDiagonal(matrix)));
		System.out.println("\nAdditional diagonal elements: " + Arrays.toString(getAdditionalDiagonal(matrix)));
	}
	/**
	 * Get matrix NxM and print it
	 * @param matrix - double array [n][m]
	 */
	public static void printMatrix(double[][] matrix)
	{
		for(double [] line : matrix)
		{
			System.out.print("|");
			for(double elem: line){
				System.out.printf("% 8.3f ", elem);
			}
			System.out.println("\t|");
		}
	}
	
	/**
	 * Fill matrix with random numbers
	 * @param matrix - double array [n][m]
	 */
	public static void fillMatrixRandom(double[][] matrix)
	{
		for(int i = 0; i < matrix.length; i++ ){
			for(int j = 0; j < matrix[i].length; j++){
				matrix[i][j] = Math.random()*19.9 - 10;
			}
		}
	}

	/**
	 * return matrix main diagonal elements
	 * @param matrix - double array [n][m]
	 * @return array of diagonal elements
	 */
	public static double[] getMainDiagonal(double[][] matrix)
	{
		double[] result = new double[matrix.length];
		for(int i = 0; i < matrix.length; i++){
			result[i] = matrix[i][i];
		}
		return result;
	}
	
	/**
	 * return matrix additional diagonal elements
	 * @param matrix - double array [n][m]
	 * @return array of diagonal elements
	 */
	public static double[] getAdditionalDiagonal(double[][] matrix)
	{
		double[] result = new double[matrix.length];
		for(int i = 0, j = matrix.length - 1; i < matrix.length && j >= 0; i++, j--){
			result[i] = matrix[i][j];
		}
		return result;
	}
}