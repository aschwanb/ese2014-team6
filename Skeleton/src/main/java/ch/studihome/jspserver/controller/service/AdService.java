package ch.studihome.jspserver.controller.service;

import ch.studihome.jspserver.controller.exceptions.ImageSaveException;
import ch.studihome.jspserver.model.Advert;
import ch.studihome.jspserver.model.pojos.AdForm;

public interface AdService {
	
	public Iterable<Advert> findAll();
	public AdForm loadById(String adId);
	public AdForm saveFrom(AdForm adForm) throws ImageSaveException;

}
