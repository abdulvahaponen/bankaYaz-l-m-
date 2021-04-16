package com.vahap.bankManagement.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sun.istack.internal.logging.Logger;
import com.vahap.bankManagement.model.Account;
import com.vahap.bankManagement.model.Customer;
import com.vahap.bankManagement.util.HibernateUtil;

public class AccountDao {
	public final static Logger logger = Logger.getLogger(CustomerDao.class);
public void paraCek(int id,int miktar) {
	Transaction transaction=null;
	Session session = null;
	int yeniBakiye=0;
	Account hesap=null;
	try {
		// Getting Session Object From SessionFactory
		  session=HibernateUtil.getSessionFactory().openSession();
		// Getting Transaction Object From Session Object
		  transaction=session.beginTransaction();
		// Creating Transaction Entity
		  	 hesap = session.get(Account.class, id);
		 yeniBakiye=(int) (hesap.getBakiye()-miktar);
		hesap.setBakiye(yeniBakiye);
      if (yeniBakiye<0) {
		logger.info("yetersiz bakiye");
	}
      else {
    	// Committing The Transactions To The Database
          session.update(hesap);
	}
      transaction.commit();
		logger.info("\nStudent With Id?= " + id + " Is Successfully Updated In The Database!\n");
	} catch(Exception sqlException) {
		if(null != session.getTransaction()) {
			logger.info("\n.......Transaction Is Being Rolled Back.......\n");
			session.getTransaction().rollback();
		}
		sqlException.printStackTrace();
	} finally {
		if(session != null) {
			session.close();
		}
	}

}

public void paraYatir(int id,int miktar) {
	Transaction transaction=null;
	Session session = null;
	int yeniBakiye=0;
	try {
		// Getting Session Object From SessionFactory
		  session=HibernateUtil.getSessionFactory().openSession();
		  
		// Getting Transaction Object From Session Object
		  transaction=session.beginTransaction();
		// Creating Transaction Entity
		  Account hesap = (Account)session.get(Account.class, id);
		  yeniBakiye=(int) (hesap.getBakiye()+miktar);
		hesap.setBakiye(yeniBakiye);
      session.update(hesap);
		// Committing The Transactions To The Database
          transaction.commit();
		logger.info("\nStudent With Id?= " + id + " Is Successfully Updated In The Database!\n");
	} catch(Exception sqlException) {
		if(null != session.getTransaction()) {
			logger.info("\n.......Transaction Is Being Rolled Back.......\n");
			session.getTransaction().rollback();
		}
		sqlException.printStackTrace();
	} finally {
		if(session != null) {
			session.close();
		}
	}

}
public void paraYatir(int miktar) {
	
}
}
