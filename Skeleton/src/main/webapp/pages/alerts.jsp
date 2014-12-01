<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="base" tagdir="/WEB-INF/tags" %>


<base:page title="Profile">
	<jsp:attribute name="page_header">
		<h1>${user.userName}'s alerts</h1>
		
	</jsp:attribute>

	<jsp:body>
		<c:if test="${not empty alerts}">
			<table class="table table-striped table-hover">
				<tr><th>Title</th><th>Price</th></tr>
				<c:forEach var="alert" items="${alerts}">
					<tr><!--
						<td><a><c:out value="${alert.title}"/></a></td>
						<td><a><c:out value="${alert.price}"/></a></td> -->
					</tr>
				</c:forEach>
			</table>
		</c:if>
		<c:if test="${empty ads}">
			No Alerts set
		</c:if>
	</jsp:body>
</base:page>
