package ch.studihome.jspserver.controller.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import ch.studihome.jspserver.controller.AdvertController;
import ch.studihome.jspserver.controller.exceptions.ImageSaveException;
import ch.studihome.jspserver.model.Address;
import ch.studihome.jspserver.model.Advert;
import ch.studihome.jspserver.model.RoomImg;
import ch.studihome.jspserver.model.User;
import ch.studihome.jspserver.model.dao.AddressDao;
import ch.studihome.jspserver.model.dao.AdvertDao;
import ch.studihome.jspserver.model.dao.RoomImgDao;
import ch.studihome.jspserver.model.dao.UserDao;
import ch.studihome.jspserver.model.pojos.AdForm;

/**
 * Implements AdService using the Hibernate Daos
 * 
 * @author TeamSiX
 */
@Service
public class AdServiceImpl implements AdService {
	
	@Autowired    AdvertDao advertDao;
    @Autowired    UserDao usrDao;
    @Autowired    RoomImgDao rimgDao;
    
	static Logger log = Logger.getLogger(AdvertController.class.getName());
    
    // Image location = imgPath + imageName
    @Value("${path.adimg}")	private String imgPath;  
    @Value("${path.usrpath}") private String usrPath;
    
    public AdServiceImpl(){}
    
    public AdServiceImpl(AdvertDao advertDao, UserDao usrDao, RoomImgDao rimgDao)
    {
    	this.advertDao = advertDao;
    	this.usrDao = usrDao;
    	this.rimgDao = rimgDao;
    }

    public Iterable<Advert> findAll() {
    	log.info("INFO: There are " + advertDao.count() + 
    			" adverts registered. Returning them all");
    	return advertDao.findAll();
    }
    
    @Transactional
	public AdForm loadById(String adId)
	{
		AdForm adForm = new AdForm();
		
		Advert ad = advertDao.findOne(Long.parseLong(adId));
		
		if(ad == null)
		{
			return null;
		}
		
		adForm.setId(ad.getAdv_id());
		adForm.setTitle(ad.getTitle());
		adForm.setPrice(ad.getPrice());
		adForm.setStreet(ad.getAddress().getStreet());
		adForm.setPlz(ad.getAddress().getPlz());
		adForm.setCity(ad.getAddress().getCity());
		adForm.setLatlng(ad.getAddress().getCoordinate());
		adForm.setIsWG(ad.getIsWG());
		adForm.setAppartementSize(ad.getAppartementSize());
		adForm.setNumberOfRooms(ad.getNumberOfRooms());
		adForm.setRoomSize(ad.getRoomSize());
		adForm.setNumberOfInhabitants(ad.getNumberOfInhabitants());
		adForm.setDescription(ad.getDescription());
		adForm.setOwnerId(ad.getUser().getUsr_id());
		
		RoomImg[] imgs = new RoomImg[0];
		imgs = ad.getImgs().toArray(imgs);
		List<String> imgDescription = new ArrayList<String>();
	    List<String> imgNumber = new ArrayList<String>();
	    List<String> imgUrl = new ArrayList<String>();
		
		for(int i = 0; i < imgs.length; i++)
		{
			imgDescription.add(imgs[i].getImgDescription());
			imgNumber.add(Integer.toString(imgs[i].getImgNum()));
			imgUrl.add(imgPath + imgs[i].getImgName());
		}
		adForm.setImgDescription(imgDescription);
		adForm.setImgNumber(imgNumber);
		adForm.setImgUrl(imgUrl);
		
		return adForm;
	}
	
