function setBookmark(id)
{
	$.get("bookmark", {id: id})
		.done(function(data){
			alert("'" + data + "'\nTrimmed: '" + data.trim() + "'");
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
		.failed(function(){
			addAlert("danger", "Bookmarking failed.");
		});
}