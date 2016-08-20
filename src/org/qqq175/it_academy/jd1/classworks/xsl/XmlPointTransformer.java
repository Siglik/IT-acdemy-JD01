package org.qqq175.it_academy.jd1.classworks.xsl;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
public class XmlPointTransformer {

	public static void main(String[] args)  {
		TransformerFactory tf = TransformerFactory.newInstance();
		
		try {
			Transformer trans = tf.newTransformer(new StreamSource("resources/xml/PointToHtml.xsl"));
			trans.transform(new StreamSource("resources/xml/points.xml"), new StreamResult("resources/xml/points.html"));
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}	
	}
}