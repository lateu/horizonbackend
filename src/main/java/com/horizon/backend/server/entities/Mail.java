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

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data 
//@AllArgsConstructor
@NoArgsConstructor
public class Mail{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long Id;
	private String ref;
	@Column(nullable=false)
	private String description;
	@ManyToOne
	@JsonProperty(access = Access.WRITE_ONLY)
	private Client sender;
	@ManyToOne	
	@JsonProperty(access = Access.WRITE_ONLY)
	private Client receiver;
	
	@ManyToOne
	private City sourceCity;
	@ManyToOne
	private City destinationCity;
	
	private String photo;
	private String status;
	
	@OneToMany(mappedBy="mail")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Collection<Payment> payments;
	
	@Temporal(TemporalType.DATE)
	private Date d;

	public Mail(String ref, String description, Client sender, Client receiver, City sourceCity, City destinationCity,
			String photo,String status, Date d) {
		super();
		this.ref = ref;
		this.description = description;
		this.sender = sender;
		this.receiver = receiver;
		this.sourceCity = sourceCity;
		this.destinationCity = destinationCity;
		this.photo = photo;
		this.d = d;
		this.status=status;
	}


}
