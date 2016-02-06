package com.java.jaxb;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class JAXBApp {

	public static void main(String[] args) {
		File file=new File("src/employee.xml");
		try(FileOutputStream fOut=new FileOutputStream(file)){
			JAXBContext contextObj=JAXBContext.newInstance(Employee.class);
			Marshaller marshaller=contextObj.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			Contact contact1=new Contact();
			contact1.setContactType("Home");
			contact1.setContactNumber(9811553413L);
			
			Contact contact2=new Contact();
			contact2.setContactType("Office");
			contact2.setContactNumber(9650490700L);
			
			List<Contact> contactDetails=new ArrayList<Contact>();
			contactDetails.add(contact1);
			contactDetails.add(contact2);
			
			Employee employee=new Employee();
			employee.setId(1234);
			employee.setName("Aakash");
			employee.setContact(contactDetails);
			
			marshaller.marshal(employee, fOut);
			System.out.println("Marshalled Successfully");
		}
		catch(JAXBException |IOException exception){
			exception.printStackTrace();
		}
	}
}