function addAlert(type, message)
{
	var alertDiv = document.createElement('div');
	alertDiv.className="alert alert-" + type + " alert-dismissable";
	alertDiv.innerHTML='<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>' + message;
	
	document.getElementById("alertGroupPageTop").appendChild(alertDiv);
}
