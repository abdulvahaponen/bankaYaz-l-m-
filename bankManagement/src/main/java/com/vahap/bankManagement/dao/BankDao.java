package com.vahap.bankManagement.dao;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.sun.istack.internal.logging.Logger;
import com.vahap.bankManagement.model.Bank;
import com.vahap.bankManagement.model.Customer;
import com.vahap.bankManagement.util.HibernateUtil;
public class BankDao {
	public final static Logger logger = Logger.getLogger(CustomerDao.class);
@SuppressWarnings("unchecked")
public List<Bank> bankaSubeListeleri(){
	Transaction transaction=null;
	Session session=null;
	List<Bank> bankaListeleri=null;
	try {
		session=HibernateUtil.getSessionFactory().openSession();
		//start the transaction
		transaction=session.beginTransaction();
		String bankaListesiQuery="select b from Bank b";
		Query<Bank> query=session.createQuery(bankaListesiQuery);
		bankaListeleri=query.list();
		
	}catch (Exception e) {
	e.printStackTrace();
	} 
	finally {
		try {if(session != null) session.close();} catch(Exception ex) {}
	}
	return bankaListeleri;
}
public Bank bankaSubesiAra(int bankaId) {
	Transaction transaction=null;;
    Session session=null;
    Bank bnk=null;
    try {
		session=HibernateUtil.getSessionFactory().openSession();
	transaction=session.beginTransaction();
		String querystr="select std from Bank std";
		bnk=session.get(Bank.class, bankaId);
		//bnk=session.load(Customer.class, id);
		logger.info("\n.......listeleme yapıldı.......\n");

    }
		catch(Exception ex) {
			if(null != session.getTransaction()) {
				session.getTransaction().rollback();
				logger.info("/n...........transaction rollback......./n");
			}
           ex.printStackTrace();
           // handle exception here
       } finally {
           try {if(session != null) session.close();} catch(Exception ex) {}
       }
       return bnk;
}
}
