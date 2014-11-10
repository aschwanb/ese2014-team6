package ch.studihome.model.pojos;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.junit.Test;

import ch.studihome.jspserver.model.pojos.BSalert;
import ch.studihome.jspserver.model.pojos.BSalert.Type;

public class BSalertTest
{

	@Test
	public void testBSalertGetTypeGetMessage()
	{
		Type type = Type.success;
		String message = "An important alert";
		BSalert bSalert = new BSalert(type, message);
		String actual = bSalert.getType();
		assertEquals("success", actual);
		actual = bSalert.getMessage();
		assertEquals(message, actual);
	}

	@Test
	public void testSetType()
	{
		Type type = Type.success;
		String message = "An important alert";
		BSalert bSalert = new BSalert(type, message);
		bSalert.setType("info");
		String actual = bSalert.getType();
		assertEquals("info", actual);
	}

	@Test
	public void testSetMessage()
	{
		Type type = Type.success;
		String message = "An important alert";
		BSalert bSalert = new BSalert(type, message);
		message = "An even more important alert";
		bSalert.setMessage(message);
		String actual = bSalert.getMessage();
		assertEquals(message, actual);
	}

}
