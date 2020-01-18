package com.horizon.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.horizon.backend.dao.ClientRepository;
import com.horizon.backend.service.BackendInitData;
import com.horizon.backend.service.BackendInitImpl;

@SpringBootApplication
public class HorizonbackendApplication implements CommandLineRunner{
	@Autowired
	private   BackendInitData backendInitData;


	public static void main(String[] args) {
		SpringApplication.run(HorizonbackendApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		backendInitData.InitCity();
		backendInitData.InitClient();
		backendInitData.InitMail();
		
	}

}
