<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Import Top Body -->
<jsp:include page="/import_top_body.jsp"></jsp:include>
<jsp:include page="/nav_bar.jsp"></jsp:include>

<style>
	.checker1 {
	    width: 19px;
	    height: 19px;
	    margin: 0;
	    padding: 0;
	    display: inline-block;
	    margin-right: 5px;
	    vertical-align: middle;
	    zoom: 1;
	}
	.checker1 span {
		background-position: 0px -260px;
	    align-items: center;
	    position: relative;
	    width: 19px;
	    height: 19px;
	    line-height: 19px;
	    display: flex;
	}
</style>
<div id="content">

	<jsp:include page="/sticky_nav_bar.jsp"></jsp:include>
	
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

			<div class="span7">
				<div class="widget-box">
					<div class="widget-title">
						<p align="center">Task Assign</p>
					</div>
					<div class="widget-content nopadding">
						<div style="padding-right: 300px">
							<form:form action="/caapp/tasks/saveTasks" method="post" class="form-horizontal" modelAttribute="tasks">
								<div class="control-group">
									<label class="control-label required">Client Name </label>
									<div class="controls">
										<form:select type="text" class="form-control" path="clientDto.clientId" id="clients">
											<form:option value="-1">-select client-</form:option>
											<form:options items="${clientsList }" itemValue="clientId" itemLabel="tradeName" />
										</form:select>
										<form:errors path="clientDto.clientId" />
	
									</div>
								</div>
	
								<div class="control-group">
									<label class="control-label required">Nature Of Work </label>
									<div class="controls" id="nature-of-assignments">
										<c:forEach items="${taskList}" var="task" varStatus="status">
											<span style="line-height: 3"> <form:checkbox path="tasks" value="${task.natureOfAssignmentId}" /> <c:out value="${task.natureOfAssignmentName}" />
											</span>
											<br>
										</c:forEach>
									</div>
								</div>
	
								<div class="control-group">
									<label class="control-label required">Priority</label>
									<div class="controls">
										<form:select type="text" class="form-control" path="priorityStatus" id="clients">
											<form:option value="-1">-</form:option>
											<form:options path="priorityStatus" items="${priorityStatusList}" itemLabel="name"/>
										</form:select>
										<form:errors path="priorityStatus" />
									</div>
								</div>
	
								<div class="control-group">
									<label class="control-label required"> Status </label>
									<div class="controls">
										<form:select type="text" class="form-control" path="taskStatus" id="clients">
											<form:option value="-1">-</form:option>
											<form:options path="taskStatus" items="${taskStatusList}" itemLabel="name"/>
										</form:select>
										<form:errors path="taskStatus" />
									</div>
								</div>
	
								<div class="control-group">
									<label class="control-label required"> Assignee </label>
									<div class="controls">
										<form:select name="assignee" class="span11" path="taskAssigneeId.employeeId">
											<form:option value="-1">-select assignee-</form:option>
											<form:options items="${assigneeList}" itemValue="employeeId" itemLabel="employeeName" />
										</form:select>
	
									</div>
								</div>
	
								<div class="control-group">
									<label class="control-label required"> Date Of Start </label>
									<div class="controls">
										<div data-date="19-11-1989" class="input-append date datepicker">
											<form:input path="taskStartDate" type="text" value="" data-date-format="dd-mm-yyyy" class="span11" />
											<span class="add-on"><i class="icon-th"></i></span>
										</div>
									</div>
								</div>
	
								<div class="form-actions" style="background-color: #ffffff;border: none;">
									<button type="submit" class="btn btn-success">Save</button>
									<button type="submit" class="btn btn-primary">Reset</button>
									<button type="submit" class="btn btn-danger">Cancel</button>
								</div>
							</form:form>
						</div>
					</div>
				</div>
			</div>

			<div class="span2">
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

		</div>
		<hr>

	</div>
</div>

<!-- Import Bottom Body -->
<jsp:include page="import_js.jsp"></jsp:include>

<script>
$(document).ready(function () {
	$("#clients").change(function() {
		var clientId = $(this).val();
		$.ajax({
			type : 'GET',
			url : "/caapp/tasks/getTasksByCustomerId/" +clientId,
			success : function(data) {
				var slctSubcat = $('#nature-of-assignments'), option = "";
				slctSubcat.empty();
				if(data.length > 0) {
					for (var i = 0; i < data.length; i++) {
					
						option = option + "<span style='line-height: 3'><div class='checker1' id='uniform-tasks"+(i+1)+"'><span><input id='tasks"+(i+1)+"' name='tasks' class='span11' type='checkbox' value='"+data[i].natureOfAssignmentId + "' /></span></div><input type='hidden' name='_tasks' value='on'/> "+data[i].natureOfAssignmentName + "</span><br>";
					}
					slctSubcat.append(option);
				}
			},
			error : function() {
				alert("error");
			}

		});
	}); 
	
});

</script>
<!-- Import Bottom Body -->
<jsp:include page="import_bottom_body.jsp"></jsp:include>
