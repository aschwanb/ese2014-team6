package ch.studihome.jspserver.controller.service;

import ch.studihome.jspserver.model.Alert;
import ch.studihome.jspserver.model.User;
import ch.studihome.jspserver.model.pojos.SearchForm;

public interface AlertService
{
	public void addAlert(SearchForm searchForm, User user);
	
	public void updateAlert(Alert alert);
	
}
