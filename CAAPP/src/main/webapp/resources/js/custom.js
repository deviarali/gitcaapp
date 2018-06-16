window.onscroll = function() {myFunction()};
	
	var navbar = document.getElementById("sticky-div");
	var stickyIcon = document.getElementById("icon-people");
	var sticky = navbar.offsetTop;
	
	function myFunction() {
	  if (window.pageYOffset >= sticky) {
	    navbar.classList.add("sticky");
	    navbar.classList.add("black-blue")
	    
	    $(".quick-actions i").hide();
	    
	  } else {
	    navbar.classList.remove("sticky");
	    navbar.classList.remove("black-blue");
	    $(".quick-actions i").show();
	  }
	}