package ch.studihome.jspserver.controller.service;

import ch.studihome.jspserver.model.Alert;
import ch.studihome.jspserver.model.User;
import ch.studihome.jspserver.model.pojos.SearchForm;

/**
 * Responsible for saving SearchForms to the data base and update alerts
 * 
 * @author TeamSiX
 */
public interface AlertService
{
	/**
	 * Creates an Alert from the filter data in searchForm and adds it to the user (saves it in the DB)
	 * 
	 * @param searchForm filter data
	 * @param user user to add the alert to
	 */
	public void addAlert(SearchForm searchForm, User user);
	
	/**
	 * Update the given alert:
	 * Searches the DB for adverts fitting the filters of the alert and 
	 * created/modified after the last update of the alert. 
	 * Then ads them to the advert list of the alert.
	 * 
	 * @param alert alert to be updated
	 */
	public void updateAlert(Alert alert);
	
}
