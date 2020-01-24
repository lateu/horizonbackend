package com.horizon.backend.server.entities;

import org.springframework.data.rest.core.config.Projection;
import org.springframework.web.bind.annotation.CrossOrigin;

/*@Projection(name="mailproj",types = {Mail.class})
@CrossOrigin(origins = "http://localhost:4200")*/
public interface MailProjection {
	public Long getId();
	public Client getSender();
	public Client getReceiver();
	public City getSourceCity();
	public City getDestinationCity();

}
