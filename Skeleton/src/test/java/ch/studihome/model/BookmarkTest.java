package ch.studihome.model;

import static org.junit.Assert.*;

import org.junit.Test;

import ch.studihome.jspserver.model.Advert;
import ch.studihome.jspserver.model.Bookmark;
import ch.studihome.jspserver.model.User;

public class BookmarkTest
{
	@Test
	public void testSetBmIdGetBmId()
	{
		Bookmark bookmark = new Bookmark();
		long expected = 1l;
		bookmark.setBmId(expected);
		long actual = bookmark.getBmId();
		assertEquals(expected, actual);
	}

	@Test
	public void testSetUserGetUser()
	{
		Bookmark bookmark = new Bookmark();
		User expected = new User();
		expected.setusrId(1l);
		bookmark.setUser(expected);
		User actual = bookmark.getUser();
		assertEquals(expected, actual);
	}

	@Test
	public void testSetAdvertGetAdvert()
	{
		Bookmark bookmark = new Bookmark();
		Advert expected = new Advert();
		expected.setadvId(1l);
		bookmark.setAdvert(expected);
		Advert actual = bookmark.getAdvert();
		assertEquals(expected, actual);
	}

	@Test
	public void testSetInterestedGetInterested()
	{
		Bookmark bookmark = new Bookmark();
		boolean expected = true;
		bookmark.setInterested(expected);
		boolean actual = bookmark.getInterested();
		assertEquals(expected, actual);
	}
}
