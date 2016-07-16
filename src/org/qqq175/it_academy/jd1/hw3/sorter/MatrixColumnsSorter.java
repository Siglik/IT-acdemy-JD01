package org.qqq175.it_academy.jd1.hw3.sorter;
import java.util.Arrays;

/**
 * Sort matrix columns to arrange main diagonal elements by ascending
 * @author qqq175
 */
public class MatrixColumnsSorter {
//	private static int[][] matrix = { { 31, 15, 12, 22, 2, 14 }, 
//															{ 10, 17, 8, 33 , 3, 12},
//															{ 4, 18, 19, 27 , 4, 0},
//															{ 32, 17, 31, 25 , 5, 26},
//															{17, 25, 45, 41, 19, 35},
//															{39, 25, 47, 24, -2, 37}};
	
	static int SIZE = 20;
	static int[][] matrix = new int[SIZE][SIZE];
	
/**
 * Main class
 * @param args
 */
	public static void main(String[] args) {
		for(int i=0; i < SIZE; i++)
			for(int j=0; j< SIZE; j++)
				matrix[i][j] = (int)(Math.random()*SIZE*SIZE + (SIZE/5)*i);  //fill matrix by random values
		System.out.println("initial matrix:");
		MatrixSorterI.printMatrix(matrix);
		long start = System.currentTimeMillis();  //made some benchmark
		Node currentNode;
		int[] order = null;	
		//for all columns or until didn't get a result (order != null) try to find diagonal elements 
		for (int currentColumn = 0; (currentColumn < matrix.length) && (order == null); currentColumn++) {
			currentNode = new Node(null, currentColumn, matrix.length);
			order = findDiagonal(currentNode);	//call findDiagonal
		}
		if (order != null)  //check if order is null
		{
			System.out.println("found new order is " + Arrays.toString(order) + " in "
					+ (System.currentTimeMillis()-start) + " ms\n");  //print new order and benchmark
			matrix = MatrixSorterI.reorderMatrix(matrix, order);   //if order isn't - reorder matrix
			MatrixSorterI.printMatrix(matrix);
		} else {
			System.out.print("Указанную матрицу невозможно упорядочить согласно условиям задачи. (done in "+ (System.currentTimeMillis()-start) + " ms)\n");  //if order is null reorder is impossible
		}
}

	/**
	 * recursive method that  build a tree of nodes to find new order of matrix.
	 * @param currentNode - currentNode  - node of paths tree, where from to start search further
	 * @return if find a full path - return a new order as a int array,<br> else return null
	 */
	private static int[] findDiagonal(Node currentNode) {
		int[] order = null;
		int childNodesCounter = -1;	
		for (int column : currentNode.availableColumns) {
			/*
			 find in all unused columns elements that lower than current element value
			 and store it as child nodes to currentNode
			 */
			if (matrix[currentNode.rowId + 1][column] > matrix[currentNode.rowId][currentNode.columnId]) { 
				childNodesCounter++;																																			
				currentNode.branches[childNodesCounter] = new Node(currentNode, column, matrix.length);
				 if(currentNode.branches[childNodesCounter].rowId !=  matrix.length - 1)   //if last found node isn't in last row
				 {
					 order =  findDiagonal(currentNode.branches[childNodesCounter]);  //call recursive  this child nodes
					 if (order != null)  //when get path - return
					 {
						 return order;
					 }
				 } else {		//if last found node is in last row - we reached the end
					 return currentNode.branches[childNodesCounter].getPath();  //so just return the path
				 }
			}
		}
		return null; //if didn't reach the last row of the matrix  than - path is didnt exist - returning null
	}
}