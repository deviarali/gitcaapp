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
<div id="content" style="min-height: 646px;">

	<jsp:include page="/sticky_nav_bar.jsp"></jsp:include>
	
	<div class="container-fluid">
		<div class="row-fluid">
			
			<div class="span1"></div>
			<div class="span10">
				<div class="widget-box">
					<div class="widget-title" align="center">
						<span class="icon"> <i class="icon-th"></i>
						</span>
						<h5>Task Assignment</h5>
					</div>
					<div class="widget-content nopadding">
						<c:if test="${not empty alert_msg }">
							<label class="info"><c:out value="${alert_msg}"></c:out></label>
						</c:if>
						<div style="padding-right: 300px">
							<form:form action="/caapp/tasks/saveTasks" method="post" class="form-horizontal" modelAttribute="tasks">
								<div class="control-group">
									<label class="control-label required">Client Name </label>
									<div class="controls">
										<form:select type="text" class="form-control" path="clientDto.clientId" id="clients">
											<form:option value="">-</form:option>
											<form:options items="${clientsList }" itemValue="clientId" itemLabel="tradeName" />
										</form:select>
										<br>
										<form:errors path="clientDto.clientId" class="errors"/>
									</div>
								</div>
	
								<div class="control-group">
									<label class="control-label required">Nature Of Work </label>
									<div class="controls" id="nature-of-assignments">
										<c:forEach items="${taskList}" var="task" varStatus="status">
											<span style="line-height: 3"> 
												<form:checkbox path="tasks" value="${task.natureOfAssignmentId}" /> <c:out value="${task.natureOfAssignmentName}" />
											</span>
											
										</c:forEach>
										<br>
										<form:errors class="errors" path="tasks" />
									</div>
								</div>
	
								<div class="control-group">
									<label class="control-label required">Priority</label>
									<div class="controls">
										<form:select type="text" class="form-control" path="priorityStatus" id="clients">
											<form:option value="">-</form:option>
											<form:options path="priorityStatus" items="${priorityStatusList}" itemLabel="name"/>
										</form:select>
										<br>
										<form:errors path="priorityStatus" class="errors"/>
									</div>
								</div>

								<div class="control-group">
									<label class="control-label required"> Assignee </label>
									<div class="controls">
										<form:select name="assignee" class="span11" path="taskAssigneeId.employeeId">
											<form:option value="">-</form:option>
											<form:options items="${assigneeList}" itemValue="employeeId" itemLabel="employeeName" />
										</form:select>
										<br>
										<br>
										<form:errors path = "taskAssigneeId.employeeId" class="errors"/>
									</div>
								</div>

								<div class="control-group">
									<label class="control-label required"> Date Of Start </label>
									<div class="controls">
										<div data-date="19-11-1989" class="input-append date datepicker">
											<form:input path="taskStartDate" type="text" data-date-format="dd-mm-yyyy" class="span11" />
											<span class="add-on"><i class="icon-th"></i></span>
										</div>
										<br>
											<form:errors path="taskStartDate" class="errors"/>
									</div>
								</div>
	
								<div class="form-actions" style="background-color: #ffffff;border: none;">
									<button type="submit" class="btn btn-success">Save</button>
									<button type="reset" class="btn btn-primary">Reset</button>
									<!-- <button type="submit" class="btn btn-danger">Cancel</button> -->
								</div>
							</form:form>
						</div>
					</div>
				</div>
			</div>
			<div class="span1"></div>
			
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
					
						option = option + "<span style='line-height: 3'><div class='checker1' id='uniform-tasks"+(i+1)+"'><span><input id='tasks"+(i+1)+"' name='tasks' class='span11' type='checkbox' value='"+data[i].natureOfAssignmentId + "' /></span></div><input type='hidden' name='_tasks' value='on'/> "+data[i].natureOfAssignmentName + "</span> &nbsp; &nbsp; ";
						if ((i+1) % 5 == 0) {
							option = option + "<br>" + (i % 5);
						}
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
