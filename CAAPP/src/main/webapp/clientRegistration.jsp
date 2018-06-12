<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Import Top Body -->
<jsp:include page="/import_top_body.jsp"></jsp:include>
<jsp:include page="/nav_bar.jsp"></jsp:include>

<style type="text/css">

</style>

<div id="content">

	<jsp:include page="/sticky_nav_bar.jsp"></jsp:include>
	<div>
		<div class="container-fluid">
			<div class="row-fluid">

				<div class="span1"></div>
				<%-- <jsp:include page="/left_col.jsp"></jsp:include> --%>
				<div class="span10">
					<div class="widget-box">
						<div class="widget-title">
							<c:if test="${not empty successmsg }">
						          ${successmsg}
						          </c:if>

							<p align="center">Client Registration</p>
						</div>
						<div class="widget-content nopadding">
							<div style="padding-right: 100px">
								<form:form action="../client/clientRegister" method="post" class="form-horizontal" modelAttribute="clientRegistration">
									
									<form:hidden path="clientId"/>
									<div class="control-group">
										<label class="control-label required">First Name </label>
										<div class="controls">
											<form:input path="clientName" type="text" class="span11" />
											<br>
											<form:errors class="errors" path="clientName" />
										</div>
									</div>
									<div class="control-group">
										<label class="control-label required">Trade Name </label>
										<div class="controls">
											<form:input path="tradeName" type="text" class="span11" />
											<br>
											<form:errors class="errors" path="tradeName" />
										</div>
									</div>
									<div class="control-group">
										<label class="control-label required">Indidusual/Firm/Company </label>
										<div class="controls">
											<form:select type="text" class="form-control" path="companyStatusDto.companyStatusId">
												<form:option value="">-</form:option>
												<form:options items="${companyStatusDtos}" itemValue="companyStatusId" itemLabel="companyStatusName" />
											</form:select>
											<br>
											<form:errors class="errors" path="companyStatusDto.companyStatusId" />
										</div>
									</div>
									<div class="control-group">
										<label class="control-label required">Mobile Number</label>
										<div class="controls">
											<form:input path="clientMobile" type="text" class="span11" />
											<br>
											<form:errors class="errors" path="clientMobile" />
										</div>
									</div>
									<div class="control-group">
										<label class="control-label required">Email</label>
										<div class="controls">
											<form:input path="clientEmail" type="text" class="span11" />
											<br>
											<form:errors class="errors" path="clientEmail" />
										</div>
									</div>
									<div class="control-group">
										<label class="control-label">Pan Num</label>
										<div class="controls">
											<form:input path="panNumber" type="text" class="span11" />
											<br>
											<form:errors class="errors" path="panNumber" />
										</div>
									</div>
									<div class="control-group">
										<label class="control-label required">Aadhar Num</label>
										<div class="controls">
											<form:input path="aadharNumber" type="text" class="span11" />
											<br>
											<form:errors class="errors" path="aadharNumber" />
										</div>
									</div>

									<div class="control-group">
										<label class="control-label">GST Num</label>
										<div class="controls">
											<form:input path="gstNumber" type="text" class="span11" />
											<br>
											<form:errors class="errors" path="gstNumber" />
										</div>
									</div>

									<div class="control-group">
										<label class="control-label">TAN Num</label>
										<div class="controls">
											<form:input path="tanNumber" type="text" class="span11" />
											<br>
											<form:errors class="errors" path="tanNumber" />
										</div>
									</div>

									<div class="control-group">
										<label class="control-label">Bank Account Details</label>
										<div class="controls">
											<form:textarea path="accountDetails" class="span11" />
											<br>
											<form:errors class="errors" path="accountDetails" />
										</div>
									</div>

									<div class="control-group">
										<label class="control-label">ESI</label>
										<div class="controls">
											<form:input path="clientEsi" type="text" class="span11" />
											<br>
											<form:errors class="errors" path="clientEsi" />
										</div>
									</div>

									<div class="control-group">
										<label class="control-label">EPF</label>
										<div class="controls">
											<form:input path="clientEpf" type="text" class="span11" />
											<br>
											<form:errors class="errors" path="clientEpf" />
										</div>
									</div>

									<div class="control-group">
										<label class="control-label">S&E</label>
										<div class="controls">
											<form:input path="clientSE" type="text" class="span11" />
											<br>
											<form:errors class="errors" path="clientSE" />
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
										<label class="control-label required">Is Recurrent</label>
										<div class="controls">
											<form:checkbox path="isRecurrent"/>
											<br>
											<form:errors class="errors" path="isRecurrent" />
										</div>
									</div>
							

									<div class="control-group">
										<label class="control-label required">Client</label>
										<div class="controls" align="left">
											<c:forEach items="${clientTypeDtos}" var="clientType" varStatus="status">
												<form:radiobutton path="clientTypeDto.clientTypeId" value="${clientType.clientTypeId}" /> <c:out value="${clientType.clientTypeName}" />  &nbsp; &nbsp;
											</c:forEach>
											<br>
											<form:errors class="errors" path="clientTypeDto.clientTypeId" />
										</div>
									</div>

									<div class="control-group">
										<label class="control-label required">Nature Of Assignment :</label>
										<div class="controls" align="left">
											<c:forEach items="${natureOfAssignmentDtos}" var="role" varStatus="status">
												<span style="line-height: 3"> <form:checkbox path="natureOfAssignmentList" value="${role.natureOfAssignmentId}" /><c:out value="${role.natureOfAssignmentName} " /> &nbsp; &nbsp; 
												</span>
												
												<c:if test="${(status.index + 1) % 5 == '0'}">
													<br>
												</c:if>
											</c:forEach>
											<br>
											<form:errors class="errors" path="natureOfAssignmentList" />
										</div>
									</div>

									<div class="form-actions" style="background-color: #ffffff; border: none;">
										<button type="submit" class="btn btn-success">Save</button>
										<button type="re" class="btn btn-primary">Reset</button>
										<!-- <button type="submit" class="btn btn-danger">Cancel</button> -->
									</div>
								</form:form>
							</div>
							<!-- <div class="span4"></div> -->
						</div>

					</div>
				</div>
				<%-- <jsp:include page="/right_col.jsp"></jsp:include> --%>
				<div class="span1"></div>

			</div>

		</div>
	</div>
</div>

<!-- Import Bottom Body -->
<jsp:include page="import_js.jsp"></jsp:include>

<script>
	
</script>
<!-- Import Bottom Body -->
<jsp:include page="import_bottom_body.jsp"></jsp:include>
