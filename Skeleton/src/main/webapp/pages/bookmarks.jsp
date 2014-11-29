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
			
			<!-- Nav tabs -->
			<ul class="nav nav-tabs" role="tablist">
				<li class="active"><a href="#bm" role="tab" data-toggle="tab">Bookmarked</a></li>
				<li><a href="#int" role="tab" data-toggle="tab">Shown Interest</a></li>
			</ul>
			
			<!-- Tab panes -->
			<div class="tab-content">
				<div class="tab-pane fade in active" id="bm">
					<c:if test="${not empty bookmarks}">
						<table class="table table-striped table-hover">
							<tr><th>Title</th><th>Price</th></tr>
							<c:forEach var="ad" items="${bookmarks}">
								<tr onclick="document.location='advert?id=${ad.advId}';">
									<td><a href="advert?id=${ad.advId}"><c:out value="${ad.title}"/></a></td>
									<td><a href="advert?id=${ad.advId}"><c:out value="${ad.price}"/></a></td>
								</tr>
							</c:forEach>
						</table>
					</c:if>
					<c:if test="${empty bookmarks}">
						No Ads bookmarked.
					</c:if>
				</div>
				<div class="tab-pane fade" id="int">
					<c:if test="${not empty interests}">
						<table class="table table-striped table-hover">
							<tr><th>Title</th><th>Price</th></tr>
							<c:forEach var="ad" items="${interests}">
								<tr onclick="document.location='advert?id=${ad.advId}';">
									<td><a href="advert?id=${ad.advId}"><c:out value="${ad.title}"/></a></td>
									<td><a href="advert?id=${ad.advId}"><c:out value="${ad.price}"/></a></td>
								</tr>
							</c:forEach>
						</table>
					</c:if>
					<c:if test="${empty bookmarks}">
						No Ads marked as interesting.
					</c:if>
				</div>
			</div>
		</div>
	</jsp:body>
</base:page>
