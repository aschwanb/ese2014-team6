package org.sample.controller.service;

import org.sample.controller.pojos.AdForm;
import org.sample.model.Advert;
import org.sample.model.dao.AddressDao;
import org.sample.model.dao.AdvertDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdLoadServiceImpl implements AdLoadService {
	
	@Autowired    AdvertDao advertDao;
    @Autowired    AddressDao addDao;
    
    
	public AdForm loadById(String adId)
	{
		AdForm adForm = new AdForm();
		
		Advert ad = advertDao.findOne(Long.parseLong(adId));
		
		if(ad == null)
		{
			return null;
		}
		
		adForm.setId(ad.getId());
		adForm.setTitle(ad.getTitle());
		adForm.setPrice(ad.getPrice());
		adForm.setStreet(ad.getAddress().getStreet());
		adForm.setPlz(ad.getAddress().getPlz());
		adForm.setCity(ad.getAddress().getCity());
		adForm.setDescription(ad.getDescription());
		adForm.setOwnerEmail(ad.getIdUser());
		
		return adForm;
	}
	
}
