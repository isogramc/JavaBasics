// Declare form-field inputs as a variable and use a javascript selector
// that selects for elements using their class

var $formInputs=$('.form-card-fields input');
var $formLabels=$('.form-card-fields label');

$(document).ready(function(){

// Set selected fields as disabled when the page loads
	$formInputs.attr('disabled', true);
	$formLabels.addClass('is-disabled');
});
	
 $('input[type=radio][name=payment-methods]').change(function(){
                                                     
// On changing the radio button selection, toggle disabled/enabled
// according to requirements/specification
			if ($('#cash').is(':checked')){
					$formInputs.attr('disabled', true);
					$formLabels.addClass('is-disabled');
			}else{
					$formInputs.attr('disabled', false);
					$formLabels.removeClass('is-disabled');
			}
});
