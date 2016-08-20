package org.qqq175.it_academy.jd1.classworks.xml_summary;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class XMLValidator {
	private String lastError = "";
	
	public boolean validate(String xmlPath, String xsdPath) {
		
		Source xmlFile = new StreamSource(new File(xmlPath));
		SchemaFactory schemaFactory = SchemaFactory
				.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

		Schema schema;
		try {
			schema = schemaFactory.newSchema(new File(xsdPath));
			Validator validator = schema.newValidator();
			validator.validate(xmlFile);
			return true;
		} catch (SAXException e) {
			lastError = e.getLocalizedMessage();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * @return the lastError
	 */
	public String getLastError() {
		return lastError;
	}
}
