package main.java.com.journaldev.dao;



import java.util.List;

import main.java.com.journaldev.model.Person;





public interface PersonDAO {

	public void save(Person p);
	
	public List<Person> list();
	
}
