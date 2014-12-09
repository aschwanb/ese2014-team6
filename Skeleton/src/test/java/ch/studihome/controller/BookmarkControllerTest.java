package ch.studihome.controller;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.web.servlet.ModelAndView;

import ch.studihome.jspserver.controller.AlertController;
import ch.studihome.jspserver.controller.BookmarkController;
import ch.studihome.jspserver.controller.service.AlertService;
import ch.studihome.jspserver.controller.service.MyUserDetailsService;
import ch.studihome.jspserver.model.Alert;
import ch.studihome.jspserver.model.Bookmark;
import ch.studihome.jspserver.model.User;
import ch.studihome.jspserver.model.dao.AdvertDao;
import ch.studihome.jspserver.model.dao.BookmarkDao;
import ch.studihome.jspserver.model.dao.UserDao;

public class BookmarkControllerTest
{
	
	UserDao userDao;
	AdvertDao advertDao;
	MyUserDetailsService userService;
	BookmarkDao bmDao;
	BookmarkController bookmarkController;
	
	
	@Before
	public void doSetup()
	{
		userDao = mock(UserDao.class);
		advertDao = mock(AdvertDao.class);
		userService = mock(MyUserDetailsService.class);
		bmDao = mock(BookmarkDao.class);
		bookmarkController = new BookmarkController(userDao, advertDao, userService, bmDao);
	}
	
	@Test
	public void testIndex()
	{
		when(userService.getUser()).thenAnswer(new Answer<User>() {

			public User answer(InvocationOnMock invocation)
					throws Throwable
			{
				User user = new User();
				user.setusrId(1l);
				HashSet<Bookmark> bookmarks = new HashSet<Bookmark>();
				Bookmark bookmark = new Bookmark();
				bookmark.setBmId(1l);
				bookmarks.add(bookmark);
				user.setBookmarks(bookmarks);
				return user;
			}
		});
		
		User expected = new User();
		expected.setusrId(1l);
		HashSet<Bookmark> bookmarks = new HashSet<Bookmark>();
		Bookmark bookmark = new Bookmark();
		bookmark.setBmId(1l);
		bookmarks.add(bookmark);
		expected.setBookmarks(bookmarks);
		
		ModelAndView model = bookmarkController.index();
		User actual = (User) model.getModel().get("user");
		assertEquals(expected, actual);
		Bookmark[] bookmarkssActual = (Bookmark[]) model.getModel().get("bookmarks");
		assertEquals(bookmarks.toArray()[0], bookmarkssActual[0]);
	}

	@Test
	public void testSetBookmark()
	{
		ModelAndView model = bookmarkController.setBookmark(null);
		String expected = "invalid request";
		String actual = (String) model.getModel().get("content");
		assertEquals(expected, actual);
	}

	@Test
	public void testSetInterest()
	{
		ModelAndView model = bookmarkController.setInterest(null);
		String expected = "invalid request";
		String actual = (String) model.getModel().get("content");
		assertEquals(expected, actual);
	}

}
