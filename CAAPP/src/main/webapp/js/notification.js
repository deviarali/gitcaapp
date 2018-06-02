$(document).ready(function(){
	var YOUR_MESSAGE_STRING_CONST = "Are you sure?";

      $('.confirmation').on('click', function(e){
			var requestPath = $(this).attr('href');
    		confirmDialog(YOUR_MESSAGE_STRING_CONST, requestPath, function(){
    			//My code to delete
				return true;
    		});
			return false;
    	});

        function confirmDialog(message, requestPath, onConfirm){
			
    		$("#confirmOk").attr('href', requestPath);
    	    var fClose = function(){
    			  modal.modal("hide");
    	    };
    	    var modal = $("#confirmModal");
    	    modal.modal("show");
    	    $("#confirmMessage").empty().append(message);
    	    $("#confirmOk").unbind().one('click', onConfirm).one('click', fClose);
    	    $("#confirmCancel").unbind().one("click", fClose);
        }
});		
