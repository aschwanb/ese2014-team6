function setAlert()
{
	alert("1");
	$.post("setalert", $('form#searchForm').serialize())
		.done(function(data){
			if(data.trim() == "success")
			{
				alert("a");
				addAlert("success", "Alert set.");
			}else
			{
				alert("b");
				addAlert("danger", "Setting alert failed.");
			}
		})
		.failed(function(){
			alert("c");
			addAlert("danger", "Setting alert failed. XMLHTTPRequest not successful.");
		});
	alert("2");
}