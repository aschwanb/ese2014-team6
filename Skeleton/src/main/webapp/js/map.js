var geocoder;
var map;
var marker;

function HomeControl(controlDiv, map) {

	  // Set CSS styles for the DIV containing the control
	  // Setting padding to 5 px will offset the control
	  // from the edge of the map.
	  controlDiv.style.padding = '5px';

	  // Set CSS for the control border.
	  var controlUI = document.createElement('button');
	  controlUI.style.cursor = 'pointer';
	  controlUI.style.textAlign = 'center';
	  controlUI.title = 'Click to set the marker to the center of the map.';
	  controlUI.innerHTML = "Center marker"
	  controlDiv.appendChild(controlUI);

	  // Setup the click event listeners: simply set the map to Chicago.
	  google.maps.event.addDomListener(controlUI, 'click', function() {
		  document.getElementById("latlng").value = map.getCenter().toString().replace('(', '').replace(')', '');
		  codeLatLng();
	  });
	}


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
		codeLatLng();
	});
	
	// Create the DIV to hold the control and call the HomeControl() constructor
	  // passing in this DIV.
	  var homeControlDiv = document.createElement('div');
	  var homeControl = new HomeControl(homeControlDiv, map);

	  homeControlDiv.index = 1;
	  map.controls[google.maps.ControlPosition.TOP_RIGHT].push(homeControlDiv);

	
}

function codeAddress()
{
	var address = document.getElementById("address").value;
	geocoder.geocode({
		'address' : address
	}, function(results, status) {
		if (status == google.maps.GeocoderStatus.OK) {
			map.setCenter(results[0].geometry.location);
			map.setZoom(16);
			marker.setTitle(address);
			marker.setPosition(results[0].geometry.location);
			document.getElementById("address").value = results[0].formatted_address;
			document.getElementById("latlng").value = results[0].geometry.location.toString().replace('(', '').replace(')', '');
		} else {
			alert("Geocode was not successful for the following reason: "
					+ status);
		}
	});
}


function codeLatLng() {
	var input = document.getElementById("latlng").value;
	var latlngStr = input.split(",", 2);
	var lat = parseFloat(latlngStr[0]);
	var lng = parseFloat(latlngStr[1]);
	var latlng = new google.maps.LatLng(lat, lng);
	geocoder.geocode({'latLng' : latlng},
					function(results, status) {
						if (status == google.maps.GeocoderStatus.OK) {
							if (results[1]) {
								map.setCenter(latlng);
								map.setZoom(16);
								marker.setPosition(latlng);
								marker.setTitle();
								document.getElementById("address").value = results[0].formatted_address;
							}
						} else {
							alert("Geocoder failed due to: " + status);
						}
					});
}
