package org.qqq175.it_academy.jd1.classworks.parsers.factory;

import java.util.List;

import org.qqq175.it_academy.jd1.classworks.parsers.Point;

/**
 * point parser interface
 * @author qqq175
 *
 */
public interface PointParser {
	/**
	 * @return xml root element name
	 */
	String getRootName();
	
	/**
	 * @return parsed point list
	 */
	List<Point> getPoints();
}
