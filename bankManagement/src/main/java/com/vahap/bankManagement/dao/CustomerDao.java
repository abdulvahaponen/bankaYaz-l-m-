package com.vahap.bankManagement.dao;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.sun.istack.internal.logging.Logger;
import com.vahap.bankManagement.model.Customer;
import com.vahap.bankManagement.util.HibernateUtil;
public class CustomerDao {
	public final static Logger logger = Logger.getLogger(CustomerDao.class);
	@SuppressWarnings("unchecked")
	public List<Customer> getAllEmployeeList() throws Exception{
        Transaction transaction=null;
		Session session = null;
		List<Customer> empList = null;
		try {
			  session=HibernateUtil.getSessionFactory().openSession();
				//start the transaction
			  transaction=session.beginTransaction();
			String queryStr = "select emp from Customer emp";
			Query<Customer> query = session.createQuery(queryStr);
			//Query<Customer> query = session.load(queryStr);

			empList = query.list();
		} catch(Exception ex) {
			ex.printStackTrace();
			// handle exception here
			throw new Exception(
					"Failed to retrieve message from the database.",ex);
		} finally {
			try {if(session != null) session.close();} catch(Exception ex) {}
		}
		return empList;
	}

	public Customer getCustomerById(int id){
		Transaction transaction=null;;
	     Session session=null;
	     Customer customer=null;
	     try {
			session=HibernateUtil.getSessionFactory().openSession();
			//start the transaction
		transaction=session.beginTransaction();
			String querystr="select std from Customer std";
			//get customer object
			customer=session.get(Customer.class, id);
			//customer=session.load(Customer.class, id);
			logger.info("\n.......listeleme yapıldı.......\n");

	     }
			catch(Exception ex) {
				if(null != session.getTransaction()) {
					session.getTransaction().rollback();
				}
	            ex.printStackTrace();
	            // handle exception here
	        } finally {
	            try {if(session != null) session.close();} catch(Exception ex) {}
	        }
	        return customer;
	}

	public void insertEmployee(Customer customer) {
		Transaction transaction=null;
		Session session=null;
		try{
			  session=HibernateUtil.getSessionFactory().openSession();
				//start the transaction
			  transaction=	session.beginTransaction();
			  //Save the customer object
			session.save(customer);
			//commit transaction
			transaction.commit();
			logger.info("\başarılı bir şekilde eklendi '" + customer + "' veritabanına\n");

		} catch (Exception e) {
			if (transaction!=null) {
				logger.info("\n.......Transaction geri dönderiliyor.......\n");
				transaction.rollback();
			}
		} finally {
			try {if(session != null) session.close();} catch(Exception ex) {}
		}
	}



	public void deleteCustomer(Customer customer) {

		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			//start the transaction
			transaction = session.beginTransaction();
			//delete customer object
			session.delete(customer);
			//commit the transaction
			transaction.commit();
			System.out.println("deleted employee: "+customer.getName());
		} catch(Exception ex) {
			ex.printStackTrace();
			// handle exception here
			if(transaction != null) transaction.rollback();
		} finally {
			try {if(session != null) session.close();} catch(Exception ex) {}
		}
	}
}