package ch.studihome.jspserver.controller.service;

import java.util.Date;
import java.util.List;
import java.util.Set;

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
		Set<Alert> alerts = user.getAlerts();
    	Alert alert = new Alert();
    	alert.setUser(user);
    	alert.setMinprice(searchForm.getMinprice());
    	alert.setMaxprice(searchForm.getMaxprice());
    	alert.setMinroomsize(searchForm.getMinroomsize());
    	alert.setMaxroomsize(searchForm.getMaxroomsize());
    	alert.setMinappartmentsize(searchForm.getMinappartmentsize());
    	alert.setMaxappartmentsize(searchForm.getMaxappartmentsize());
    	alert.setMinnumberofinhabitants(searchForm.getMinnumberofinhabitants());
    	alert.setMaxnumberofinhabitants(searchForm.getMaxnumberofinhabitants());
    	alert.setArea(searchForm.getArea());
    	alert.setTypeofappartment(searchForm.getTypeofapartment());
    	alert.setTimeAndDate(new Date().getTime());
    	
    	alerts.add(alert);
    	userDao.save(user);
	}

	public void updateAlert(Alert alert)
	{
		String area = "%" + alert.getArea() + "%";
		area.replace(' ', '%');
		List<Advert> newAds;
		if(alert.getTypeofappartment().equals("Shared Flat"))
		{
			newAds = advertDao.findFilteredShared(alert.getMinprice(), 
												  alert.getMaxprice(),
												  alert.getMinroomsize(),
												  alert.getMaxroomsize(),
												  alert.getMinappartmentsize(),
												  alert.getMaxappartmentsize(),
												  alert.getMinnumberofinhabitants(),
												  alert.getMaxnumberofinhabitants(),
												  area,
												  alert.getTimeAndDate());
		}else if(alert.getTypeofappartment().equals("Single Apartment"))
		{
			newAds = advertDao.findFilteredSingle(alert.getMinprice(), 
												  alert.getMaxprice(),
												  alert.getMinroomsize(),
												  alert.getMaxroomsize(),
												  alert.getMinappartmentsize(),
												  alert.getMaxappartmentsize(),
												  alert.getMinnumberofinhabitants(),
												  alert.getMaxnumberofinhabitants(),
												  area,
												  alert.getTimeAndDate());
		}else
		{
			newAds = advertDao.findFiltered(alert.getMinprice(), 
											alert.getMaxprice(),
											alert.getMinroomsize(),
											alert.getMaxroomsize(),
											alert.getMinappartmentsize(),
											alert.getMaxappartmentsize(),
											alert.getMinnumberofinhabitants(),
											alert.getMaxnumberofinhabitants(),
											area,
											alert.getTimeAndDate());
		}
		
		alert.getAdverts().addAll(newAds);
		alert.setTimeAndDate(new Date().getTime());

	}

}
