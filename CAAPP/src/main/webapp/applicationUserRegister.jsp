<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Import Top Body -->
<jsp:include page="/import_top_body.jsp"></jsp:include>
<jsp:include page="/nav_bar.jsp"></jsp:include>

>
<div id="content">

	<jsp:include page="/sticky_nav_bar.jsp"></jsp:include>

	<div class="container-fluid" >
		<div class="row-fluid">

			<%-- <jsp:include page="/left_col.jsp"></jsp:include> --%>
			<div class="span1"></div>
			<div class="span10">
				<c:if test="${not empty msg }">
					<c:out value="${msg}"></c:out>
				</c:if>
				<div class="widget-box">
					<div class="widget-title">
						<p align="center">Application User Registration</p>
					</div>

					<div class="widget-content nopadding">
						<div style="padding-right: 300px">
							<form:form action="/caapp/applicationUser/applicationUserRegister" method="post" modelAttribute="applicationUser" class="form-horizontal">
							
							<form:hidden path="id"/>
							<div class="control-group">
								<label class="control-label required">User Name :</label>
								<div class="controls">
									<form:input path="userName" class="span11"  />
									<br>
									<form:errors class="errors" path="userName" />
								</div>
							</div>
							
							<div class="control-group">
								<label class="control-label required">Password :</label>
								<div class="controls">
									<form:password path="password" class="span11" />
									<br>
									<form:errors class="errors" path="password" />
								</div>
							</div>

							<div class="control-group">
								<label class="control-label required">Is Active</label>
								<div class="controls">
									<form:checkbox path="isActive"/>
									<br>
									<form:errors class="errors" path="isActive" />
								</div>
							</div>
							
							<div class="control-group">
								<label class="control-label required">Roles</label>
								<div class="controls" align="left">
									<c:forEach items="${userRoleList}" var="role" varStatus="status">
										<span style="line-height: 3"> <form:checkbox path="userRoles" value="${role.id}" /><c:out value="${role.roleName} " /> &nbsp; &nbsp; 
										</span>
										
										<c:if test="${(status.index + 1) % 4 == '0'}">
											<br>
										</c:if>
									</c:forEach>
									<form:errors class="errors" path="userRoles" />
								</div>
							</div>
							<div class="form-actions" style="background-color: #ffffff; border: none;">
								<button type="submit" class="btn btn-success">Save</button>
								<button type="reset" class="btn btn-primary">Reset</button>
								<!-- <button type="submit" class="btn btn-danger">Cancel</button> -->
							</div>
						</form:form>
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

<!-- Import Bottom Body -->
<jsp:include page="import_bottom_body.jsp"></jsp:include>