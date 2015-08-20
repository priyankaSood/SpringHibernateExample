package main.java.com.journaldev.dao;

import java.sql.Connection;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import main.java.com.journaldev.model.Person;
import main.java.com.journaldev.util.DBUtil;


public class PersonDAOImpl implements PersonDAO {

	//private SessionFactory sessionFactory;
	
	private  SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	/*private DBUtil dbUtil;
	
	public void setDbUtil(DBUtil dbUtil) {
		this.dbUtil = dbUtil;
	}
*/
	@Override
	public void save(Person p) {
		
		/*Connection conn = null;
		try {
			conn = dbUtil.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		//Session session = this.sessionFactory.openSession(conn);
		//sessionFactory = new Configuration().configure().buildSessionFactory();
		//Session session = sessionFactory.openSession(conn);
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(p);
		tx.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Person> list() {
		/*Connection conn = null;
		try {
			conn = dbUtil.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		//Session session = this.sessionFactory.openSession(conn);
		/*sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession(conn);*/
		Session session = this.sessionFactory.openSession();
		List<Person> personList = session.createQuery("from Person").list();
		session.close();
		return personList;
	}

}