    @Transactional(readOnly = false)
    public AdForm saveFrom(AdForm adForm) throws ImageSaveException
	{
    	User user = usrDao.findOne(adForm.getOwnerId());
    	
        Address address = new Address();
        address.setStreet(adForm.getStreet());
        address.setPlz(adForm.getPlz());
        address.setCity(adForm.getCity());
        address.setCoordinate(adForm.getLatlng());
        
        Advert ad = new Advert();
        
        ad.setAddress(address);
        address.setAdvert(ad);
        if(adForm.getId() != 0)
        {
        	ad.setAdv_id(adForm.getId());
        }
        ad.setTitle(adForm.getTitle());
        ad.setPrice(adForm.getPrice());
        ad.setIsWG(adForm.getIsWG());
        ad.setAppartementSize(adForm.getAppartementSize());
        ad.setNumberOfRooms(adForm.getNumberOfRooms());
        ad.setRoomSize(adForm.getRoomSize());
        ad.setNumberOfInhabitants(adForm.getNumberOfInhabitants());
        ad.setDescription(adForm.getDescription());
        ad.setUser(user);
        
		ad = advertDao.save(ad);	// save ad to DB (has to be done, to easily get the adId
        
        adForm.setId(ad.getAdv_id());
        
        // Todo: Check if upload is an image. (eg "image" = image.getContentType().split("/")[0])
        int limit = adForm.getImgFile().size();
        
        for(int i = 0; i < limit; i++)
        {
        	if(adForm.getImgState().get(i).equals("change"))
        	{
        		RoomImg img = (rimgDao.findByAdvertAndImgNum(ad, Integer.parseInt(adForm.getImgNumber().get(i)))).get(0);
        		
        		deleteFileFromServer(imgPath + img.getImgName());
        		
				String name = saveFileOnServer(ad, adForm.getImgFile().get(i), Integer.parseInt(adForm.getImgNumber().get(i)));
				
				img.setImgDescription(adForm.getImgDescription().get(i));
				img.setImgName(name);
				
				rimgDao.save(img);
        		
        	}else if(adForm.getImgState().get(i).equals("new"))
        	{
        		int imgNr = 0;
        		do
        		{
        			imgNr = (int)(Math.random()*100);
        		}while((rimgDao.findByAdvertAndImgNum(ad, imgNr)).size() != 0);
        		
        		String name = saveFileOnServer(ad, adForm.getImgFile().get(i), imgNr);
				
        		RoomImg img = new RoomImg();
				img.setAdvert(ad);
				img.setImgDescription(adForm.getImgDescription().get(i));
				img.setImgName(name);
				img.setImgNum(imgNr);
				
				rimgDao.save(img);
        	}else if(adForm.getImgState().get(i).equals("delete"))
        	{
        		RoomImg img = (rimgDao.findByAdvertAndImgNum(ad, Integer.parseInt(adForm.getImgNumber().get(i)))).get(0);
        		
        		deleteFileFromServer(imgPath + img.getImgName());
        		
        		rimgDao.delete(img);
        	}
        }

        return adForm;

    }
    
    /**
     *  Saves an image in file structure on server
     *  
     * @param ad The advert owning the image
     * @param image The image data
     * @param imgNr	The advert intern id of the image
     * @return The Filename of the saved image
     * @throws ImageSaveException thrown if problems appear while saving
     */
	private String saveFileOnServer(Advert ad, MultipartFile image, Integer imgNr)throws ImageSaveException
	{
		try
		{
			log.info("INFO: File Content Type is " + image.getContentType());
			
			String name = ad.getAdv_id().toString() + 
					"_" + Integer.toString(imgNr) + 
					"." + image.getContentType().split("/")[1];
			String imagePath = usrPath + imgPath + name;
			byte[] bytes = image.getBytes();
			BufferedOutputStream stream = 
					new BufferedOutputStream(
							new FileOutputStream(new File(imagePath)));
			stream.write(bytes);
			stream.close();
			return name;
		}catch (Exception e)
		{
			throw new ImageSaveException("Error while saving your image.\n" + e.toString());
		}
	}
	
	/**
	 * Deletes file from file structure on server
	 * 
	 * @param filename name of the file to delete
	 */
	private void deleteFileFromServer(String filename)
	{
		String imagePath = usrPath + imgPath + filename;
		
		try
		{
			File file = new File(imagePath);
			file.delete();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}
