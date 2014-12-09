function sendAdvertForm()
{
	$.post("advert", $('form#adForm').serialize())
		.done(function(data){
			if(data.trim() == "success")
			{
				addAlert("success", "Ad saved.");
			}else if(data.trim() == "error")
			{
				addAlert("danger", "Advert upload failed. Error while saving advert to data base.");
			}else if(data.trim() == "denied")
			{
				addAlert("danger", "You don't have the permission to change this advert.");
			}else
			{
				addAlert("warning", "There are invalid inputs.");

				var cont = document.createElement("div");
				cont.innerHTML = data.trim();
				document.getElementById("infodiv").innerHTML = cont.querySelector("#infodiv").innerHTML;
			}
		})
		.fail(function(){
			addAlert("danger", "Advert upload failed. XMLHTTPRequest not successful.");
		});
}