package com.horizon.backend.web;

import java.net.URI;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.horizon.backend.dao.CityRepository;
import com.horizon.backend.server.entities.City;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@Transactional
public class CityResController {
	
	@Autowired
	CityRepository cityrep;
	
	@GetMapping(path="/city/{id}")
	public City getCity(@PathVariable(name="id") Long id) {
		City city=cityrep.findById(id).get();
		
		
		return city;
		
	}
	
	@PutMapping(path="/city/update/{id}")
	ResponseEntity<City> updateCity(@PathVariable(name="id")   Long id,@RequestBody City city) {

		City res=cityrep.saveAndFlush(city);
		//System.out.println("------saveAndFlush-----+++++++");
		//System.out.println(res.getId());
		return  new ResponseEntity<City>(city,HttpStatus.OK);
	
		
	
	}
	
	@PostMapping(path="/city/create")
	ResponseEntity<Void> createCity(@RequestBody City city) {

			City res=cityrep.save(city);
			URI uri=ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}")
					.buildAndExpand(res.getId())
					.toUri();
		    return  ResponseEntity.created(uri).build();
		
	
	}
	
	

}
