<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="base" tagdir="/WEB-INF/tags" %>


<base:page title="Profile - change password">
	<jsp:attribute name="page_header">
		<h1>${user.userName}'s profile <small>change password</small></h1>
	</jsp:attribute>

	<jsp:body>
		<form:form method="post" modelAttribute="changePasswordForm" action="changepassword" id="profileForm" cssClass="form-horizontal"  autocomplete="off">
		    <fieldset>
				<div class="row">
					<div class="col-xs-12">
						<div class="col-md-12">
					        <c:set var="passwordErrors"><form:errors path="password"/></c:set>
					        <div class="form-group<c:if test="${not empty passwordErrors}"> has-error</c:if>">
					            <label class="control-label" for="field-password">Password</label>
				                <form:input type="password" path="password" class="form-control"  id="field-password" tabindex="2" maxlength="35" placeholder="e.g. ****"/>
				                <form:errors path="password" cssClass="help-inline control-label" element="span"/>
					        </div>
					
					        <c:set var="confirmPasswordErrors"><form:errors path="confirmPassword"/></c:set>
					        <div class="form-group<c:if test="${not empty confirmPasswordErrors}"> has-error</c:if>">
					            <label class="control-label" for="field-confirmPassword">Confirm Password</label>
				                <form:input type="password" path="confirmPassword" class="form-control"  id="field-confirmPassword" tabindex="2" maxlength="35" placeholder="e.g. ****"/>
				                <form:errors path="confirmPassword" cssClass="help-inline control-label" element="span"/>
					        </div>
					             
					        <div class="form-actions pull-right">
					            <button type="submit" class="btn btn-primary">Save</button>
					            <a class="btn btn-default" href="profile">Cancel</a>            
					        </div>
						</div>
					</div>
				</div>
		    </fieldset>
		</form:form>
	</jsp:body>
</base:page>
