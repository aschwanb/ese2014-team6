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
						<div class="col-md-12">
					        <c:set var="userNameErrors"><form:errors path="userName"/></c:set>
					        <div class="form-group<c:if test="${not empty userNameErrors}"> has-error</c:if>">
					            <label class="control-label" for="field-userName">User Name</label>
					            <div class="form-group">
					                <div class="col-md-4"><form:input path="userName" class="form-control"  id="field-userName" tabindex="1" maxlength="45" placeholder="e.g. theBimbo"/></div>
					                <div class="col-md-4"><form:errors path="userName" class="alert alert-danger" role="alert"/></div>
					        	</div>
					        </div>
							
					        <c:set var="firstNameErrors"><form:errors path="firstName"/></c:set>
					        <div class="form-group<c:if test="${not empty firstNameErrors}"> has-error</c:if>">
					            <label class="control-label" for="field-firstName">First Name</label>
					            <div class="form-group">
						            <div class="col-md-4"><form:input path="firstName" class="form-control"  id="field-firstName" tabindex="1" maxlength="45" placeholder="e.g. Franz"/></div>
						            <div class="col-md-4"><form:errors path="firstName" class="alert alert-danger" role="alert"/></div>
					        	</div>
					        </div>
							
					        <c:set var="lastNameErrors"><form:errors path="lastName"/></c:set>
					        <div class="form-group<c:if test="${not empty lastNameErrors}"> has-error</c:if>">
					            <label class="control-label" for="field-lastName">Last Name</label>
				                <div class="form-group">
					                <div class="col-md-4"><form:input path="lastName" class="form-control"  id="field-lastName" tabindex="1" maxlength="45" placeholder="e.g. Muster"/></div>
					                <div class="col-md-4"><form:errors path="lastName" class="alert alert-danger" role="alert"/></div>
					        	</div>
					        </div>
					        
					        <c:set var="emailErrors"><form:errors path="email"/></c:set>
					        <div class="form-group<c:if test="${not empty emailErrors}"> has-error</c:if>">
					            <label class="control-label" for="field-email">Email</label>
					            <div class="form-group">
					                <div class="col-md-4"><form:input path="email" class="form-control"  id="field-email" tabindex="1" maxlength="45" placeholder="e.g. franz@muster.de"/></div>
					                <div class="col-md-4"><form:errors path="email" class="alert alert-danger" role="alert"/></div>
					        	</div>
					        </div>
					      
					        <c:set var="passwordErrors"><form:errors path="password"/></c:set>
					        <div class="form-group<c:if test="${not empty passwordErrors}"> has-error</c:if>">
					            <label class="control-label" for="field-password">Password</label>
				                <div class="form-group">
					                <div class="col-md-4"><form:input type="password" path="password" class="form-control"  id="field-password" tabindex="2" maxlength="35" placeholder="e.g. ****"/></div>
					                <div class="col-md-4"><form:errors path="password" class="alert alert-danger" role="alert"/></div>
					        	</div>
					        </div>
					
					        <c:set var="confirmPasswordErrors"><form:errors path="confirmPassword"/></c:set>
					        <div class="form-group<c:if test="${not empty confirmPasswordErrors}"> has-error</c:if>">
					            <label class="control-label" for="field-confirmPassword">Confirm Password</label>
				                <div class="form-group">
					                <div class="col-md-4"><form:input type="password" path="confirmPassword" class="form-control"  id="field-confirmPassword" tabindex="2" maxlength="35" placeholder="e.g. ****"/></div>
					                <div class="col-md-4"><form:errors path="confirmPassword" class="alert alert-danger" role="alert"/></div>
					        	</div>
					        </div>
					        
					        <div class="form-group">     
						        <div class="form-actions">
						            <button type="submit" class="btn btn-primary">Sign up</button>
						            <a class="btn btn-default" href="index">Cancel</a>            
						        </div>
					         <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
							</div>
						</div>
					</div>
				</div>
		    </fieldset>
		</form:form>
	</jsp:body>
</base:page>
