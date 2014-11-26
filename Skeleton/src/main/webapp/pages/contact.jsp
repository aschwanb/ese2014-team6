<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="base" tagdir="/WEB-INF/tags" %>


<base:page title="Contact">
	<jsp:attribute name="page_header">
		<h1>Contact the owner of an ad</h1>
	</jsp:attribute>
	
	<jsp:body>

		<form:form method="post" modelAttribute="messageForm" action="msgTest" id="messageForm" class="form-horizontal" role="form">
	
			<div class="form-group" style="display: none;">
		        <c:set var="toUserEmailErrors"><form:errors path="toUserEmail"/></c:set>
		      		<div class="control-group<c:if test="${not empty toUserEmailErrors}"> has-error</c:if>">			
					<label for="field-toUserEmail" class="col-sm-2 control-label">To User Email</label>
					<div class="col-sm-10 form-inline" >
						<form:input type="text" class="form-control" path="toUserEmail"
						id="field-toUserEmail" placeholder="Their Email" value="${toUser.email}" />
						<form:errors class="alert alert-danger" role="alert" path="toUserEmail"/>
					</div>
				</div>
			</div>

			<div class="form-group" style="display: none;">
			    <c:set var="fromUserEmailErrors"><form:errors path="fromUserEmail"/></c:set>
		      	<div class="control-group<c:if test="${not empty fromUserEmailErrors}"> has-error</c:if>">	
		    	  	<label for="field-fromUserEmail" class="col-sm-2 control-label">Your Email</label>
					<div class="col-sm-10 form-inline" >
						<form:input type="text" class="form-control" path="fromUserEmail" 
						id="field-fromUserEmail" placeholder="Your Email" value="${fromUser.email}"/>
						<form:errors class="alert alert-danger" role="alert" path="fromUserEmail"/>
					</div>
				</div>
			</div>
			
			<div class="form-group">
			    <c:set var="titleErrors"><form:errors path="title"/></c:set>
		      	<div class="control-group<c:if test="${not empty titleErrors}"> has-error</c:if>">	
					<label for="field-title" class="col-sm-2 control-label">Title</label>
					<div class="col-sm-10 form-inline" >
						<form:input type="text" class="form-control" path="title" id="field-title" placeholder="Title"/>
						<form:errors class="alert alert-danger" role="alert" path="title"/>
					</div>
				</div>
			</div>
			
			<div class="form-group">
				<label for="field-message" class="col-sm-2 control-label">Message</label>
				<div class="col-sm-6">
					<form:textarea type="text" class="form-control" path="message" id="field-message"placeholder="Message"/>
				</div>
			</div>
			<div class="form-group">
    			<div class="col-sm-offset-2 col-sm-10">
    		    	<button type="submit" class="btn btn-primary">Send message</button>
		        	<a class="btn btn-default" href="index">Cancel</a>            
		     	</div>
		    </div>
		</form:form>
		
	</jsp:body>
</base:page>