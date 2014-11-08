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
		<div id="login-box">
			<c:if test="${not empty error}">
				<div class="error">${error}</div>
			</c:if>
			<c:if test="${not empty msg}">
				<div class="msg">${msg}</div>
			</c:if>
		 
		 	<form name='loginForm' action="<c:url value='/j_spring_security_check' />" method='POST'>
		 		<table>
					<tr>
						<td>Email:</td>
						<td><input type='text' name='email'></td>
					</tr>
					<tr>
						<td>Password:</td>
						<td><input type='password' name='password' /></td>
					</tr>
	<!-- 			<tr> -->
	<!-- 				<td colspan='2'><input name="submit" type="submit" -->
	<!-- 				  value="submit" /></td> -->
	<!-- 			</tr> -->
				  </table>
		      <div class="form-actions">
		      		<button name="submit" type="submit" value="submit" class="btn btn-primary">login</button>
		            <a class="btn btn-default" href="index">Cancel</a>
		        </div>
				</form>
		</div>
	</jsp:body>
</base:page>
