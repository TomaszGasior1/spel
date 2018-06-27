package com.tomaszgasior.spring.spel;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

public class App {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/tomaszgasior/spring/spel/beans/beans.xml");
		
		OffersDAO offersDao = (OffersDAO)context.getBean("offersDao");
		
		Offer updateoffer = new Offer(1,"Clare", "Clare@gmail.com", "Web designer");
		if(offersDao.update(updateoffer))
			System.out.println("Object updated");
		else
			System.out.println("Cannot update object");
		
		try {
			
			Offer offer1 = new Offer("Tom", "Tom@gmail.com", "looking for job");
			Offer offer2 = new Offer("Dave", "Dave@gmail.com", "coding in java");
			
			if(offersDao.create(offer1)){
				System.out.println("Created record");
			}
			
			if(offersDao.create(offer2)){
				System.out.println("Created record");
			}
			
			List<Offer> offers = offersDao.getOffers();
			
			for(Offer offer:offers)
				System.out.println(offer);
			
			Offer offer = offersDao.getOffer(2);
			System.out.println(offer);
			
		} 
		catch(CannotGetJdbcConnectionException e){
			
			System.out.println("Cannot get database connection.");
			
		} 
		
		catch (DataAccessException ex) {
			System.out.println(ex.getMessage());
			System.out.println(ex.getClass());
			
		}
		
		
		((ClassPathXmlApplicationContext)context).close();

	}

}
