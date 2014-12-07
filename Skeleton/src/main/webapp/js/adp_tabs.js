jQuery(document).ready(function($) {
	var navListItems = $('div.setup-panel div a'),
		allWells = $('.setup-content'),
		allNextBtn = $('.nextBtn'),
		allPrevBtn = $('.prevBtn');
	
	allWells.hide();
	
	navListItems.click(function (e) {
		e.preventDefault();
		var $target = $($(this).attr('href')),
	    	$item = $(this);
	
		if (!$item.hasClass('disabled')) {
			navListItems.removeClass('btn-primary').addClass('btn-default');
			$item.addClass('btn-primary');
			$item.trigger('blur');
			allWells.hide();
			$target.show();
			//$target.find('textarea:eq(0)').focus();
			$target.find('input:eq(0)').focus();
			(document.getElementById("map_canvas").dispatchEvent||document.getElementById("map_canvas").fireEvent)(new Event("resize"))	//fugly but needed
	    }
	});
	
	allNextBtn.click(function(){
	    var curStep = $(this).closest(".setup-content"),
	    	curStepBtn = curStep.attr("id"),
	    	nextStepWizard = $('div.setup-panel div a[href="#' + curStepBtn + '"]').parent().next().children("a"),
	    	//afternextStepWizard = $('div.setup-panel div a[href="#' + curStepBtn + '"]').parent().next().next().children("a"),
	    	curInputs = curStep.find("input[type='text'],input[type='url']"),
	    	isValid = true;
	    
	    $(".form-group").removeClass("has-error");
	    for(var i=0; i<curInputs.length; i++){
	    	if (!curInputs[i].validity.valid){
	    		isValid = false;
	    		$(curInputs[i]).closest(".form-group").addClass("has-error");
	    	}
	    }
	
	    if (isValid)
	    {
	    	nextStepWizard.removeAttr('disabled');
	    	nextStepWizard.trigger('click');
	    	if(nextStepWizard.attr("href") == "#pics")
	    	{
	    		$('.advert-buttongroupbutton').removeAttr('disabled');
	    	}
	    }
	});
	
	allPrevBtn.click(function(){
	    var curStep = $(this).closest(".setup-content"),
	    	curStepBtn = curStep.attr("id"),
	    	nextStepWizard = $('div.setup-panel div a[href="#' + curStepBtn + '"]').parent().prev().children("a"),
	    	curInputs = curStep.find("input[type='text'],input[type='url']"),
	    	isValid = true;
	    
	    $(".form-group").removeClass("has-error");
	    for(var i=0; i<curInputs.length; i++){
	    	if (!curInputs[i].validity.valid){
	    		isValid = false;
	    		$(curInputs[i]).closest(".form-group").addClass("has-error");
	    	}
	    }
	
	    if (isValid)
	    	nextStepWizard.trigger('click');
	});
	
	$('div.setup-panel div a.btn-primary').trigger('click');
	
});
