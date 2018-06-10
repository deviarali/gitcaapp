<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<sec:authentication var="user" property="principal" />
<!--Header-part-->
<div id="header">
  <!--h1>Ajahsma</h1 -->
  <div style="color: #ffffff;padding: 0 0 0 20px;">
	  <h3>SANJAY K & CO.</h3>
	  <h5 style="margin-top: -15px;">CHARTERED ACCOUNTANT</h5>
  </div>
</div>
<!--close-Header-part--> 

<!--top-Header-messaages-->
<div class="btn-group rightzero"> <a class="top_message tip-left" title="Manage Files"><i class="icon-file"></i></a> <a class="top_message tip-bottom" title="Manage Users"><i class="icon-user"></i></a> <a class="top_message tip-bottom" title="Manage Comments"><i class="icon-comment"></i><span class="label label-important">5</span></a> <a class="top_message tip-bottom" title="Manage Orders"><i class="icon-shopping-cart"></i></a> </div>
<!--close-top-Header-messaages--> 

<!--top-Header-menu-->
<div id="user-nav" class="navbar navbar-inverse">
	<ul class="nav">
		<li class=""><a href="/caapp/employee/${user.id}"><i class="icon icon-user"></i> <span class="text">Profile</span></a></li>
		<li class=" dropdown" id="menu-messages" style="display: none;"><a href="#" data-toggle="dropdown" data-target="#menu-messages" class="dropdown-toggle"><i class="icon icon-envelope"></i> <span class="text">Messages</span> <span class="label label-important">5</span>
				<b class="caret"></b></a>
			<ul class="dropdown-menu">
				<li><a class="sAdd" title="" href="#">new message</a></li>
				<li><a class="sInbox" title="" href="#">inbox</a></li>
				<li><a class="sOutbox" title="" href="#">outbox</a></li>
				<li><a class="sTrash" title="" href="#">trash</a></li>
			</ul></li>
		<li class="" style="display: none;"><a title="" href="/caapp/employee/${employeeId}"> <span class="text">${user.userName}</span></a></li>
		<li class=""><a title="" href="/logout"><i class="icon icon-share-alt"></i> <span class="text">Logout ( ${user.userName} )</span></a></li>
	</ul>
</div>
<div id="search">
	<input type="text" placeholder="Search here..." style="height: 35px;"/>
	<button type="submit" class="tip-left" title="Search">
		<i class="icon-search icon-white"></i>
	</button>
</div>
<!--close-top-Header-menu-->

<div id="sidebar">
	<marquee>
		<div class="span4" align="center">
			<p style="color: #000000; padding-top: 5px;">GST: Due date is on 30th of this month.</p>
		</div>
	</marquee>
	
</div>
