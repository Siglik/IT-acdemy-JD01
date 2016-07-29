package org.qqq175.it_academy.jd1.airline.dbengine;
/**
 * throw it if someone attempt to create duplicate DB
 * @author user
 *
 */
public class DuplicateKeysException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = -3660397294908800852L;

	/**
     * @param message
     */
    public DuplicateKeysException(String message) {
	super(message);
    }
}