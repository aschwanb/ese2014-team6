package org.sample.controller.service;

import org.sample.model.pojos.AdForm;

public interface AdService {
	
	public AdForm loadById(String adId);
	public AdForm saveFrom(AdForm adForm);

}
