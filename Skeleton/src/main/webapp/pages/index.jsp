<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="base" tagdir="/WEB-INF/tags" %>


<base:page title="StudiHome">
	<jsp:attribute name="customHead">
		<link rel="stylesheet" type="text/css" href="css/jquery.dataTables.css">
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="js/jquery.dataTables.js"></script>
	</jsp:attribute>
	
	<jsp:attribute name="page_header">
		<h1>Welcome to StudiHome</h1>
	</jsp:attribute>
	
	<jsp:body>
		<h2>Start looking for your home today</h2>
		
		<c:if test="${not empty ads}">
			<table id="allAds" class="table table-striped table-hover display">
				<thead>
					<tr><th>Image</th><th>Title</th><th>Location</th><th>Price</th></tr>
				</thead>
				<tbody>
					<c:forEach var="ad" items="${ads}">
						<tr onclick="document.location='advert?id=${ad.adv_id}';">
							<td>
								  <div class="col-xs-6 col-md-3">
								<a href="advert?id=${ad.adv_id}">
									<img src="${imgPath}${ad.firstImage}" alt="Image not found" class="img-thumbnail">
								</a>
								</div>
							</td>
							<td><a href="advert?id=${ad.adv_id}"><c:out value="${ad.title}"/></a></td>
							<td><a href="advert?id=${ad.adv_id}">
								<c:out value="${ad.address.street} ${ad.address.plz} ${ad.address.city}"/></a></td>
							<td><a href="advert?id=${ad.adv_id}"><c:out value="${ad.price}"/></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</jsp:body>
</base:page>
<script>
$(document).ready(function(){
    $('#allAds').dataTable();
});
</script>
