/**
 * 
 */
package org.qqq175.it_academy.jd1.classworks.parsers.factory;

import java.io.IOException;
import java.util.List;

import org.qqq175.it_academy.jd1.classworks.parsers.Point;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

/**
 * @author qqq175
 *
 */
public class SAXParser implements PointParser {
	private String path;
	private XMLReader reader;
	private SAXHandler handler;
	private Boolean isParsed = false;

	SAXParser(String path, XMLReader reader, SAXHandler handler) {
		this.path = path;
		this.reader = reader;
		this.handler = handler;
	}

	/**
	 * @see org.qqq175.it_academy.jd1.classworks.parsers.factory.PointParser#getRootName()
	 */
	@Override
	public String getRootName() {
		checkAndParce(); //parce only one time

		return handler.getRootName();
	}

	/**
	 * parse file when first executed
	 */
	private void checkAndParce() {
		if (!isParsed) {
			try {
				reader.parse(path);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (SAXException e) {
				e.printStackTrace();
			}
			isParsed = true;
		}
	}

	/**
	 * @see org.qqq175.it_academy.jd1.classworks.parsers.factory.PointParser#getPoints()
	 */
	@Override
	public List<Point> getPoints() {
		checkAndParce(); //parse only one time
		
		return handler.getPoints();
	}
}
