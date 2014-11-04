<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="base" tagdir="/WEB-INF/tags" %>


<base:page title="Map">
	<jsp:attribute name="customHead">
		<script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?sensor=false"></script>
		<script type="text/javascript" src="js/map.js"></script>
	</jsp:attribute>
	
	<jsp:body>
		<h1>Temporary Map Page</h1>
		
		
		<div id="map_canvas"></div>
		<div>
	    	<input id="address" type="textbox" value="Sydney, NSW">
	    	<input type="button" value="Encode" onclick="codeAddress()">
	    	<input id="latlng" type="textbox" value="46.9520921, 7.4374421">
	    	<input type="button" value="Encode" onclick="codeLatLng()">
 		</div>
		
		<script type="text/javascript">
			initialize();
		</script>
	</jsp:body>

</base:page>

