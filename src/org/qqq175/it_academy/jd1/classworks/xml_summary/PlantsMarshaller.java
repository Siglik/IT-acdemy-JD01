package org.qqq175.it_academy.jd1.classworks.xml_summary;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.qqq175.it_academy.jd1.classworks.xml_summary.generated.Greenhouse;

public class PlantsMarshaller {
	
	public  Greenhouse parseGreenhouse(String path) {
		Greenhouse greengouse = null;
		try {
			JAXBContext jaxbc = JAXBContext.newInstance(Greenhouse.class);
			Unmarshaller unmarsh = jaxbc.createUnmarshaller();
			
			
		//	greengouse = (Greenhouse) unmarsh.unmarshal(new InputStreamReader(new FileInputStream(path), "UTF-8")); uncomment if .java in CP1251 on windows
			greengouse = (Greenhouse) unmarsh.unmarshal(new FileReader(path));
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return greengouse;
	}
}
