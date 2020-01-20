package com.horizon.backend.server.entities;

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
private Collection<Mail> mailssourceCity;

@OneToMany(mappedBy="destinationCity")
private Collection<Mail> mailsdestCity;






}
