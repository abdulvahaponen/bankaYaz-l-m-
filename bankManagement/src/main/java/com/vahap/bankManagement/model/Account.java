package com.vahap.bankManagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hesap")
public class Account {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private int id;
	@Column(name="hesapNo")
private int hesapNo;
	@Column(name="bakiye")
private float bakiye;
public float getBakiye() {
		return bakiye;
	}
	public void setBakiye(float bakiye) {
		this.bakiye = bakiye;
	}
@Column(name="Iban")
	private int Iban;
public Account(int hesapNo, float bakiye, int iban) {
	super();
	this.hesapNo = hesapNo;
	this.bakiye = bakiye;
	Iban = iban;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getHesapNo() {
	return hesapNo;
}
public void setHesapNo(int hesapNo) {
	this.hesapNo = hesapNo;
}
public int getIban() {
	return Iban;
}
public void setIban(int iban) {
	Iban = iban;
}

}
