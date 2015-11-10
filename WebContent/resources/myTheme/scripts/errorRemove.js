$(document).ready(function(){
	$('#loginFormForAjax').submit(function() {
		$.ajax({
			url: '/TodoApp/login',
			type: 'POST',
			dataType: 'json',
			data: $('#loginFormForAjax').serialize(),
			success: function(data) {
				if (data.isValid) {
					 $(location).attr('href',"/TodoApp/"); 
				} else {
					$(location).attr('href',"/TodoApp/"); 
					$('#login-form').animate({left: "-1%"} ,500, function() {
						$('#login-form').animate({right: "-2%"}, 500);
					});
				}
			} 
		});
		return false;
	});
});