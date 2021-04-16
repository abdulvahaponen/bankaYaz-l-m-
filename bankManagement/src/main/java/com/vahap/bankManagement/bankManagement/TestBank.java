package com.vahap.bankManagement.bankManagement;

import java.util.List;

import com.vahap.bankManagement.dao.BankDao;
import com.vahap.bankManagement.model.Bank;

public class TestBank {
	public static void main(String[] args) {
BankDao banka =new BankDao();
       List<Bank> bankaListesi=banka.bankaSubeListeleri();
       bankaListesi.forEach(bnk->System.out.println("lastname:"+bnk.getName()));
}
}