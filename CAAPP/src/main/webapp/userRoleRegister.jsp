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
					<div class="widget-title" align="center">
						<span class="icon"> <i class="icon-th"></i>
						</span>
						<h5>User Role Registration</h5>
					</div>

					<div class="widget-content nopadding">
						<div style="padding-right: 300px">
							<form:form action="/caapp/userRole/userRoleRegister" method="post" modelAttribute="userRole" class="form-horizontal">
							
							<form:hidden path="id"/>
							<div class="control-group">
								<label class="control-label required">Role Name :</label>
								<div class="controls">
									<form:input path="roleName" class="span11"  />
									<br>
									<form:errors class="errors" path="roleName" />
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