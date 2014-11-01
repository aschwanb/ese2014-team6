package org.sample.controller.service;

import org.sample.model.pojos.AdForm;
import org.sample.model.Address;
import org.sample.model.Advert;
import org.sample.model.dao.AddressDao;
import org.sample.model.dao.AdvertDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class AdServiceImpl implements AdService {
	
	@Autowired    AdvertDao advertDao;
    @Autowired    AddressDao addDao;
    
    // Image location = imgPath + imageName
    @Value("${path.adimg}")
	private String imgPath;
    
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
	
	@Transactional
    public AdForm saveFrom(AdForm adForm)
	{
    	
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
        
		MultipartFile image = adForm.getImage();
		String imgPath = image.getOriginalFilename();
		ad.setImgPath(imgPath);
		
        if(adForm.getId() != 0)
        {
        	ad.setId(adForm.getId());
        }
        
        ad = advertDao.save(ad);   // save object to DB
        
        adForm.setId(ad.getId());

        return adForm;

    }
	
}
