<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
		
				<%-- <jsp:include page="/left_col.jsp"></jsp:include> --%>
				<div class="span1"></div>

				<div class="span10">
					<div class="widget-box">
						<div class="widget-title" align="center">
							<span class="icon"> <i class="icon-th"></i>
							</span>
							<h5>Application User Management</h5>
						</div>
						<div class="widget-content nopadding">
							<div>
								<div class="span12">
									<div class="span10"></div>
									<div class="span2">
										<br /> <a href="/caapp/applicationUser/createApplicationUser" class="btn btn-primary" title="Register New Employee"> Add User</a>
									</div>
								</div>
							</div>
							<div style="height: 70px;"></div>
							<div>
								<table class="table table-bordered table-striped table-responsive">
									<thead style="background: #777;">
										<tr>
											<th>User Name</th>
											<th>Active</th>
											<th>Roles</th>
											<th></th>
											<th></th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${applicationUsers}" var="applicationUserVar">
											<tr>
												<td><c:out value="${applicationUserVar.userName}"></c:out></td>
												<td>
													<input type="checkbox" disabled="disabled" <c:if test="${applicationUserVar.isActive}">checked="checked"</c:if>  />
												</td>
												<td>
													<c:forEach items="${applicationUserVar.userRoleDtos}" var="userRole">
														<c:out value="${userRole.roleName}, "></c:out>
													</c:forEach>
												</td>
												<td style="text-align: center;"><a href="/caapp/applicationUser/${applicationUserVar.id}"><i class="fa fa-edit" style="font-size: 28px; color: blue;"></i></a></td>
												<td style="text-align: center;"><a href="/caapp/applicationUser/delete/${applicationUserVar.id}" class="confirmation"><i class="fa fa-trash" style="font-size: 28px; color: red"></i></a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>

						</div>
					</div>
				</div>
		
				<%-- <jsp:include page="/right_col.jsp"></jsp:include> --%>
				<div class="span1"></div>
				
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
