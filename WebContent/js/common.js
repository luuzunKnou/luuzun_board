function checkInputEmpty($obj){
	var count = 0;
	$obj.each(function(i, element){
		if( $(element).val() == ""){
			var $next = $(element).next(".errorMsg");
			$next.css("display","block");
			count++;
		}	
	});

	if(count > 0){
		return false;
	}

	return true; 
}
