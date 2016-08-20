/**
 * 
 */
package org.qqq175.it_academy.jd1.classworks.parsers.factory;

import java.util.ArrayList;
import java.util.List;

import org.qqq175.it_academy.jd1.classworks.parsers.Point;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

/**
 * @author qqq175
 *
 */
public class SAXHandler extends DefaultHandler implements PointParser {
	String element;
	Point currPoint;
	List<Point> points;
	String rootName = null;
	
	/**
	 * Constructor
	 */
	public SAXHandler() {
		points = new ArrayList<>();
	}

	@Override
	public void startDocument() {}


	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attrs) {
		//if first element didnt found current is first
		//save it
		if(rootName == null){
			rootName = qName;
		}
		
		element = localName;
		
		//create new point if reached <point> tag
		if(element.equals("point")){
			currPoint = new Point();
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) {
		//fill currentPoint fields
		switch (element){
		case "x":
			currPoint.setX(Integer.parseInt(new String(ch, start, length)));
			break;
		case "y":
			currPoint.setY(Integer.parseInt(new String(ch, start, length)));
			break;
		case "unit":
			currPoint.setUnit(new String(ch, start, length));
			break;
		}
		
	}

	@Override
	public void endElement(String uri, String localName, String qName) {
		//save current point if reached </point> tag
		if (localName.equals("point")){
			points.add(currPoint);
		}
		element = "";
	}

	@Override
	public void endDocument() {}

	@Override
	public String getRootName() {
		return rootName;
	}

	@Override
	public List<Point> getPoints() {
		return points;
	}
}
