package com.horizon.backend.server.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class City{

@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Long Id;
private String name;
private String agency_contact;
@OneToMany(mappedBy="sourceCity")
@JsonProperty(access = Access.WRITE_ONLY)
private Collection<Mail> mailssourceCity;

@OneToMany(mappedBy="destinationCity")
@JsonProperty(access = Access.WRITE_ONLY)
private Collection<Mail> mailsdestCity;






}
