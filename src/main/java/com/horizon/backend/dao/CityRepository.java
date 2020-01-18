package com.horizon.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.horizon.backend.server.entities.City;
import com.horizon.backend.server.entities.Client;
@RepositoryRestResource
public interface CityRepository extends JpaRepository<City, Long> {
	public City findByName(String name);
}
