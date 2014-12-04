<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="base" tagdir="/WEB-INF/tags" %>

<base:page title="Reset Database">
	<jsp:attribute name="page_header">
		<h1>Enter Password to reset database: </h1>
	</jsp:attribute>
	
	<jsp:body>
		<form method="post" action="resetDatabase" class="form-horizontal">
			<input type="password" name="o" class="form-control"/>
			<button type="submit" class="btn btn-primary">Reset</button>
			<a class="btn btn-default" href="index">Cancel</a>
		</form>
	</jsp:body>
</base:page>
