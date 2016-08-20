/**
 * 
 */
package org.qqq175.it_academy.jd1.classworks.parsers.factory;


/**
 * @author qqq175
 *
 */
public abstract class ParserBuilder {
	PointParser parser;
	String path;
	
	/**
	 * return builded parser
	 * @return
	 */
	public PointParser getParser(){
		return parser;
	}
	
	/**
	 * set XML filepath
	 * @param path
	 */
	protected void setPath (String path){
		this.path = path;
	}
	
	/**
	 * builds concrete parser
	 */
	protected abstract void buildParser();
}
