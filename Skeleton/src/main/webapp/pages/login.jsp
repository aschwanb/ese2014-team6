<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:import url="template/header.jsp" />

<div class="page-header">
	<h1>Please Login</h1>
</div>

<c:url value="/login" var="loginUrl"/>
<form:form name="f" action="${loginUrl}" method="POST">
	<fieldset>
		<c:if test="${param.error != null}">
		<div class="alert alert-error">
			Invalid username or password.
		</div>
		</c:if>
			<c:if test="${param.logout != null}">
			<div class="alert alert-success">
				You have been logged out.
			</div>
		</c:if>
		
		<div class="control-group">
			<label for="username">Username</label>
			<input type="text" id="username" name="username" value="${username}"/>
		</div>
		<div class="control-group">
			<label for="password">Password</label>
			<input type="password" id="password" name="password"/>
		</div>
		
		<div class="form-actions">
			<button type="submit" class="btn btn-primary">Log in</button>
			<a class="btn btn-default" href="index">Cancel</a>
		</div>
	</fieldset>
</form:form>

<c:import url="template/footer.jsp" />
