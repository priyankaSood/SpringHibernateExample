package main.java.com.journaldev.dao.controller;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import main.java.com.journaldev.dao.PersonDAO;
import main.java.com.journaldev.model.Person;
@Controller
@RequestMapping("/person")
public class StateController {	
	@RequestMapping(method = RequestMethod.GET)	
	public  @ResponseBody String getState() {
			String result = null;
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		
		PersonDAO personDAO = context.getBean(PersonDAO.class);
		
		Person person = new Person();
		person.setName("Namarita"); person.setCountry("India");
		
		personDAO.save(person);
		
		//System.out.println("Person::"+person);
		
		List<Person> list = personDAO.list();
		
		for(Person p : list){
			result = "Person details have been added with the id: "+p.getId();
		}
		
		context.close();	
		return result;	
		}
	}

