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
		<script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?sensor=false"></script>
	</jsp:attribute>
	
	<jsp:attribute name="page_header">
		<h1>Welcome to StudiHome</h1>
	</jsp:attribute>
	
	<jsp:body>
		<h2>Start looking for your home today</h2>
		
		<ul class="nav nav-tabs" role="tablist">
			<li class="active"><a href="#index-map" role="tab" data-toggle="tab">Map</a></li>
			<li><a href="#index-list" role="tab" data-toggle="tab">List</a></li>
		</ul>
		
		<!-- Tab panes -->
		<div class="tab-content">
			<div class="tab-pane fade in active" id="index-map">
				<script type="text/javascript">
					function initialize()
					{
						var myOptions = {
							zoom : 13,
							center : new google.maps.LatLng(46.9520921, 7.4374421),
							mapTypeId : google.maps.MapTypeId.ROADMAP
						};
						map = new google.maps.Map(document.getElementById("map_canvas"),
								myOptions);
						
						<c:forEach var="ad" items="${ads}">
							var input = "${ad.address.coordinate}";
							var latlngStr = input.split(",", 2);
							var lat = parseFloat(latlngStr[0]);
							var lng = parseFloat(latlngStr[1]);
							
							var contentString = 
								'<div class="info-window-content">'+
								'<b>${ad.title}</b><br/>'+
								'${ad.address.street} ${ad.address.plz} ${ad.address.city}<br/>'+
								'${ad.numberOfRooms} room '+
								'${(ad.isWG == true)?("shared flat"):("single apartment")} '+
								'(${ad.appartementSize} &#13217;)<br/>'+
								'Rent: ${ad.price} Fr.'+
								'</div>';
							var infowindow = new google.maps.InfoWindow({
								content: contentString
							});
							
							var marker = new google.maps.Marker({
								position : new google.maps.LatLng(lat, lng),
								map : map,
								//title : "${ad.title}",
								draggable : false
							});
							google.maps.event.addListener(marker, 'click', function() {
								window.location.href = "advert?id=${ad.advId}";
							});
							google.maps.event.addListener(marker, 'mouseover', function() {
								infowindow.open(map, marker);
							});
							google.maps.event.addListener(marker, 'mouseout', function() {
								infowindow.close();
							});
						</c:forEach>
					}
					google.maps.event.addDomListener(window, 'load', initialize);
					google.maps.event.addDomListener(document.getElementById("map_canvas"), "resize",
														function() {
															var center = map.getCenter();
															google.maps.event.trigger(map, "resize");
															map.setCenter(center); 
														});
				</script>
				<div id="map_canvas"></div>
			</div>
			<div class="tab-pane fade" id="index-list">
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
								<tr onclick="document.location='advert?id=${ad.advId}';">
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
						</tbody>
					</table>
				</c:if>
			</div>
		</div>
		
	</jsp:body>
</base:page>

