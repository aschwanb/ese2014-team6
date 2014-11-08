<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="base" tagdir="/WEB-INF/tags" %>


<base:page title="NO ACCESS">
	<jsp:attribute name="page_header">
		<h1>Access denied</h1>
	</jsp:attribute>
	
	<jsp:body>
		<div class="alert alert-danger">
			${msg}
		</div>
	</jsp:body>
</base:page>
