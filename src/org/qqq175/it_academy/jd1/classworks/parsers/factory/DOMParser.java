package org.qqq175.it_academy.jd1.classworks.parsers.factory;

import java.util.ArrayList;
import java.util.List;

import org.qqq175.it_academy.jd1.classworks.parsers.Point;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * DOM parser for points xml
 * 
 * @author qqq175
 */
public class DOMParser implements PointParser {
	Document doc = null;
	final Element root;

	/**
	 * @param doc
	 */
	DOMParser(Document doc) {
		//save doc root
		root = doc.getDocumentElement();
	}

	@Override
	public String getRootName() {
		return root.getTagName();
	}

	@Override
	public List<Point> getPoints() {
		List<Point> points = new ArrayList<>();
		
		NodeList nList = root.getChildNodes();
		
		//iterate pointList child nodes
		for (int i = 0; i < nList.getLength(); i++) {
			
			//if found an elemennt
			if (nList.item(i) instanceof Element) {
				//get point child nodes
				NodeList nListPoint = nList.item(i).getChildNodes();
				
				int x = 0, y = 0;
				String unit = null;
				
				//iterate points child nodes
				for (int j = 0; j < nListPoint.getLength(); j++) {

					if (nListPoint.item(j) instanceof Element) {
						
						String elName = ((Element) nListPoint.item(j)).getTagName();
						
						//determine elemnt by name and get it value
						switch (elName) {
						case "x":
							x = Integer.valueOf(nListPoint.item(j).getTextContent());
							break;
						case "y":
							y = Integer.valueOf(nListPoint.item(j).getTextContent());
							break;
						case "unit":
							unit = (nListPoint.item(j)).getTextContent();
							break;
						}
					}
				}
				
				//save current point
				points.add(new Point(x, y, unit));
			}
		}
		return points;
	}
}
