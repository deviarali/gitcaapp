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
						<p align="center">Employee Registration</p>
					</div>

					<div class="widget-content nopadding">
						<div style="padding-right: 300px">
							<form:form action="/caapp/employee/employeeRegister" method="post" modelAttribute="employee" class="form-horizontal">
							
							<form:hidden path="employeeId"/>
							<div class="control-group">
								<label class="control-label required">First Name :</label>
								<div class="controls">
									<form:input path="employeeName" class="span11" />
									<br>
									<form:errors class="errors" path="employeeName" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label required">Address :</label>
								<div class="controls">
									<form:input path="employeeAddress" class="span11" />
									<br>
									<form:errors class="errors" path="employeeAddress" />
								</div>
							</div>

							<div class="control-group">
								<label class="control-label required">Mobile Number</label>
								<div class="controls">
									<form:input path="employeeMobile" class="span11" />
									<br>
									<form:errors class="errors" path="employeeMobile" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label required">Email</label>
								<div class="controls">
									<form:input path="employeeEmail" class="span11" />
									<br>
									<form:errors class="errors" path="employeeEmail" />
								</div>
							</div>

							<div class="control-group">
								<label class="control-label required">Pan Num</label>
								<div class="controls">
									<form:input path="employeePan" class="span11" />
									<br>
									<form:errors class="errors" path="employeeMobile" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label required">Aadhar Num</label>
								<div class="controls">
									<form:input path="employeeAadhar" class="span11" />
									<br>
									<form:errors class="errors" path="employeeMobile" />
								</div>
							</div>

							<div class="control-group">
								<label class="control-label">Parents Address</label>
								<div class="controls">
									<form:textarea path="employeeParentAddress" class="span11" />
									<br>
									<form:errors class="errors" path="employeeParentAddress" />
								</div>
							</div>
							
							<div class="control-group">
								<label class="control-label"> Users </label>
								<div class="controls">
									<form:select name="users" class="span11" path="applicationUser.id">
										<form:option value="">-</form:option>
										<form:options items="${userList}" itemValue="id" itemLabel="userName" />
									</form:select>
									<br>
									<br>
									<form:errors path = "applicationUser.id" class="errors"/>
								</div>
							</div>

							<div class="control-group">
								<label class="control-label required">Date Of Joining</label>
								<div class="controls">
									<div data-date="19-11-1989" class="input-append date datepicker">
										<form:input path="employeeJoingDate" type="text" value="" data-date-format="dd-mm-yyyy" class="span11" />
										<span class="add-on"><i class="icon-th"></i></span>
									</div>
									<br>
									<form:errors class="errors" path="employeeJoingDate" />
									
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