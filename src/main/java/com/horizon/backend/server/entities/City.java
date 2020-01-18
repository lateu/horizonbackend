package com.horizon.backend.server.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
public class City implements Serializable{
/**
	 * 
	 */
private static final long serialVersionUID = 1L;
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Long Id;
private String name;
private String agency_contact;
@OneToMany(mappedBy="sourceCity")
private Collection<Mail> mailssourceCity;

@OneToMany(mappedBy="destinationCity")
private Collection<Mail> mailsdestCity;

public City(String name, String agency_contact) {
	super();
	this.name = name;
	this.agency_contact = agency_contact;
}

public City() {
	super();
	// TODO Auto-generated constructor stub
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getAgency_contact() {
	return agency_contact;
}

public void setAgency_contact(String agency_contact) {
	this.agency_contact = agency_contact;
}

public Collection<Mail> getMailssourceCity() {
	return mailssourceCity;
}

public void setMailssourceCity(Collection<Mail> mailssourceCity) {
	this.mailssourceCity = mailssourceCity;
}

public Collection<Mail> getMailsdestCity() {
	return mailsdestCity;
}

public void setMailsdestCity(Collection<Mail> mailsdestCity) {
	this.mailsdestCity = mailsdestCity;
}

public static long getSerialversionuid() {
	return serialVersionUID;
}

@Override
public String toString() {
	return "City [Id=" + Id + ", name=" + name + ", agency_contact=" + agency_contact + ", mailssourceCity="
			+ mailssourceCity + ", mailsdestCity=" + mailsdestCity + "]";
}







}
