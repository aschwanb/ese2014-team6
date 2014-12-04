function setBookmark(id)
{
	$.get("bookmark", {id: id})
		.done(function(data){
			if(data.trim() == "success")
			{
				addAlert("success", "Ad bookmarked.");
			}else if(data.trim() == "already")
			{
				addAlert("warning", "Advert is already bookmarked.");
			}else
			{
				addAlert("danger", "Bookmarking failed: " + data);
			}
		})
		.fail(function(){
			addAlert("danger", "Bookmarking failed. XMLHTTPRequest not successful.");
		});
}

function showInterest(id)
{
	$.get("showinterest", {id: id})
		.done(function(data){
			if(data.trim() == "success")
			{
				addAlert("success", "Interest in ad declared.");
			}else if(data.trim() == "already")
			{
				addAlert("warning", "Interest in Ad is already declared.");
			}else
			{
				addAlert("danger", "Showing interest failed: " + data);
			}
		})
		.fail(function(){
			addAlert("danger", "Showing interest failed. XMLHTTPRequest not successful.");
		});
}