package com.horizon.backend.service;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.horizon.backend.dao.CityRepository;
import com.horizon.backend.dao.ClientRepository;
import com.horizon.backend.dao.MailRepository;
import com.horizon.backend.server.entities.City;
import com.horizon.backend.server.entities.Client;
import com.horizon.backend.server.entities.Mail;

@Service
public class BackendInitImpl implements BackendInitData{
	
	@Autowired
	private CityRepository cityrepository;
	
	@Autowired
	private ClientRepository clientrepo;
	
	@Autowired
	private MailRepository mailrep;

	@Override
	public void InitClient() {
		Stream.of("TOTO","TATA","TITI","JOLI","ANGEL").forEach(
				name->{
					Random ran=new Random();
					Client client=new Client();
					client.setName(name);
					client.setContact(ran.nextInt(8)+"01");
					clientrepo.save(client);
					
				});
		
		
	}

	@Override
	public void InitCity() {
		// TODO Auto-generated method stub
		Stream.of("Maroua","Garoua","Yaounde","Bafoussam","Malabo").forEach(
				name->{
					City city=new City();
					city.setName(name);
					city.setAgency_contact("contact000");
					cityrepository.save(city);
					
				});
		
	}

	@Override
	public void initUsers() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void InitMail() {
		// TODO Auto-generated method stub
		List<City> cities=cityrepository.findAll();
		List<Client>clients=clientrepo.findAll();
		City ct1=cityrepository.findByName("Maroua");
		City ct2=cityrepository.findByName("Garoua");
		City ct3=cityrepository.findByName("Yaounde");
		
		Client cl1=clientrepo.findByName("TATA");
		Client cl2=clientrepo.findByName("TOTO");
		Client cl3=clientrepo.findByName("TITI");

		mailrep.save(new Mail("R0","CNI",cl2,cl1,ct1,ct2,null,new Date()));
		mailrep.save(new Mail("R1","BC",cl1,cl2,ct2,ct1,null,new Date()));
		mailrep.save(new Mail("R2","Licence",cl2,cl1,ct1,ct2,null,new Date()));
		
	}

}
