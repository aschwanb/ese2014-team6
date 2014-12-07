<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="base" tagdir="/WEB-INF/tags" %>


<base:page title="Calendar">
	<jsp:attribute name="customHead">
		<link rel="stylesheet" type="text/css" href="css/bic_calendar.css">
		<script type="text/javascript" src="js/bic_calendar.min.js"></script>
	</jsp:attribute>

	<jsp:body>
		<c:out value="${user.calendar.string}" escapeXml="false"></c:out>
	</jsp:body>
</base:page>
