package org.qqq175.it_academy.jd1.classworks.xml_summary;

import org.qqq175.it_academy.jd1.classworks.xml_summary.generated.Greenhouse;

public class GreenhouseManager {
	static String XML_PATH = "resources/xml/classworks/xml_summary/greenhouse.xml";
	static String XSD_PATH = "resources/xml/classworks/xml_summary/greenhouse.xsd";
	
	public static void main(String[] args) {
		PlantsMarshaller plantMarch = new PlantsMarshaller();
		XMLValidator validator = new XMLValidator();
		if (validator.validate(XML_PATH, XSD_PATH)) {
			System.out.println("Xml валиден.");
			Greenhouse greenhouse = plantMarch.parseGreenhouse(XML_PATH);
			System.out.println(greenhouse);
		} else {
			System.out.println("Xml инвалиден.\n Причина: " + validator.getLastError());
		}
	}
}
