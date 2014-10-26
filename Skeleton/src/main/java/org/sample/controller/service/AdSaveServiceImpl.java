package org.sample.controller.service;

import org.sample.controller.pojos.AdForm;
import org.sample.model.Address;
import org.sample.model.Advert;
import org.sample.model.dao.AddressDao;
import org.sample.model.dao.AdvertDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class AdSaveServiceImpl implements AdSaveService {

    @Autowired    AdvertDao advertDao;
    @Autowired    AddressDao addDao;
    
    @Transactional
    public AdForm saveFrom(AdForm adForm){

        Address address = new Address();
        address.setStreet(adForm.getStreet());
        address.setPlz(adForm.getPlz());
        address.setCity(adForm.getCity());
        
        Advert ad = new Advert();
        
        ad.setAddress(address);
        ad.setTitle(adForm.getTitle());
        ad.setPrice(adForm.getPrice());
        ad.setDescription(adForm.getDescription());
        ad.setIdUser(adForm.getOwnerEmail());
        
        if(adForm.getId() != 0)
        {
        	ad.setId(adForm.getId());
        }
        
        ad = advertDao.save(ad);   // save object to DB
        
        adForm.setId(ad.getId());

        return adForm;

    }
}
