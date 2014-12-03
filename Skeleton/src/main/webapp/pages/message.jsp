<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="base" tagdir="/WEB-INF/tags" %>


<base:page title="Message">
	<jsp:attribute name="page_header">
		<h1>Message Detail view</h1>
	</jsp:attribute>
		<jsp:body>
			<c:if test="${not empty msg}">
				<div><h4><c:out value="${msg.title}"/></h4></div>
				<div><p><c:out value="${msg.message}"/></p></div>
				<c:if test="${not empty msg.invDate}">
					<div>
						Add invitation for the <c:out value="${msg.invDate}"/> at
						<c:out value="${msg.invTime}"/> to your calendar?
					</div>
					<div class="form-group">
						<a class="btn btn-default" href="invite?msgId=${msg.id}&confirm=yes">Confirm</a>
		        		<a class="btn btn-default" href="invite?msgId=${msg.id}&confirm=no">Reject</a>            
					</div>
				</c:if>
				<div class="form-group">
    				<div>
    		    		<a class="btn btn-primary" href="contact?msgId=${msg.id}">Respond</a>
		        		<a class="btn btn-default" href="profile">Cancel</a>            
		     		</div>
		    	</div>				
			</c:if>
		</jsp:body>
</base:page>
