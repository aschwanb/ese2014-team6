<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="base" tagdir="/WEB-INF/tags" %>


<base:page title="Profile">
	<jsp:attribute name="page_header">
		<h1>${user.userName}'s bookmarks</h1>
	</jsp:attribute>

	<jsp:body>
		<div>
			<!-- Tab panes -->
			<div>
				<c:if test="${not empty bookmarks}">
					<table class="table table-striped table-hover">
						<tr><th>Title</th><th>Price</th><th></th></tr>
						<c:forEach var="bm" items="${bookmarks}">
							<tr onclick="document.location='advert?id=${bm.advert.advId}';">
								<td><a href="advert?id=${bm.advert.advId}"><c:out value="${bm.advert.title}"/></a></td>
								<td><a href="advert?id=${bm.advert.advId}"><c:out value="${bm.advert.price}"/></a></td>
								<td><a href="advert?id=${bm.advert.advId}"><c:if test="${bm.interested == true}">shown interest</c:if></a></td>
							</tr>
						</c:forEach>
					</table>
				</c:if>
				<c:if test="${empty bookmarks}">
					No Ads bookmarked.
				</c:if>
			</div>
		</div>
	</jsp:body>
</base:page>
