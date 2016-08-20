package org.qqq175.it_academy.jd1.classworks.parsers.factory;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 * 
 * @author qqq175
 */
public class DOMBuilder extends ParserBuilder {
	
	/** 
	 * @see org.qqq175.it_academy.jd1.classworks.parsers.factory.ParserBuilder#buildParser()
	 */
	@Override
	protected void buildParser() {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		DocumentBuilder builder = null;
		
		Document doc = null;
		
		//make new document builder
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}

		File f = new File(path);

		// make doc from file
		try {
			doc = builder.parse(f);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		parser = new DOMParser(doc);
	}
}
