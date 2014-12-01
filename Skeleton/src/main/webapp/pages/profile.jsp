<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="base" tagdir="/WEB-INF/tags" %>


<base:page title="Profile">
	<jsp:attribute name="page_header">
		<h1>${user.userName}'s profile</h1>
	</jsp:attribute>

	<jsp:body>
		<form:form method="post" modelAttribute="profileForm" action="updateprofile" id="profileForm" cssClass="form-horizontal"  autocomplete="off">
		    <fieldset>
				<div class="row">
					<div class="col-xs-12">
						<div class="col-md-12">
					        <div class="form-group">
					            <label class="control-label" for="field-firstName">First Name</label>
					            <form:input path="firstName" class="form-control adform-output" readonly="true"  id="field-firstName" tabindex="1" maxlength="45" placeholder="e.g. Franz"/>
					        </div>
							
					        <div class="form-group">
					            <label class="control-label" for="field-lastName">Last Name</label>
				                <form:input path="lastName" class="form-control adform-output" readonly="true"  id="field-lastName" tabindex="1" maxlength="45" placeholder="e.g. Muster"/>
					        </div>
					        
					        <div class="form-group">
					            <label class="control-label" for="field-email">Email</label>
				                <form:input path="email" class="form-control adform-output" readonly="true"  id="field-email" tabindex="1" maxlength="45" placeholder="e.g. franz@muster.de"/>
					        </div>
					             
					        <div class="form-actions pull-right">
					            <a class="btn btn-default" href="profile?edit">Edit</a>
					            <a class="btn btn-default" href="profile?changePswd">Change Password</a>            
					        </div>
						</div>
					</div>
				</div>
		    </fieldset>
		</form:form>
	</jsp:body>
</base:page>
