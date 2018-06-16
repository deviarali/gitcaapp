<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- Import Top Body -->
<jsp:include page="/import_top_body.jsp"></jsp:include>
<jsp:include page="/nav_bar.jsp"></jsp:include>

<style type="text/css">
table thead {
	background: #777;
}

table thead tr th {
	color: #FFF !important;
	font-size: 14px !important;
}
</style>

	<div id="content" style="min-height: 646px;">
		
		<jsp:include page="/sticky_nav_bar.jsp"></jsp:include>

		<div class="container-fluid">
			<div class="row-fluid">
		
				<div class="span3">
					<c:if test="${isAdmin}">
						<div class="widget-box">
							<div class="widget-title" align="center">
								<span class="icon"> <i class="icon-th"></i>
								</span>
								<h5>Admin Management</h5>
							</div>
							<div class="widget-content">
								<div align="left" style="line-height: 1.6">
									<a href="/caapp/applicationUser">Application User</a><br /> 
									<a href="/caapp/userRole">User Roles</a><br /> 
									<a href="/caapp/natureOfAssignment">Nature Of Assignments</a><br /> 
									<a href="/caapp/parameter">System Parameters</a><br /> 
									<!-- <a href="WWW.GST.GOV.IN">Important News (marquee)</a><br /> --> 
								</div>
							</div>
						</div>
					</c:if>
					<div class="widget-box">
						<div class="widget-title" align="center">
							<span class="icon"> <i class="icon-th"></i>
							</span>
							<h5>Important News</h5>
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
				<div class="span7">
					<div class="widget-box">
						<div class="widget-title">
							<span class="icon"> <i class="icon-th"></i>
							</span>
							<h5>NEW CLINET ADDED TO SANJAY K & CO</h5>
						</div>
						<div class="widget-content nopadding">

							<div>
								<div class="span12">
									<div class="span10"></div>
									<div class="span2" align="right" style="padding: 10px">
										<br /> <a href="/caapp/client/clientRegistrationView" class="btn btn-primary" title="Register New Client"> Add Client</a>
									</div>
								</div>
							</div>
							<div style="height: 70px;"></div>
							<div>
								<table class="table table-bordered table-striped table-responsive">
									<thead style="background: #777;">
										<tr>
											<th>Client Name</th>
											<th>Company Status</th>
											<th>Created Date</th>
											<th></th>
											<th></th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${recentClients}" var="client">
											<tr>
												<td><c:out value="${client.custName}"></c:out></td>
												<td><c:out value="${client.companyStatus}"></c:out></td>
												<td><fmt:formatDate pattern="MM/dd/yyyy" value="${client.custCreatedDate}" /></td>
												<td style="text-align: center;"><a href="/caapp/client/${client.clientId}"><i class="fa fa-edit" style="font-size: 28px; color: blue;"></i></a></td>
												<td style="text-align: center;"><a href="/caapp/client/delete/${client.clientId}" class="confirmation"><i class="fa fa-trash" style="font-size: 28px; color: red"></i></a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>

						</div>
					</div>
				</div>
		
				<jsp:include page="/right_col.jsp"></jsp:include>

				<div class="span10">
					<marquee>
						<div class="span4" align="center">
							<p style="color: #000000">Arise, awake and stop not till the goal is reached.</p>
							<p style="color: #777">By Swami Vivekananda</p>
						</div>
					</marquee>
				</div>
			</div>
		</div>
	</div>

<!-- Import Bottom Body -->
<jsp:include page="import_js.jsp"></jsp:include>


	<script type="text/javascript">
  // This function is called from the pop-up menus to transfer to
  // a different page. Ignore if the value returned is a null string:
  function goPage (newURL) {

      // if url is empty, skip the menu dividers and reset the menu selection to default
      if (newURL != "") {
      
          // if url is "-", it is this page -- reset the menu:
          if (newURL == "-" ) {
              resetMenu();            
          } 
          // else, send page to designated URL            
          else {  
            document.location.href = newURL;
          }
      }
  }

// resets the menu selection upon entry to this page:
function resetMenu() {
   document.gomenu.selector.selectedIndex = 2;
}
</script>
<!-- Import Bottom Body -->
<jsp:include page="import_bottom_body.jsp"></jsp:include>
