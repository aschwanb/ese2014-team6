<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="base" tagdir="/WEB-INF/tags" %>


<base:page title="StudiHome">

	<div class="page-header">
		<h1>Welcome to StudiHome</h1>
	</div>
	
	<h2>Start looking for your home today</h2>

	<c:if test="${not empty ads}">
		<table>
			<tr><th>ID</th><th>Title</th><th>Price</th></tr>
			<c:forEach var="ad" items="${ads}">
				<tr onclick="document.location='adpage?id=${ad.adv_id}';">
					<td><c:out value="${ad.adv_id}"/></td>
					<td><c:out value="${ad.title}"/></td>
					<td><c:out value="${ad.price}"/></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	
	
	<div class="form-actions">
		<a class="btn btn-warning" href="register">Sign Up Here!</a>     
		<a class="btn btn-default" href="profilepage">My Profile</a>
		<c:if test="${pageContext.request.userPrincipal.name != null}">
			<a class="btn btn-default" href="<c:url value="/j_spring_security_logout" />" >Logout</a>
		</c:if>            
	</div>

</base:page>
