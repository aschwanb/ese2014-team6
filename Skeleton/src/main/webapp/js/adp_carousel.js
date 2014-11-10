jQuery(document).ready(function($) {
	$('#myCarousel').carousel({
		interval: 0
	});
	 
	$('#carousel-text').html($('#slide-content-0').html());
	 
	//Handles the carousel thumbnails
	$('[id^=carousel-selector-]').click( function(){
		var id_selector = $(this).attr("id");
		var id = id_selector.substr(id_selector.length -1);
		var id = parseInt(id);
		$('#myCarousel').carousel(id);
	});
	 
	// When the carousel slides, auto update the text
	$('#myCarousel').on('slid.bs.carousel', function (e) {
		var id = $('.item.active').data('slide-number');
		$('#carousel-text').html($('#slide-content-'+id).html());
	});	
});

var actionCount = 0;
var imgCount = 0;

function setImgCount(num)
{
	imgCount = num;
}

function createUpload(state, number)
{
	var container = document.createElement("div");
	container.setAttribute("id", "uploadBatch" + actionCount);
	
	var file = document.createElement("input");
	file.setAttribute("type", "file");
	file.setAttribute("name", "imgFile[" + actionCount + "]");
	container.appendChild(file);
	
	var desc = document.createElement("textarea");
	desc.setAttribute("name", "imgDescription[" + actionCount + "]");
	container.appendChild(desc);
	
	var sta = document.createElement("input");
	sta.setAttribute("type", "text");
	sta.setAttribute("name", "imgState[" + actionCount + "]");
	sta.value = state;
	sta.setAttribute("hidden","hidden");
	container.appendChild(sta);
	
	var num = document.createElement("input");
	num.setAttribute("type", "text");
	num.setAttribute("name", "imgNumber[" + actionCount + "]");
	num.value = number;
	num.setAttribute("hidden","hidden");
	container.appendChild(num);
	
	actionCount++;
	
	return container;
}

function makePic(num)
{
	var div = document.createElement("div");
	div.className = "item";
	div.setAttribute("data-slide-number", num);
	div.innerHTML = '<img class="center-block" src="">';
	
	document.getElementById('carousel-inner').appendChild(div);
}

function makeInfo(num)
{
	var div = document.createElement("div");
	div.setAttribute("id", "slide-content-" + num);
	div.innerHTML = '<p class="sub-text"></p><p class="sub-text"><a class="btn btn-lg btn-default" onclick="replaceImage(' + num + ')">Change Picture</a></p><p class="picnumholder" hidden="hidden">0</p>';
	
	document.getElementById('slide-content').appendChild(div);
}

function makeThumbnail(num)
{
	var div = document.createElement("li");
	div.className = "col-sm-2";
	div.innerHTML = '<a class="thumbnail" id="carousel-selector-' + num + '"><img src=""></a>';
	
	document.getElementById('hide-bullets').appendChild(div);
}

function addImage()
{
	imgCount++;
	
	makePic(imgCount);
	makeInfo(imgCount);
	makeThumbnail(imgCount);
	
	var container = createUpload('new', 0);
	
	var child = document.createElement("a");
	child.innerHTML = "Add";
	child.className = "btn btn-lg btn-default";
	child.setAttribute("onclick", "setImage(" + (actionCount - 1) + ", " + imgCount + ")");
	
	//$('.addFuncElements').hide();
	
	container.appendChild(child);
	
	document.getElementById('uploadContainer').appendChild(container);
}

function replaceImage(carousselindex)
{
	
}

function setImage(actionid, imgid)
{
	var ubatch = document.getElementById("uploadBatch" + actionid);
	var img = document.querySelector('[data-slide-number="' + imgid + '"]').firstChild;
	var thumb = document.getElementById("carousel-selector-" + imgid).firstChild;
	var desc = document.getElementById("slide-content-" + imgid).getElementsByTagName('p')[0];
	
	// read img and display
	var f = ubatch.querySelector('[name="imgFile[' + actionid + ']"]').files[0];
	
	var reader = new FileReader();
    // Closure to capture the file information.
    reader.onload = (function(theFile) {
      return function(e) {
    	  img.setAttribute("src", e.target.result);
    	  thumb.setAttribute("src", e.target.result);
      };
    })(f);
    // Read in the image file as a data URL.
    reader.readAsDataURL(f);
    
    // display text
    desc.innerHTML = ubatch.getElementsByTagName('textarea')[0].value;
    
    // update carousel
    var id = $('.item.active').data('slide-number');
    $('#carousel-text').html($('#slide-content-'+id).html());
    
    // hide uploadbatch
    ubatch.setAttribute("hidden", "hidden");
}

function removeImage()
{
	
}