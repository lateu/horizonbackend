package com.horizon.backend.web;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.horizon.backend.dao.MailRepository;
import com.horizon.backend.server.entities.Mail;

public class MailResController {
	
	@Autowired
	private MailRepository mailRepository;
	@GetMapping(path="/mailsPhoto/{id}",produces=MediaType.IMAGE_JPEG_VALUE)
	public byte[] getPhoto(@PathVariable (name="id") Long id) throws IOException{
		Mail mail=mailRepository.findById(id).get();
		//String photoName=mail.getPhoto();
		File file=new File(System.getProperty("user.home"));
		Path path=Paths.get(file.toURI());
		
		return Files.readAllBytes(path);
		
	}

}
