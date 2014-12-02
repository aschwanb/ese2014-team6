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
				<thead>	
					<tr><th>Number Of Alert</th><th>Image</th><th>Title</th><th>Location</th><th>Price</th><th>Room Size</th><th>Apartment Size</th><th>Number Of Inhabitants</th><th>Type Of Apartment</th></tr>
				</thead>
				<tbody>
					<c:forEach var="alert" varStatus="status" items="${alerts}">
						<c:if test="${not empty alert.adverts}">
							<c:forEach var "ad" items="${alert.adverts}">
								<tr onclick="document.location='advert?id=${ad.advId}';">
									<td><a href="advert?id=${ad.advId}"><c:out value="${status.index}"/></a></td>
									<td>
										  <div class="col-xs-6 col-md-3">
										<a href="advert?id=${ad.advId}">
											<img src="${imgPath}${ad.firstImage}" alt="Image not found" class="img-thumbnail">
										</a>
										</div>
									</td>
									<td><a href="advert?id=${ad.advId}"><c:out value="${ad.title}"/></a></td>
									<td><a href="advert?id=${ad.advId}">
										<c:out value="${ad.address.street} ${ad.address.plz} ${ad.address.city}"/></a></td>
									<td><a href="advert?id=${ad.advId}"><c:out value="${ad.price}"/></a></td>
									<td><a href="advert?id=${ad.advId}"><c:out value="${ad.roomSize}"/></a></td>
									<td><a href="advert?id=${ad.advId}"><c:out value="${ad.appartementSize}"/></a></td>
									<td><a href="advert?id=${ad.advId}"><c:out value="${ad.numberOfInhabitants}"/></a></td>
									<td><a href="advert?id=${ad.advId}"><c:out value="${ad.isWG?'Shared Flat':'Single Apartment'}"/></a></td>
								</tr>
							</c:forEach>	
						</c:if>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
		<c:if test="${empty ads}">
			No Alerts set
		</c:if>
	</jsp:body>
</base:page>
