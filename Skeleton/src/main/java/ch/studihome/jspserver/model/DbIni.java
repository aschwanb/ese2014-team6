package ch.studihome.jspserver.model;

public class DbIni {
	
//	Create some Test users, adverts, messages and save them in the db
	User user1 = new User("Thomas", "Muster", "thomas.muster@test.ch", "test123");
	User user2 = new User("Otto", "Normal", "otto.normal@test.ch", "test123");
	
//	Advert ad1 = new Advert
	Message msg1 = new Message(user1, user2, "Hallo Otto", "Gez. Thomas");
	

}
