/**
 * 
 */
package org.qqq175.it_academy.jd1.airline.dbengine;

/**
 * return it if Key of db instances istn exist
 * @author qqq175
 *
 */
public class KeyIsNotExistException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 7857514822981629171L;

	/**
     * @param message
     */
    public KeyIsNotExistException(String message) {
	super(message);
    }
}
