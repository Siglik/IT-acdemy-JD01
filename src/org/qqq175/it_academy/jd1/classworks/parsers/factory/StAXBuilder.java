/**
 * 
 */
package org.qqq175.it_academy.jd1.classworks.parsers.factory;

/**
 * @author qqq175
 *
 */
public class StAXBuilder extends ParserBuilder {

	/**
	 * @see org.qqq175.it_academy.jd1.classworks.parsers.factory.ParserBuilder#buildParser()
	 */
	@Override
	protected void buildParser() {
		parser = new StAXParser(path);
	}

}
