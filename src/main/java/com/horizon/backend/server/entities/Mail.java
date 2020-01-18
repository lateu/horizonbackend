package com.horizon.backend.server.entities;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
/*@Data 
@AllArgsConstructor
@NoArgsConstructor*/
public class Mail{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long Id;
	private String ref;
	@Column(nullable=false)
	private String description;
	@ManyToOne
	private Client sender;
	@ManyToOne	
	private Client receiver;
	
	@ManyToOne
	private City sourceCity;
	@ManyToOne
	private City destinationCity;
	
	private String photo;
	
	/**@OneToMany(mappedBy="mail")
	private Collection<Payment> payments;*/
	@Temporal(TemporalType.DATE)
	private Date d;

	public Mail(String ref, String description, Client sender, Client receiver, City sourceCity,
			City destinationCity, String photo, Date d) {
		super();
		this.ref = ref;
		this.description = description;
		this.sender = sender;
		this.receiver = receiver;
		this.sourceCity = sourceCity;
		this.destinationCity = destinationCity;
		this.photo = photo;
		this.d = d;
	}

	public Mail() {
		super();
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Client getSender() {
		return sender;
	}

	public void setSender(Client sender) {
		this.sender = sender;
	}

	public Client getReceiver() {
		return receiver;
	}

	public void setReceiver(Client receiver) {
		this.receiver = receiver;
	}

	public City getSourceCity() {
		return sourceCity;
	}

	public void setSourceCity(City sourceCity) {
		this.sourceCity = sourceCity;
	}

	public City getDestinationCity() {
		return destinationCity;
	}

	public void setDestinationCity(City destinationCity) {
		this.destinationCity = destinationCity;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Date getD() {
		return d;
	}

	public void setD(Date d) {
		this.d = d;
	}
	
	
	

}
