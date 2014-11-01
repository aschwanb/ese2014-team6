package ch.studihome.jspserver.controller.service;

import ch.studihome.jspserver.model.pojos.AdForm;

public interface AdService {
	
	public AdForm loadById(String adId);
	public AdForm saveFrom(AdForm adForm);

}
