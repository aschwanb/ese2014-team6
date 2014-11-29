<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="base" tagdir="/WEB-INF/tags" %>


<base:page title="Profile">
	<jsp:attribute name="page_header">
		<h1>${user.userName}'s adverts</h1>
	</jsp:attribute>

	<jsp:body>
		<c:if test="${not empty ads}">
			<table class="table table-striped table-hover">
				<tr><th>Title</th><th>Price</th></tr>
				<c:forEach var="ad" items="${ads}">
					<tr onclick="document.location='advert?id=${ad.advId}';">
						<td><a href="advert?id=${ad.advId}"><c:out value="${ad.title}"/></a></td>
						<td><a href="advert?id=${ad.advId}"><c:out value="${ad.price}"/></a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		<c:if test="${empty ads}">
			No Ads available
		</c:if>
	</jsp:body>
</base:page>
