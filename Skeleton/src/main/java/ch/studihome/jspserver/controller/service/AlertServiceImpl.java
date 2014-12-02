package ch.studihome.jspserver.controller.service;

import java.util.Date;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;

import ch.studihome.jspserver.model.Alert;
import ch.studihome.jspserver.model.User;
import ch.studihome.jspserver.model.dao.UserDao;
import ch.studihome.jspserver.model.pojos.SearchForm;

public class AlertServiceImpl implements AlertService
{
	@Autowired
	UserDao userDao;

	public void addAlert(SearchForm searchForm, User user)
	{
		HashSet<Alert> alerts = (HashSet<Alert>) user.getAlerts();
    	Alert alert = new Alert();
    	alert.setUser(user);
    	alert.setMin_price(searchForm.getMin_price());
    	alert.setMax_price(searchForm.getMax_price());
    	alert.setMin_room_size(searchForm.getMin_room_size());
    	alert.setMax_room_size(searchForm.getMax_room_size());
    	alert.setMin_appartment_size(searchForm.getMin_appartment_size());
    	alert.setMax_appartment_size(searchForm.getMax_appartment_size());
    	alert.setMin_number_of_inhabitants(searchForm.getMin_number_of_inhabitants());
    	alert.setMax_number_of_inhabitants(searchForm.getMax_number_of_inhabitants());
    	alert.setArea(searchForm.getArea());
    	alert.setType_of_appartment(searchForm.getType_of_apartment());
    	alert.setTimeAndDate(new Date().getTime());
    	
    	alerts.add(alert);
    	userDao.save(user);
	}

	public void updateAlert(Alert alert)
	{
		// TODO Auto-generated method stub

	}

}
