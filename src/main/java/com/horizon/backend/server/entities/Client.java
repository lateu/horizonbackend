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
/*@Data
@AllArgsConstructor
@NoArgsConstructor*/
public class Client implements Serializable{
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Long id;
private String name;
private String contact;

@OneToMany(mappedBy="sender")
private Collection<Mail> MailsSenders;

@OneToMany(mappedBy="receiver")
private Collection<Mail> MailsReceivers;

@OneToMany(mappedBy="client")
private Collection<Payment> Payments;

public Client(String name, String contact, Collection<Mail> mailsSenders, Collection<Mail> mailsReceivers) {
	super();
	this.name = name;
	this.contact = contact;
	MailsSenders = mailsSenders;
	MailsReceivers = mailsReceivers;
}

public Client() {
	super();
	// TODO Auto-generated constructor stub
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getContact() {
	return contact;
}

public void setContact(String contact) {
	this.contact = contact;
}

public Collection<Mail> getMailsSenders() {
	return MailsSenders;
}

public void setMailsSenders(Collection<Mail> mailsSenders) {
	MailsSenders = mailsSenders;
}

public Collection<Mail> getMailsReceivers() {
	return MailsReceivers;
}

public void setMailsReceivers(Collection<Mail> mailsReceivers) {
	MailsReceivers = mailsReceivers;
}






}
