<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="base" tagdir="/WEB-INF/tags" %>


<base:page title="msgTest">
	<jsp:attribute name="page_header">
		<h1>Compose a Message</h1>
	</jsp:attribute>
	
	<jsp:body>
		<form:form method="post" modelAttribute="messageForm" action="msgTest" id="messageForm">
			<form:input path="toUserEmail" id="field-toUserEmail" />
			<form:input path="fromUserEmail" id="field-fromUserEmail" />
			<form:input path="title" id="field-title" />
			<form:input path="message" id="field-message" />
			
			<div class="form-actions">
		    	<button type="submit" class="btn btn-primary">Send message</button>
		        <a class="btn btn-default" href="index">Cancel</a>            
		     </div>
		</form:form>
		
		<c:if test="${not empty message}">
		<b> Your message is ${message.message}</b>
		</c:if>


	</jsp:body>
</base:page>