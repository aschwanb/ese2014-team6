function setAlert()
{
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
		.fail(function(){
			addAlert("danger", "Setting alert failed. XMLHTTPRequest not successful.");
		});
}