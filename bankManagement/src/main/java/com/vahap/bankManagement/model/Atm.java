package com.vahap.bankManagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="atm")
public class Atm {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private int id;
	@Column(name="ATMName")
private String atmName;
	@Column(name="ATMLocation")
private String atmLocation;

public Atm() {
	super();
}

public Atm(int id, String name, String location) {
	super();
	this.id = id;
	this.atmName = name;
	this.atmLocation = location;
}

public String getName() {
	return atmName;
}

public void setName(String name) {
	this.atmName = name;
}

public String getLocation() {
	return atmLocation;
}

public void setLocation(String location) {
	this.atmLocation = location;
}

}
