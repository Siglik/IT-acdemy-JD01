package org.qqq175.it_academy.jd1.hw3.sorter;
/**
 * 
 */

/**
 * utility class for MatrixColumnsSorter class (for building a search tree)
 * 
 * @author qqq175
 *
 */
public class Node {
    /**
     * column number in initial matrix
     */
    int columnId;
    /**
     * row number in initial matrix
     */
    int rowId;
    /**
     * stores all possible ways down from this node
     */
    Node[] branches;
    /**
     * stores reference to parent node
     */
    Node root;
    /**
     * stores numbers of columns which aren't used in upper part of tree
     */
    int[] availableColumns;

    /**
     * Constructor
     * 
     * @param root
     *            - parent Node or null
     * @param columnId
     *            - column number
     * @param columnCount
     *            - array.length of array[N][N]
     */
    Node(Node root, int columnId, int columnCount) {
	if (root != null) { // constructor if root isn't null (new node has a
			    // parent node)
	    rowId = root.rowId + 1; // go one row down from parent node
	    if (rowId != columnCount) {
		/*
		 * if row number != array length - than we still have some rows
		 * under current and some unused columns because matrix is
		 * square, so unused rows == unused columns
		 */
		availableColumns = new int[columnCount - rowId - 1]; // create
								     // array
		int i = 0;
		for (int column : root.availableColumns) { // initialize array
		    // all columns that available for parent node is available
		    // for child node except current column
		    if (column != columnId) {
			availableColumns[i++] = column;
		    }
		}
	    }
	    // store reference to parent node
	    this.root = root;
	} else {
	    // constructor if root is null (new node hasn't a parent node)
	    rowId = 0;
	    this.root = null; // parent is null
	    availableColumns = new int[columnCount - 1]; // create array
	    int i = 0;
	    // initialize array
	    for (int j = 0; j < columnCount; j++) {
		// all columns are available except current column
		if (j != columnId) {
		    availableColumns[i++] = j;
		}
	    }
	}
	// if node has available columns, create the branches array for child
	// nodes
	if (availableColumns != null) {
	    branches = new Node[(availableColumns.length)];
	}
	this.columnId = columnId;
    }

    /**
     * return path from current node to first node (until parent == null) as an
     * int[] array, where each element is column number
     * 
     * @return int[] - array of column numbers, where stored diagonal elements
     *         column numbers
     *         <p>
     * 	<b><i>Example:</i></b><br>
     *         for matrix 3x3 if path ==<b><i>[2,0,1]</b></i><br>
     *         that mean that diagonal elements is (0,<b><i>2</b></i>),
     *         (1,<b><i>0</b></i>), (2,<b><i>1</b></i>)
     *         </p>
     */
    public int[] getPath() {
	// path size is rowId+1, because rowId starts from 0
	int[] path = new int[rowId + 1];
	Node tmpNode = this;
	int pathPointCounter = rowId;
	// go up upon a tree until reach first node fill path from left to right
	while (tmpNode != null) {
	    // add path point and decrement path point counter
	    path[pathPointCounter--] = tmpNode.columnId;
	    // step up(get parent node)
	    tmpNode = tmpNode.root;
	}
	return path;
    }
}
