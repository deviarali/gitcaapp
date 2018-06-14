<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>DEV</title>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="/css/bootstrap.min.css" />
<link rel="stylesheet" href="/css/bootstrap-responsive.min.css" />
<link rel="stylesheet" href="/css/fullcalendar.css" />
<link rel="stylesheet" href="/css/maruti-style.css" />
<link rel="stylesheet" href="/css/maruti-media.css" class="skin-color" />
<link rel="stylesheet" href="/css/uniform.css" />

<!-- Added -->
<link rel="stylesheet" href="css/select2.css" />
</head>
<body>

	<!--Header-part-->
	<div id="header">
		<!--h1>Ajahsma</h1 -->
		<div style="color: #ffffff; padding: 0 0 0 20px;">
			<h3>SANJAY K & CO.</h3>
			<h5 style="margin-top: -15px;">CHARTERED ACCOUNTANT</h5>
		</div>
	</div>
	<!--close-Header-part-->

	<!--top-Header-messaages-->
	<div class="btn-group rightzero">
		<a class="top_message tip-left" title="Manage Files"><i class="icon-file"></i></a> <a class="top_message tip-bottom" title="Manage Users"><i class="icon-user"></i></a> <a class="top_message tip-bottom" title="Manage Comments"><i
			class="icon-comment"></i><span class="label label-important">5</span></a> <a class="top_message tip-bottom" title="Manage Orders"><i class="icon-shopping-cart"></i></a>
	</div>
	<!--close-top-Header-messaages-->

	<!--top-Header-menu-->
	<div id="search">
		<input type="text" placeholder="Search here..." />
		<button type="submit" class="tip-left" title="Search">
			<i class="icon-search icon-white"></i>
		</button>
	</div>
	<!--close-top-Header-menu-->

	<div id="sidebar">
		<h4 align="center">SANJAY K & CO, CHARTERED ACCOUNTANT</h4>
	</div>


	<div id="content" style="min-height: 646px;">
		<div id="content-header">
			<div id="breadcrumb">
				<a href="login.html" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Login </a>
			</div>
		</div>
		<div class="container-fluid">
			<div>
				<div class="container-fluid">
					<div class="row-fluid">

						<div class="span3">
							<div class="widget-box">
								<div class="widget-title">
									<p>Important News</p>
								</div>
								<div class="widget-content">
									<div align="left">
										<h5>1. GST</h5>
										<h5>2. INCOME TAX</h5>
										<h5>3. ESI/EPF/PT</h5>
										<h5>4. OFFICE</h5>
										<h5>5. ROC</h5>
									</div>
								</div>
							</div>
						</div>

						<div class="span3">
							<div class="widget-box">
								<div class="widget-title">
									<p>Important Links</p>
								</div>
								<div class="widget-content">
									<div align="left">
										<a href="WWW.GST.GOV.IN">WWW.GST.GOV.IN</a><br /> <a href="WWW.ICAI.ORG">WWW.ICAI.ORG</a><br /> <a href="WWW.MCA.GOV.IN">WWW.MCA.GOV.IN</a><br /> <a href="WWW.PT.KAR.NIC.IN">WWW.PT.KAR.NIC.IN</a><br /> <a href="WWW.ESI">WWW.ESI</a><br /> <a
											href="WWW.EPF">WWW.EPF</a><br /> <a href="WWW. S & E">WWW. S & E</a><br /> <a href="WWW.RBI.ORG">WWW.GST.GOV.IN</a><br /> <a href="WWW.HDFCBANK.OCM">WWW.HDFCBANK.OCM</a><br />
									</div>
								</div>
							</div>
						</div>

						<div class="span6">
							<div class="widget-box">
								<div class="widget-title">
									<p align="center">Login</p>
								</div>
								<div class="widget-content nopadding">
									<!-- Login Form -->
									<c:url value="/login" var="loginVar"/>
									<form class="form-horizontal" action="${loginVar}" method="POST">
										<div class="control-group">
											<label class="control-label">User Name :</label>
											<div class="controls">
												<input id="userName" type="text" class="span6" name="userName" required="" />
											</div>
										</div>
										<div class="control-group">
											<label class="control-label">password :</label>
											<div class="controls">
												<input id="password" type="password" class="span6" name="password" required="" />
											</div>
										</div>
										<sec:csrfInput />

										<div class="control-group">
											<div class="controls">
												<c:if test="${param.logout != null }">
													<p class="control-label" style="display: contents;color: red;">You have successfully been logged out.</p>
												</c:if>
						
												<c:if test="${param.error != null }">
													<p  class=" control-label" style="display: contents;color: red;">Invalid Username and Password.</p>
												</c:if>
											</div>
										</div>
						
										<div class="control-group">
											<div class="controls">
												<label><input id="rememberMe" type="checkbox"> Remember me</label> <input id="loginBtn" type="submit" class="span5 btn btn-primary" value="Login" />
											</div>
										</div>
									</form>
										

								</div>
							</div>
						</div>

					</div>
					<hr>

				</div>
			</div>
		</div>	
	</div>
	<div class="row-fluid">
		<div id="footer" class="span12">
			2018 &copy; AJAHSMA. Brought to you by <a href="http://Ajahsma.in">Ajahsma.in</a>
		</div>
	</div>
	<script src="/js/jquery.min.js"></script>
	<script src="/js/jquery.ui.custom.js"></script>
	<script src="/js/bootstrap.min.js"></script>
	<script src="/js/bootstrap-colorpicker.js"></script>
	<script src="/js/bootstrap-datepicker.js"></script>
	<script src="/js/jquery.uniform.js"></script>
	<script src="/js/select2.min.js"></script>
	<script src="/js/maruti.js"></script>
	<script src="/js/maruti.form_common.js"></script>
	
<script>
$(document).ready(function(){

 	if (localStorage.chkbx && localStorage.chkbx != '') {
          $('#rememberMe').attr('checked', 'checked');
          $('#userName').val(localStorage.usrname);
          $('#password').val(localStorage.pass);
      } else {
          $('#rememberMe').removeAttr('checked');
          $('#userName').val('');
          $('#password').val('');
      }
	$("#loginBtn").click(function() {
		if ($('#rememberMe').is(':checked')) {
             // save username and password
             
             localStorage.usrname = $('#userName').val();
             localStorage.pass = $('#password').val();
             localStorage.rememberMe = $('#rememberMe').val();
         } else {
             localStorage.usrname = '';
             localStorage.pass = '';
             localStorage.rememberMe = '';
         }
		
	});

	});
</script>	
	
</body>
</html>
