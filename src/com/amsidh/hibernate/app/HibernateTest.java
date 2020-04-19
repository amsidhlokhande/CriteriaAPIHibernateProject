package com.amsidh.hibernate.app;




import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;

import com.amsidh.hibernate.domains.UserDetails;

public class HibernateTest {

	
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Criteria criteria=session.createCriteria(UserDetails.class);
		criteria.add(Restrictions.eq("userId", 4));
       
		List<UserDetails> users= (List<UserDetails>)criteria.list();
		for (UserDetails userDetails : users) {
			System.out.println(userDetails.getUserName());
		}
		
		
		Query nativeSqlNamedquery = session.getNamedQuery("userDetails.by@NamedNativeQuery.byUserName");
		nativeSqlNamedquery.setString("user_name", "USERNAME 8");
		users= (List<UserDetails>)nativeSqlNamedquery.list();
	    for (UserDetails userDetails : users) {
			System.out.println(userDetails.getUserName());
		}
		
		
		session.getTransaction().commit();
		session.close();
		
		
	}

}
