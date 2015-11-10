$(document).ready(function(){
	$('div.sidebarYourTodo').addClass('active');
	
	$('.delete').click(function(){
		$.ajax({
			url: '/TodoApp/delete',
			type: 'POST', 
			data: $(this).parent().children(':first-child').serialize(),
			success: function(data) {
				
			}
		});
		return false;
	});
	
	
//	$.ajax({
//		url: '/TodoApp/yourTodo',
//		type: 'GET',
//		data: 'hello'.serialize(),
//		dataType: 'json',
//		success: function(data) {
//			if (data.user != null) {
//				$('#jsonList').html(function() {
//					$('#jsonList').empty();
//					for (var i = 0; i < data.todo.length; i++) {
//						$('#jsonList').append('<div class = jsonTodo> '+data.todo[i].description+' </div>');
//					}
//				});
//				$('#todoAddInput').val('');
//			}
//		}
//	});

});