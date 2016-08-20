/**
 * 
 */
package org.qqq175.it_academy.jd1.classworks.parsers.factory;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 * SAXBuilder
 * @author qqq175
 */
class SAXBuilder extends ParserBuilder {
	private XMLReader reader;
	private SAXHandler handler;
	
	/** 
	 * @see org.qqq175.it_academy.jd1.classworks.parsers.factory.ParserBuilder#buildParser()
	 */
	@Override
	protected void buildParser() {
		buildHandler();
		
		try {
			// create SAX-parser
			reader = XMLReaderFactory.createXMLReader();
			reader.setContentHandler(handler);
		} catch (SAXException e) {
			System.out.println(e);
		}
		
		parser = new SAXParser(path, reader, handler);
	}
	
	/**
	 * make SAX parser handler
	 */
	private void buildHandler(){
		handler = new SAXHandler();
	}

}
