package com.horizon.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.horizon.backend.server.entities.City;
import com.horizon.backend.server.entities.Client;
import com.horizon.backend.server.entities.Mail;
@RepositoryRestResource
public interface ClientRepository extends JpaRepository<Client, Long> {
	public Client findByName(String name);
}
