<%@tag description="Page structure with bottom" pageEncoding="UTF-8"%>

<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
<%-- <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> --%>
<%-- <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> --%>
<%@taglib prefix="base" tagdir="/WEB-INF/tags" %>

<%@attribute name="header" fragment="true" required="true" %>

<base:page_base>
	<jsp:attribute name="header">
		<jsp:invoke fragment="header"/>
	</jsp:attribute>
	
	<jsp:body>
		<jsp:doBody/>
		
		<%-- Add bottom content here --%>
		
	</jsp:body>
</base:page_base>