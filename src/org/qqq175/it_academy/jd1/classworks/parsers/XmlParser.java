package org.qqq175.it_academy.jd1.classworks.parsers;

import java.util.List;

import org.qqq175.it_academy.jd1.classworks.parsers.factory.ParserFactory;
import org.qqq175.it_academy.jd1.classworks.parsers.factory.PointParser;

/**
 * Parse points
 * @author qqq175
 */
public class XmlParser {

	public static void main(String[] args) {

		String path = "resources/xml/points.xml";
		ParserFactory pFactory = new ParserFactory();
		/*
		 * Parse with DOM parser
		 */
		System.out.println("DOM:");
		PointParser parser = pFactory.getParser(path, ParserFactory.Type.DOM);
		
		//print root element
		System.out.println(parser.getRootName());
		
		//get and print points
		List<Point> points = parser.getPoints();
		for (int i = 0; i < points.size(); i++)
			System.out.println("point " + (i + 1) + ": " + points.get(i));
		/*
		 * Parse with SAX parser
		 */
		System.out.println("SAX:");
		parser = pFactory.getParser(path, ParserFactory.Type.SAX);
		
		//print root element
		System.out.println(parser.getRootName());
		//get and print points
		points = parser.getPoints();
		for (int i = 0; i < points.size(); i++)
			System.out.println("point " + (i + 1) + ": " + points.get(i));
		
		/*
		 * Parse with StAX parser
		 */
		System.out.println("StAX:");
		parser = pFactory.getParser(path, ParserFactory.Type.STAX);
		
		//print root element
		System.out.println(parser.getRootName());
		
		//get and print points
		points = parser.getPoints();
		for (int i = 0; i < points.size(); i++)
			System.out.println("point " + (i + 1) + ": " + points.get(i));
	}

}
