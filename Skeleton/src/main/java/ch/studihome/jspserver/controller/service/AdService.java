package ch.studihome.jspserver.controller.service;

import ch.studihome.jspserver.controller.exceptions.ImageSaveException;
import ch.studihome.jspserver.model.Advert;
import ch.studihome.jspserver.model.pojos.AdForm;

/**
 * Responsible to save and load AdForms to/from the data base
 * 
 * @author TeamSiX
 */
public interface AdService {
	
	/**
	 * @return all adverts in the database
	 */
	public Iterable<Advert> findAll();
	
	/**
	 * @param adId Id of the advert in the DB
	 * @return AdForm containing the data of the specified advert
	 */
	public AdForm loadById(String adId);
	
	/**
	 * @param adForm the AdForm to be saved (may become invalid, use returned AdForm)
	 * @return the unchanged AdForm
	 * @throws ImageSaveException thrown if the image could not be saved on the server
	 */
	public AdForm saveFrom(AdForm adForm) throws ImageSaveException;

}
