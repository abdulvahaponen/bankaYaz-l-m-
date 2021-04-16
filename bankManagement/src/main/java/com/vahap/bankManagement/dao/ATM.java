package com.vahap.bankManagement.dao;

import com.sun.istack.internal.logging.Logger;

public class ATM {
	public final static Logger logger = Logger.getLogger(ATM.class);
private static int maximumSifreDeneme=3;
private static String sifre="1234"; 
 private int      sifreDeneme=0;
public void sifreyiDegistir(String sifreyiOku, String newSifre1,String newSifre2) {
	while (sifreDeneme<maximumSifreDeneme) {
		if(sifreyiOku.equals(sifre)) {
			if(newSifre1.equals(newSifre2)) {
				sifre=newSifre2;
				logger.info("şifreniz başarıyla  girildi");
				break;
			}
			else {
				logger.info("iki şifre aynı değil "
						+ "lütfe iki şifreniz de aynı olsun");
			}
			sifreDeneme=0;
		}
		else {
			logger.info("şifreniz hatalı lütfen  daha soonra tekrar deneyin "
					+ "yanlış şifre girişi");
			sifreDeneme++;
			logger.info( "şifre hatası");
		}
		
	}
}
}
