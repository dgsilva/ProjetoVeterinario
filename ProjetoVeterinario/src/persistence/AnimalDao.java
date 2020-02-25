package persistence;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


import entity.Animal;

public class AnimalDao {

	Session session;
	Transaction transaction;
	Query query;
	
	public void create(Animal a)throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.save(a);
		transaction.commit();
		session.flush();
		session.close();
	}
	
	public void update(Animal a)throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.merge(a);
		transaction.commit();
		session.flush();
		session.close();
	}
	

	public void delete(Animal a) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.delete(a);
		transaction.commit();
		session.flush();
		session.close();
	}

	
	public List<Animal>findAll(){
		session = HibernateUtil.getSessionFactory().openSession();
		List<Animal>animais = (List<Animal>) session.createQuery("select obj from Animal as obj").list();
		session.flush();
		session.close();
		return animais;
	}
}
