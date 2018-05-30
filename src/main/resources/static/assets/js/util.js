$( ".form_input" ).keyup(function(e) {
    if (_.isEmpty($('#'+e.target.id).val().trim())){
    	$('#'+e.target.id).addClass('input_error');
    }
    else{
    	$('#'+e.target.id).removeClass('input_error');
    }
});