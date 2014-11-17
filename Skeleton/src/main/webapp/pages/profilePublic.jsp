<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="base" tagdir="/WEB-INF/tags" %>


<base:page title="Profile">
	<jsp:attribute name="page_header">
		<h1>Public Page of ${user.userName}</h1>
		<h1>ID: ${user.usr_id}</h1>
		
	</jsp:attribute>

	<jsp:body>
		<h3>Some text. Some more text. And even more text.</h3>
	</jsp:body>
</base:page>
