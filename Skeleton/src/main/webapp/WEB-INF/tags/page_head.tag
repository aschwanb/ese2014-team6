<%@tag description="Page structure with header(, top and bottom)" pageEncoding="UTF-8"%>

<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
<%-- <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> --%>
<%-- <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> --%>
<%@taglib prefix="base" tagdir="/WEB-INF/tags" %>

<%@attribute name="title" required="true" %>
<%@attribute name="customHead" fragment="true" %>

<base:page_top>
	<jsp:attribute name="header">
		<title>${title}</title>
	    
	    <meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
		<link rel="stylesheet" type="text/css" href="css/bootstrap-theme.min.css"/>
		<link rel="stylesheet" type="text/css" href="css/theme.css"/>
		<link rel="stylesheet" type="text/css" href="css/formating.css"/>
		<script type="text/javascript" src="http://code.jquery.com/jquery-2.1.1.min.js"></script>
		<script type="text/javascript"  src="js/bootstrap.min.js"></script>
		
		<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
		<!--[if lt IE 9]>
		<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
	    
	    <jsp:invoke fragment="customHead"/>
	</jsp:attribute>
	
	<jsp:body>
		<jsp:doBody/>
	</jsp:body>
</base:page_top>

