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
			<table class="table table-striped table-hover" id="accordion">
				<tr><th>Title</th><th>Price</th><th></th><th></th></tr>
				<c:forEach var="ad" items="${ads}">
					<tr>
						<td><a data-toggle="collapse" data-parent="#accordion" href="#collapse${ad.advId}"><c:out value="${ad.title}"/></a></td>
						<td><a data-toggle="collapse" data-parent="#accordion" href="#collapse${ad.advId}"><c:out value="${ad.price}"/></a></td>
						<td><a class="btn btn-dafault" data-toggle="collapse" data-parent="#accordion" href="#collapse${ad.advId}">Show Interestees</a></td>
						<td><a class="btn btn-dafault" href="advert?id=${ad.advId}">Open Ad</a></td>
					</tr>
					<tr></tr>
					<tr id="collapse${ad.advId}" class="collapse"><td colspan="5">
						<c:if test="${not empty ad.interesteesList}">
							<span class="glyphicon glyphicon-chevron-right"></span> Interestees:
							<table class="table table-striped table-hover">
								<c:forEach var="user" items="${ad.interestees}">
									<tr> <!-- TODO onclick="document.location='advert?id=${ad.advId}';" -->
										<td><a href="#TODO"><c:out value="${user.userName}"/></a></td>
										<td><a href="#TODO"><c:out value="${user.email}"/></a></td>
										<td><a class="btn btn-dafault" href="test?usrId=${user.usrId}&adId=${adForm.id}">Invite to event</a></td>
										<td><a class="btn btn-dafault" href="contact?usrId=${user.usrId}">Contact</a></td>
									</tr>
								</c:forEach>
							</table>
						</c:if>
						<c:if test="${empty ad.interestees}">
							<span class="plyphicon glyphicon-chevron-right"></span> No Interestees.
						</c:if>
					</td></tr>
				</c:forEach>
			</table>
		</c:if>
		<c:if test="${empty ads}">
			No Ads available
		</c:if>
	</jsp:body>
</base:page>
