package ch.studihome.model;

import static org.junit.Assert.*;

import org.junit.Test;

import ch.studihome.jspserver.model.Advert;
import ch.studihome.jspserver.model.RoomImg;

public class RoomInmgTest
{

	@Test
	public void testSetRimg_idGetRimg_id()
	{
		RoomImg roomImg = new RoomImg();
		long id = 5;
		roomImg.setRimg_id(id);
		long actual = roomImg.getRimg_id();
		assertEquals(id, actual);
	}

	@Test
	public void testSetImgNameGetImgName()
	{
		RoomImg roomImg = new RoomImg();
		String imgName = "Img1";
		roomImg.setImgName(imgName);
		String actual = roomImg.getImgName();
		assertEquals(imgName, actual);
	}

	@Test
	public void testSetImgDescriptionGetImgDescription()
	{
		RoomImg roomImg = new RoomImg();
		String imgDescription = "A nice description";
		roomImg.setImgDescription(imgDescription);
		String actual = roomImg.getImgDescription();
		assertEquals(imgDescription, actual);
	}

	@Test
	public void testSetAdvertGetAdvert()
	{
		RoomImg roomImg = new RoomImg();
		Advert advert = new Advert();
		roomImg.setAdvert(advert);
		Advert actual = roomImg.getAdvert();
		assertEquals(advert, actual);
	}

	@Test
	public void testSetImgNumGetImgNum()
	{
		RoomImg roomImg = new RoomImg();
		int imgNum = 3;
		roomImg.setImgNum(imgNum);
		int actual = roomImg.getImgNum();
		assertEquals(imgNum, actual);
	}

}
