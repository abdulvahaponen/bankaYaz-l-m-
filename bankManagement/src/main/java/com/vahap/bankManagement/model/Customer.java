package com.vahap.bankManagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private int id;
	@Column(name="Name")
private String name;
	@Column(name="lastName")
private String lastName;
	@Column(name="password")
private int password;	
	@Column(name="phone")
private int phone;
	@Column(name="email")
private String email;
	@Column(name="cardNo")
	private String cardNo;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getPassword() {
	return password;
}
public void setPassword(int password) {
	this.password = password;
}
public int getPhone() {
	return phone;
}
public void setPhone(int phone) {
	this.phone = phone;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getCardNo() {
	return cardNo;
}
public void setCardNo(String cardNo) {
	this.cardNo = cardNo;
}
public Customer() {
	super();
}
public Customer(String name, String lastName) {
	super();
	this.name = name;
	this.lastName = lastName;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}

}
