package ch.studihome.jspserver.controller.service;

import java.util.HashSet;
import java.util.Set;
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
import ch.studihome.jspserver.model.RoomImg;
import ch.studihome.jspserver.model.User;
import ch.studihome.jspserver.model.dao.AddressDao;
import ch.studihome.jspserver.model.dao.AdvertDao;
import ch.studihome.jspserver.model.dao.UserDao;
import ch.studihome.jspserver.model.pojos.AdForm;

@Service
public class AdServiceImpl implements AdService {
	
	@Autowired    AdvertDao advertDao;
    @Autowired    AddressDao addrDao;
    @Autowired    UserDao usrDao;
    
    // Image location = imgPath + imageName
    @Value("${path.adimg}")
	private String imgPath;
    
    @Transactional
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
		adForm.setPrice(Integer.toString(ad.getPrice()));
		adForm.setStreet(ad.getAddress().getStreet());
		adForm.setPlz(ad.getAddress().getPlz());
		adForm.setCity(ad.getAddress().getCity());
		adForm.setDescription(ad.getDescription());
		adForm.setOwnerId(ad.getUser().getId().toString());
		
		return adForm;
	}
	
    @Transactional(readOnly = false)
    public AdForm saveFrom(AdForm adForm) throws ImageSaveException
	{
    	User user = usrDao.findOne(Long.decode(adForm.getOwnerId()));
    	Advert[] adverts = new Advert[0];
    	adverts = user.getAds().toArray(adverts);
        Set<Advert> newset = new HashSet<Advert>(0);
    	
        Address address = new Address();
        address.setStreet(adForm.getStreet());
        address.setPlz(adForm.getPlz());
        address.setCity(adForm.getCity());
        
        Advert ad = new Advert();
        
        ad.setAddress(address);
        address.setAdvert(ad);
        if(adForm.getId() != 0)
        {
        	ad.setId(adForm.getId());
        }
        ad.setTitle(adForm.getTitle());
        ad.setPrice(Integer.parseInt(adForm.getPrice()));
        ad.setDescription(adForm.getDescription());
        ad.setUser(user);

		//Save image to directory
		try {
			MultipartFile image = adForm.getImage();
//			String name = Objects.toString(ad.getId());
			String name = image.getOriginalFilename();
			String imagePath = imgPath + name;
			byte[] bytes = image.getBytes();
			BufferedOutputStream stream = 
					new BufferedOutputStream(
							new FileOutputStream(new File(imagePath)));
			stream.write(bytes);
			stream.close();
			
			// Save image name to db
			RoomImg img = new RoomImg();
			img.setAdvert(ad);
			img.setImgDescription("Temp description");
			img.setImgName(name);
			img.setImgNum(1);
			Set<RoomImg> rset = new HashSet<RoomImg>(0);
			rset.add(img);
			ad.setImgs(rset);
		} catch (Exception e) {
			throw new ImageSaveException("Error while saving your image.\n" + e.toString());
		}
        
        for(Advert a: adverts)
        {
        	if(!a.getId().equals(ad.getId()))
        	{
        		newset.add(a);
        	}
        }
        newset.add(ad);
        user.setAds(newset);
        
		ad = advertDao.save(ad);	// save ad to DB (has to be done, to easily get the adId
        
        adForm.setId(ad.getId());
        
        user = usrDao.save(user);   // save user to DB

        return adForm;

    }
	
}
