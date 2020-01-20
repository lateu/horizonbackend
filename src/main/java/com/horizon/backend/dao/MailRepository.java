package com.horizon.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.horizon.backend.server.entities.City;
import com.horizon.backend.server.entities.Mail;
@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface MailRepository extends JpaRepository<Mail, Long> {
	
	public Mail findByRef(String ref);
	public Mail findByDescription(String desc);

}
