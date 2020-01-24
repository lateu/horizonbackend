package com.horizon.backend.web;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.horizon.backend.dao.MailRepository;
import com.horizon.backend.server.entities.Mail;

import net.minidev.json.JSONObject;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MailResController {
	
	@Autowired
	private MailRepository mailRepository;
	@GetMapping(path="/mailsPhoto/{id}",produces=MediaType.IMAGE_JPEG_VALUE)
	public byte[] getPhoto(@PathVariable (name="id") Long id) throws IOException{
		Mail mail=mailRepository.findById(id).get();
		String photoName=mail.getPhoto();
		File file=new File(System.getProperty("user.home")+"/Pictures/"+photoName);
		Path path=Paths.get(file.toURI());
		//System.out.println("----------------");
		//System.out.println(System.getProperty("user.home"));
		
		return Files.readAllBytes(path);
		
	}
		
	@GetMapping(path="/maildetails/{id}")
	public JSONObject getMailDetails(@PathVariable(name="id") Long id) {
		Mail mail=mailRepository.findById(id).get();
		JSONObject res = new JSONObject();
		if (mail!=null) {		
		res.put("id", mail.getId());
		res.put("ref", mail.getRef());
		res.put("description", mail.getDescription());
		res.put("sender", mail.getSender().getName());
		res.put("receiver", mail.getReceiver().getName());
		res.put("sourceCity", mail.getSourceCity().getName());
		res.put("destinationCity", mail.getDestinationCity().getName());
		res.put("status", mail.getStatus());
		}		
		
		return res;
		
	}
	

	@DeleteMapping(path="/mail/delete/{id}")
	ResponseEntity<Void> deleteById(@PathVariable(name="id")   Long id) {
		Mail m=mailRepository.findById(id).get();
		if (m!=null){
		mailRepository.delete(m);
		return ResponseEntity.noContent().build();
		}else {
			return   ResponseEntity.notFound().build();
		}		
	
	}
	
	@GetMapping(path="/findMailByRef/{ref}")
	Mail findMailByRef(@PathVariable(name="ref")   String ref) {
		Mail m=mailRepository.findByRef(ref);
		//System.out.println("---------------");
		//System.out.println(m.getDescription());
		return m;
			
	
	}
	
	

}
