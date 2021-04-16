package com.vahap.bankManagement.bankManagement;
import java.util.List;
import com.sun.istack.internal.logging.Logger;
import com.vahap.bankManagement.dao.AccountDao;
import com.vahap.bankManagement.dao.BankDao;
import com.vahap.bankManagement.dao.CustomerDao;
import com.vahap.bankManagement.model.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	final Logger logger = Logger.getLogger(CustomerDao.class);

		CustomerDao empDao = new CustomerDao();
        //test insert data into customer
		Customer emp = new Customer();
		emp.setName("Babu");
		emp.setEmail("Security");
		emp.setName("saasdd");
		emp.setLastName("sasd");
		empDao.insertEmployee(emp);
		System.out.println("ekleme yapıldı---------------------------");
        //test list customer
		List<Customer> empList = empDao.getAllEmployeeList();
		 empList.forEach(customer->System.out.println("lastname:"+customer.getLastName()+
				" "+ "email:"+customer.getEmail()+" "+"card no:"+customer.getCardNo()
				+" "+"name:"+customer.getName()));
		System.out.println("listeleme yapıldı---------------------------");
        //test list customer by Id
		Customer empObj = empDao.getCustomerById(emp.getId());
		System.out.println("customer data:"+ empObj.getCardNo()+empObj.getEmail()+empObj.getId()
		+empObj.getLastName()+empObj.getName()+empObj.getPassword()+empObj.getPhone());
        //test delete customer by Id
		System.out.println("id'e göre arama---------------------------");
	//	empDao.deleteCustomer(empObj);

		System.out.println("silme işlemi---------------------------");

		empList = empDao.getAllEmployeeList();
		System.out.println("emp size: "+empList.size());
		//empList.stream().forEach(System.out::println);
		for(Customer cos : empList) {
			logger.info(cos.toString());
		}
		System.out.println("tüm kayıtlar---------------------------");
		BankDao banka =new BankDao();

		Bank bank=   banka.bankaSubesiAra(1);
	       System.out.println("name:"+bank.getName()+"adres:"+bank.getAdres());
	       List<Bank> bankaListesi=banka.bankaSubeListeleri();
	       bankaListesi.forEach(bnk->System.out.println("lastname:"+bnk.getName()+
	    		    " adres:"+bnk.getAdres()));
	       //----------------
	       AccountDao hesap=new AccountDao();
	       hesap.paraYatir(1, 1100);
	       hesap.paraCek(1, 100);	    
    }
}
