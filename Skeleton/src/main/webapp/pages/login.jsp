<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="base" tagdir="/WEB-INF/tags" %>


<base:page title="Login">
	<jsp:attribute name="page_header">
		<h1>Login</h1>
	</jsp:attribute>
	
	<jsp:body>
		<div id="login-box" class="row">
			<div class="col-xs-12">
				<div class="col-md-4 col-md-offset-4 form-col">
				 	<form name='loginForm' action="<c:url value='/dologin' />" method='POST' class="form-horizontal">
				 		<div class="form-group">
							<label class="control-label" for="field-userName">User name</label>
							<input type='text' id="field-userName" class="form-control" name='userName'>
						</div>
						<div class="form-group">
							<label class="control-label" for="field-password">Password</label>
							<input type='password' id="field-password" class="form-control" name='password' />
						</div>
						<div class="form-actions pull-right">
							<a class="btn btn-default" href="index">Cancel</a>
							<button name="submit" type="submit" value="submit" class="btn btn-primary">Login</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</jsp:body>
</base:page>
