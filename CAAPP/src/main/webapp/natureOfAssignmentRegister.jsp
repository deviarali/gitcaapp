<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Import Top Body -->
<jsp:include page="/import_top_body.jsp"></jsp:include>
<jsp:include page="/nav_bar.jsp"></jsp:include>

<div id="content" style="min-height: 646px;">
	<jsp:include page="/sticky_nav_bar.jsp"></jsp:include>

	<div class="container-fluid" >
		<div class="row-fluid">

			<%-- <jsp:include page="/left_col.jsp"></jsp:include> --%>
				<div class="span3">
						<jsp:include page="adminPanel.jsp"></jsp:include>
				</div>
				<div class="span7">
				<c:if test="${not empty msg }">
					<c:out value="${msg}"></c:out>
				</c:if>
				<div class="widget-box">
					<div class="widget-title" align="center">
						<span class="icon"> <i class="icon-th"></i>
						</span>
						<h5>Nature Of Assignment Registration</h5>
					</div>

					<div class="widget-content nopadding">
						<div style="padding-right: 300px">
							<form:form action="/caapp/natureOfAssignment/natureOfAssignmentRegister" method="post" modelAttribute="natureOfAssignment" class="form-horizontal">
							
							<form:hidden path="natureOfAssignmentId"/>
							<div class="control-group">
								<label class="control-label required">Name</label>
								<div class="controls">

									<c:choose>
										<c:when test="${natureOfAssignment.natureOfAssignmentId != null}">
											<c:out value="${natureOfAssignment.natureOfAssignmentName}"></c:out>
											<form:hidden path="natureOfAssignmentName"/>
										</c:when>
										<c:otherwise>
											<form:input path="natureOfAssignmentName" class="span11" 	/>
										</c:otherwise>
									</c:choose>
									<br>
									<form:errors class="errors" path="natureOfAssignmentName" />
								</div>
							</div>
							
							<div class="control-group">
								<label class="control-label required">Description</label>
								<div class="controls">
									<form:input path="description" class="span11"  />
									<br>
									<form:errors class="errors" path="description" />
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