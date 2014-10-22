<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:import url="template/header.jsp" />
<head>
	<title>Please Login</title>
</head>
<body>
	<c:url value="/login" var="loginUrl"/>
	<form:form name="f" action="${loginUrl}" method="POST">
		<fieldset>
			<legend>Please Login</legend>
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
			<label for="username">Username</label>
			<input type="text" id="username" name="username" value="${username}"/>
			<label for="password">Password</label>
			<input type="password" id="password" name="password"/>
			<div class="form-actions">
				<button type="submit" class="btn">Log in</button>
				<a class="btn btn-default" href="index">Cancel</a>
			</div>
		</fieldset>
	</form:form>
</body>

<c:import url="template/footer.jsp" />
