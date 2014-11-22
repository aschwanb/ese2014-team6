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
							new google.maps.Marker({
								position : new google.maps.LatLng(lat, lng),
								map : map,
								title : "${ad.title}",
								draggable : false
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
			</div>
		</div>
	</jsp:body>
</base:page>
<script>
$(document).ready(function(){
    $('#allAds').dataTable();
});
</script>
