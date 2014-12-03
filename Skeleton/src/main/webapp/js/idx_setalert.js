function setAlert()
{
	alert("1");
	$.post("setalert", $('form#searchForm').serialize())
		.done(function(data){
			if(data.trim() == "success")
			{
				addAlert("success", "Alert set.");
			}else
			{
				addAlert("danger", "Setting alert failed.");
			}
		})
		.failed(function(){
			addAlert("danger", "Setting alert failed. XMLHTTPRequest not successful.");
		});
	alert("2");
}