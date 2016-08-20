/**
 * 
 */
package org.qqq175.it_academy.jd1.classworks.parsers.factory;

/**
 * @author qqq175
 *
 */
public class ParserFactory {
	
	/**
	 * supported parser types
	 * @author qqq175
	 *
	 */
	public enum Type{
		DOM, SAX, STAX;
	}
	
	/**
	 * return concrete parser
	 * @param path
	 * @param type
	 * @return
	 */
	public PointParser getParser(String path, Type type){
		ParserBuilder builder;
		
		switch (type){
		case DOM:
			builder = new DOMBuilder();
			break;
		case SAX:
			builder = new SAXBuilder();
			break;
		case STAX:
			builder = new StAXBuilder();
			break;
		default:
			return null;
		}
		
		builder.setPath(path);
		builder.buildParser();
		
		return builder.getParser();
	}
}
