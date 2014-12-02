package ch.studihome.jspserver.controller.service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.studihome.jspserver.model.Advert;
import ch.studihome.jspserver.model.Alert;
import ch.studihome.jspserver.model.User;
import ch.studihome.jspserver.model.dao.AdvertDao;
import ch.studihome.jspserver.model.dao.UserDao;
import ch.studihome.jspserver.model.pojos.SearchForm;

@Service
public class AlertServiceImpl implements AlertService
{
	@Autowired
	UserDao userDao;
	@Autowired
	AdvertDao advertDao;
	
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
		String area = "%" + alert.getArea() + "%";
		area.replace(' ', '%');
		List<Advert> newAds = advertDao.findFiltered(alert.getMin_price(), 
													 alert.getMax_price(),
													 alert.getMin_room_size(),
													 alert.getMax_room_size(),
													 alert.getMin_appartment_size(),
													 alert.getMax_appartment_size(),
													 alert.getMin_number_of_inhabitants(),
													 alert.getMax_number_of_inhabitants(),
													 area,
													 alert.getType_of_appartment(),
													 alert.getTimeAndDate());
		alert.getAdverts().addAll(newAds);
		alert.setTimeAndDate(new Date().getTime());

	}

}
