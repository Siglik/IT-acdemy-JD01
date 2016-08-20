package org.qqq175.it_academy.jd1.classworks.parsers.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.qqq175.it_academy.jd1.classworks.parsers.Point;

/**
 * StAX points parser
 * @author qqq175
 */
public class StAXParser implements PointParser {
	private XMLStreamReader reader;
	private String path;
	private Boolean isDone = false, isBegin = true;
	XMLInputFactory factory;
	
	/**
	 * construct parser by xml path
	 * @param path
	 */
	StAXParser(String path) {
		this.path = path;
		factory = XMLInputFactory.newFactory();
		inicializeParser();
		
	}

	@Override
	public String getRootName() {
		//check if parser at begin and reinitialize
		if (!isBegin) {
			inicializeParser();
			isDone = false;
		}
		try {
			while (reader.hasNext()) {
				int res = reader.next();
				if (res == XMLStreamConstants.START_ELEMENT) {
					isBegin = false;
					return reader.getLocalName();
				}
			}
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
		isBegin = false;
		return null;
	}

	@Override
	public List<Point> getPoints() {
		//check if point already parsed reinitialize parser
		if (isDone) {
			inicializeParser();
		}
		List<Point> points = new ArrayList<>();
		boolean isX = false;
		boolean isY = false;
		boolean isUnit = false;
		int x = 0, y = 0;
		String unit = null;
		
		//iterate all elements
		try {
			while (reader.hasNext()) {
				int res = reader.next();
				if (res == XMLStreamConstants.START_ELEMENT) {
					//remember current location
					if (reader.getLocalName().equals("x"))
						isX = true;
					else if (reader.getLocalName().equals("y"))
						isY = true;
					else if (reader.getLocalName().equals("unit"))
						isUnit = true;
				} else if (res == XMLStreamConstants.CHARACTERS) {
					//save values depends on current location
					if (isX) {
						x = Integer.valueOf(reader.getText());
						isX = false;
					} else if (isY) {
						y = Integer.valueOf(reader.getText());
						isY = false;
					} else if (isUnit) {
						unit = reader.getText();
						isUnit = false;
					}
				} else if (res == XMLStreamConstants.END_ELEMENT) {
					//when reach </point> - save the point
					if (reader.getLocalName().equals("point")) {
						points.add(new Point(x, y, unit));
						x = 0;
						y = 0;
						unit = null;
					}
				}
			}
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
		isDone = true;
		isBegin = false;
		return points;
	}
	
	private void inicializeParser(){
		//create XMLStreamReader instance
		try {
			reader = factory.createXMLStreamReader(new FileInputStream(path));
		} catch (FileNotFoundException | XMLStreamException e) {
			e.printStackTrace();
		}
	}
}
