var geocoder;
var map;
var marker;


function initialize()
{
	geocoder = new google.maps.Geocoder();
	var latlng = new google.maps.LatLng(46.9520921, 7.4374421);
	var myOptions = {
		zoom : 13,
		center : latlng,
		mapTypeId : google.maps.MapTypeId.ROADMAP
	};
	map = new google.maps.Map(document.getElementById("map_canvas"),
			myOptions);

	marker = new google.maps.Marker({
		position : latlng,
		map : map,
		title : "Bern!",
		draggable : true
	});
	
	google.maps.event.addListener(marker, 'drag', function(event) {
		document.getElementById("latlng").value = event.latLng.toString().replace('(', '').replace(')', '');
	});

	google.maps.event.addListener(marker, 'dragend', function(event) {
		document.getElementById("latlng").value = event.latLng.toString().replace('(', '').replace(')', '');
		codeLatLng('kein zoom');
	});
	
	// Reset button:
	var controlDiv = document.createElement('div');
	controlDiv.innerHTML = '<div ><div class="mapButton mapButton-right" title="Click to set the marker to the center of the map.">Reset Marker</div></div>';
	controlDiv.className = 'gmnoprint';
	
	// Setup the click event listeners: simply set the map to Chicago.
	google.maps.event.addDomListener(controlDiv.firstChild.firstChild, 'click', function() {
		document.getElementById("latlng").value = map.getCenter().toString()
				.replace('(', '').replace(')', '');
		codeLatLng('kein zoom');
	});
	
	controlDiv.index = 1;
	map.controls[google.maps.ControlPosition.TOP_RIGHT].push(controlDiv);
	
	// Center on Marker button:
	controlDiv = document.createElement('div');
	controlDiv.innerHTML = '<div ><div class="mapButton mapButton-left" title="Click to center the map on the position of the marker.">Go to Marker</div></div>';
	controlDiv.className = 'gmnoprint';
	
	// Setup the click event listeners: simply set the map to Chicago.
	google.maps.event.addDomListener(controlDiv.firstChild.firstChild, 'click', function() {
		map.setCenter(marker.getPosition());
	});
	
	controlDiv.index = 1;
	map.controls[google.maps.ControlPosition.TOP_RIGHT].push(controlDiv);
	
	
}

function lockMarker()
{
	marker.setDraggable(false);
}

google.maps.event.addDomListener(window, 'load', initialize);
google.maps.event.addDomListener(document.getElementById("map_canvas"), "resize",
									function() {
										var center = map.getCenter();
										google.maps.event.trigger(map, "resize");
										map.setCenter(center); 
									});


function decodeAddress(results)
{
	var strNum;
	var route;
	var local;
	var postCode;
	
	for(var i = 0; i < results[0].address_components.length; i++)
	{
		var ac = results[0].address_components[i];

		if(ac.types.indexOf("street_number") >= 0)
		{
			strNum = ac.long_name;
		}
		if(ac.types.indexOf("route") >= 0)
		{
			route = ac.long_name;
		}
		if(ac.types.indexOf("locality") >= 0)
		{
			local = ac.long_name;
		}
		if(ac.types.indexOf("postal_code") >= 0)
		{
			postCode = ac.long_name;
		}
	}
	
	document.getElementById("field-street").value = route + " " + strNum;
	document.getElementById("field-plz").value = postCode;
	document.getElementById("field-city").value = local;
}

function codeAddress(zoom)
{
	var address = document.getElementById("field-street").value + " " + 
				  document.getElementById("field-plz").value + " " + 
				  document.getElementById("field-city").value;
	geocoder.geocode({'address' : address},
					function(results, status) {
						if (status == google.maps.GeocoderStatus.OK) {
							if(!zoom)
							{
								map.setCenter(results[0].geometry.location);
								map.setZoom(16);
							}
							marker.setTitle(address);
							marker.setPosition(results[0].geometry.location);
							decodeAddress(results);
							document.getElementById("latlng").value = results[0].geometry.location.toString().replace('(', '').replace(')', '');
						} else {
							alert("Geocoder failed due to: " + status);
						}
					});
}


function codeLatLng(zoom) {
	var input = document.getElementById("latlng").value;
	var latlngStr = input.split(",", 2);
	var lat = parseFloat(latlngStr[0]);
	var lng = parseFloat(latlngStr[1]);
	var latlng = new google.maps.LatLng(lat, lng);
	geocoder.geocode({'latLng' : latlng},
					function(results, status) {
						if (status == google.maps.GeocoderStatus.OK) {
							if (results[1]) {
								if(!zoom)
								{
									map.setCenter(latlng);
									map.setZoom(16);
								}
								marker.setPosition(latlng);
								marker.setTitle();
								decodeAddress(results);
							}
						} else {
							alert("Geocoder failed due to: " + status);
						}
					});
}
