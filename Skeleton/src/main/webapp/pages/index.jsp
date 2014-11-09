<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="base" tagdir="/WEB-INF/tags" %>


<base:page title="StudiHome">
	<jsp:attribute name="page_header">
		<h1>Welcome to StudiHome</h1>
	</jsp:attribute>
	
	<jsp:body>
		<h2>Start looking for your home today</h2>
		
		<c:if test="${not empty ads}">
			<table id="allAds" class="table table-striped table-hover display">
				<thead>
					<tr><th>Title</th><th>Price</th></tr>
				</thead>
				<tbody>
					<c:forEach var="ad" items="${ads}">
						<tr onclick="document.location='advert?id=${ad.adv_id}';">
							<td><a href="advert?id=${ad.adv_id}"><c:out value="${ad.title}"/></a></td>
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
