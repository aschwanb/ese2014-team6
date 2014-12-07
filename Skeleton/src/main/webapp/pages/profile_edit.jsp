<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="base" tagdir="/WEB-INF/tags" %>


<base:page title="Profile - edit">
	<jsp:attribute name="page_header">
		<h1>${user.userName}'s profile <small>edit</small></h1>
	</jsp:attribute>

	<jsp:body>
		<form:form method="post" modelAttribute="profileForm" action="updateprofile" id="profileForm" cssClass="form-horizontal"  autocomplete="off">
		    <fieldset>
				<div class="row">
					<div class="col-xs-12">
						<div class="col-md-12">
					        <c:set var="firstNameErrors"><form:errors path="firstName"/></c:set>
					        <div class="form-group<c:if test="${not empty firstNameErrors}"> has-error</c:if>">
					            <label class="control-label" for="field-firstName">First Name</label>
					            <form:input path="firstName" class="form-control"  id="field-firstName" tabindex="1" maxlength="45" placeholder="e.g. Franz"/>
					            <form:errors path="firstName" cssClass="help-inline control-label" element="span"/>
					        </div>
							
					        <c:set var="lastNameErrors"><form:errors path="lastName"/></c:set>
					        <div class="form-group<c:if test="${not empty lastNameErrors}"> has-error</c:if>">
					            <label class="control-label" for="field-lastName">Last Name</label>
				                <form:input path="lastName" class="form-control"  id="field-lastName" tabindex="1" maxlength="45" placeholder="e.g. Muster"/>
				                <form:errors path="lastName" cssClass="help-inline control-label" element="span"/>
					        </div>
					        
					        <c:set var="emailErrors"><form:errors path="email"/></c:set>
					        <div class="form-group<c:if test="${not empty emailErrors}"> has-error</c:if>">
					            <label class="control-label" for="field-email">Email</label>
				                <form:input path="email" class="form-control"  id="field-email" tabindex="1" maxlength="45" placeholder="e.g. franz@muster.de"/>
				                <form:errors path="email" cssClass="help-inline control-label" element="span"/>
					        </div>
					             
					        <div class="form-actions pull-right">
					            <button type="submit" class="btn btn-primary">Save Changes</button>
					            <a class="btn btn-default" href="profile">Cancel</a>            
					        </div>
						</div>
					</div>
				</div>
		    </fieldset>
		</form:form>
	</jsp:body>
</base:page>
