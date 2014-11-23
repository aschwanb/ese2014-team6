<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="base" tagdir="/WEB-INF/tags" %>


<base:page title="StudiHome">
	<jsp:attribute name="customHead">
		<link rel="stylesheet" type="text/css" href="css/jquery.dataTables.css">
		<script type="text/javascript" src="js/jquery.dataTables.js"></script>
		<script type="text/javascript" src="js/index_table.js"></script>
	</jsp:attribute>
	
	<jsp:attribute name="page_header">
		<h1>Welcome to StudiHome</h1>
	</jsp:attribute>
	
	<jsp:body>
		<h2>Start looking for your home today</h2>
		
		<c:if test="${not empty ads}">
			<table>
		        <tbody>
			        <tr>
			            <td>Minimum price:</td>
			            <td><input id="min_price" name="min_price" type="text"></td>
			        </tr>
			        <tr>
			            <td>Maximum price:</td>
			            <td><input id="max_price" name="max_price" type="text"></td>
			        </tr>
			        <tr>
			            <td>Minimum room size:</td>
			            <td><input id="min_room_size" name="min_room_size" type="text"></td>
			        </tr>
			        <tr>
			            <td>Maximum room size:</td>
			            <td><input id="max_room_size" name="max_room_size" type="text"></td>
			        </tr>
			        <tr>
			            <td>Minimum apartment size:</td>
			            <td><input id="min_apartment_size" name="min_apartment_size" type="text"></td>
			        </tr>
			        <tr>
			            <td>Maximum apartment size:</td>
			            <td><input id="max_apartment_size" name="max_apartment_size" type="text"></td>
			        </tr>
			        <tr>
			            <td>Minimum number of inhabitants:</td>
			            <td><input id="min_number_of_inhabitants" name="min_number_of_inhabitants" type="text"></td>
			        </tr>
			        <tr>
			            <td>Maximum number of inhabitants:</td>
			            <td><input id="max_number_of_inhabitants" name="max_number_of_inhabitants" type="text"></td>
			        </tr>
			        <tr>
			            <td>Area:</td>
			            <td><input id="area" name="area" type="text"></td>
			        </tr>
			        <tr>
			        	<td>Type Of Apartment</td>
			        	<td>
			        		<select id="type_of_apartment" name="type_of_apartment">
			        			<option>Shared Flat</option>
			        			<option>Single Apartment</option>
			        			<option selected="selected">All</option>
			        		</select>
			        	</td>
			        </tr>
		    	</tbody>
		    </table>
			<table id="allAds" class="display">
				<thead>
					<tr><th>Image</th><th>Title</th><th>Location</th><th>Price</th><th>Room Size</th><th>Apartment Size</th><th>Number Of Inhabitants</th><th>Type Of Apartment</th></tr>
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
							<td><a href="advert?id=${ad.adv_id}"><c:out value="${ad.roomSize}"/></a></td>
							<td><a href="advert?id=${ad.adv_id}"><c:out value="${ad.appartementSize}"/></a></td>
							<td><a href="advert?id=${ad.adv_id}"><c:out value="${ad.numberOfInhabitants}"/></a></td>
							<td><a href="advert?id=${ad.adv_id}"><c:out value="${ad.isWG?'Shared Flat':'Single Apartment'}"/></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</jsp:body>
</base:page>

