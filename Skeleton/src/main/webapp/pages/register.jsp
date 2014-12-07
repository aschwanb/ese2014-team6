<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="base" tagdir="/WEB-INF/tags" %>


<base:page title="Register">
	<jsp:attribute name="page_header">
		<h1>Register</h1>
	</jsp:attribute>
	
	<jsp:body>
		<form:form method="post" modelAttribute="signupForm" action="register" id="signupForm" class="form-horizontal"  autocomplete="off">
		    <fieldset>
				
				<div class="row">
					<div class="col-xs-12">
						<div class="col-md-12 form-col">
							<div class="row">
						        <c:set var="userNameErrors"><form:errors path="userName"/></c:set>
						        <div class="form-group col-md-6<c:if test="${not empty userNameErrors}"> has-error</c:if>">
						            <label class="control-label" for="field-userName">User Name</label>
					                <form:input path="userName" class="form-control"  id="field-userName" tabindex="1" maxlength="45" placeholder="e.g. theBimbo"/>
					                <form:errors path="userName" class="alert alert-danger" role="alert"/>
						        </div>
						        
						        <c:set var="emailErrors"><form:errors path="email"/></c:set>
						        <div class="form-group col-md-6<c:if test="${not empty emailErrors}"> has-error</c:if>">
						            <label class="control-label" for="field-email">Email</label>
						            <form:input path="email" class="form-control"  id="field-email" tabindex="1" maxlength="45" placeholder="e.g. franz@muster.de"/>
									<form:errors path="email" class="alert alert-danger" role="alert"/>
						        </div>
							</div>
							
							<div class="row">
						        <c:set var="firstNameErrors"><form:errors path="firstName"/></c:set>
						        <div class="form-group col-md-6<c:if test="${not empty firstNameErrors}"> has-error</c:if>">
						            <label class="control-label" for="field-firstName">First Name</label>
						            <form:input path="firstName" class="form-control"  id="field-firstName" tabindex="1" maxlength="45" placeholder="e.g. Franz"/>
							         <form:errors path="firstName" class="alert alert-danger" role="alert"/>
						        </div>
								
						        <c:set var="lastNameErrors"><form:errors path="lastName"/></c:set>
						        <div class="form-group col-md-6<c:if test="${not empty lastNameErrors}"> has-error</c:if>">
						            <label class="control-label" for="field-lastName">Last Name</label>
					                <form:input path="lastName" class="form-control"  id="field-lastName" tabindex="1" maxlength="45" placeholder="e.g. Muster"/>
					                <form:errors path="lastName" class="alert alert-danger" role="alert"/>
						        </div>
							</div>
					        
							<div class="row">
						        <c:set var="passwordErrors"><form:errors path="password"/></c:set>
						        <div class="form-group col-md-6<c:if test="${not empty passwordErrors}"> has-error</c:if>">
						            <label class="control-label" for="field-password">Password</label>
					                <form:input type="password" path="password" class="form-control"  id="field-password" tabindex="2" maxlength="35" placeholder="e.g. ****"/>
						            <form:errors path="password" class="alert alert-danger" role="alert"/>
						        </div>
						
						        <c:set var="confirmPasswordErrors"><form:errors path="confirmPassword"/></c:set>
						        <div class="form-group col-md-6<c:if test="${not empty confirmPasswordErrors}"> has-error</c:if>">
						            <label class="control-label" for="field-confirmPassword">Confirm Password</label>
					                <form:input type="password" path="confirmPassword" class="form-control"  id="field-confirmPassword" tabindex="2" maxlength="35" placeholder="e.g. ****"/>
						            <form:errors path="confirmPassword" class="alert alert-danger" role="alert"/>
						        </div>
					        </div>
					        
							<div class="row">
								<div class="form-actions col-md-12">
							        <div class="pull-right">
							            <a class="btn btn-default" href="index">Cancel</a>
							            <button type="submit" class="btn btn-primary">Sign up</button>
							        </div>
									<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
								</div>
							</div>
						</div>
					</div>
				</div>
		    </fieldset>
		</form:form>
	</jsp:body>
</base:page>
