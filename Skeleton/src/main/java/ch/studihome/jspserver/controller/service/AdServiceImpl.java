package ch.studihome.jspserver.controller.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import ch.studihome.jspserver.controller.exceptions.ImageSaveException;
import ch.studihome.jspserver.model.Address;
import ch.studihome.jspserver.model.Advert;
import ch.studihome.jspserver.model.dao.AddressDao;
import ch.studihome.jspserver.model.dao.AdvertDao;
import ch.studihome.jspserver.model.pojos.AdForm;

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
    public AdForm saveFrom(AdForm adForm) throws ImageSaveException{
    	
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

        // Save image to directory
		try {
			MultipartFile image = adForm.getImage();
			String name = Objects.toString(ad.getId());
//			String name = image.getOriginalFilename();
			String imagePath = imgPath + name;
			byte[] bytes = image.getBytes();
			BufferedOutputStream stream = 
					new BufferedOutputStream(
							new FileOutputStream(new File(imagePath)));
			stream.write(bytes);
			stream.close();
			// Save image name to db
			ad.setImgName(name);
		} catch (Exception e) {
			throw new ImageSaveException("Error while saving your image.");
		}
        
        ad = advertDao.save(ad);   // save object to DB
        
        adForm.setId(ad.getId());

        return adForm;

    }
	
}
