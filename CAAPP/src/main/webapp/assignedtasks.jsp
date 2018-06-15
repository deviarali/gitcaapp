<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Import Top Body -->
<jsp:include page="/import_top_body.jsp"></jsp:include>
<jsp:include page="/nav_bar.jsp"></jsp:include>

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
						<h5>Assigned Tasks</h5>
					</div>
					<div class="widget-content nopadding">
						<c:if test="${not empty alert_msg }">
							<label class="info"><c:out value="${alert_msg}"></c:out></label>
						</c:if>
						<div>
							<form method="post" action="/caapp/tasks/updateAssignedTask">
								<c:if test="${not empty assignedTasksList }">
									<div align="right" style="padding: 10px;">
										<input type="submit" id="updateAssignedTask" class="btn btn-primary" value="Update All" title="Update Selected">
									</div>
								</c:if>
								<table class="table table-bordered">
									<thead style="background: #CCC;">
										<tr>
											<th>SN#</th>
											<th>Select</th>
											<th>Client</th>
											<th>Task</th>
											<th>Priority</th>
											<th>Assign</th>
											<th>Employee Remarks</th>
											<th>Manager Remarks</th>
											<th>Status</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${assignedTasksList}" var="assignedtasks" varStatus="status">
											<tr style="
												<c:choose>
												    <c:when test="${assignedtasks.taskStatus eq 'COMPLETED'}">
														background-color:#CCC;
												    </c:when>    
												    <c:otherwise>
														<c:if test="${assignedtasks.priorityStatus eq 'EMERGENCY'}">
															background-color:#ee5f5b;
															color: #fff;
														</c:if>
												    </c:otherwise>
												</c:choose>
												" 
											>	
												<td style="text-align: center;"><c:out value="${status.index + 1}"></c:out></td>
												<td>
													<input type="checkbox" class="selectedTaskIds" name="selectedTaskIds" value="${assignedtasks.id }">
													<input type="hidden" name="taskId" value="${assignedtasks.id }">
												</td>
												<td><c:out value="${assignedtasks.clientDto.clientName}"></c:out></td>
												<td><c:out value="${assignedtasks.natureOfAssignmentDto.natureOfAssignmentName}"></c:out></td>
												<td><c:out value="${assignedtasks.priorityStatus.name}"></c:out></td>
												<td>
													<select name="assigneeIds" value="${assignedtasks.taskStatus}"  style="width: 200px">
														<c:forEach items="${assigneeList}" var="assignee" varStatus="vs">
															<c:choose>
															    <c:when test="${assignee.employeeId eq assignedtasks.taskAssigneeId.employeeId }">
															        <option value="${assignee.employeeId}" selected="selected">${assignee.employeeName}</option>
															    </c:when>    
															    <c:otherwise>
															        <option value="${assignee.employeeId}">${assignee.employeeName}</option>
															    </c:otherwise>
															</c:choose>
														</c:forEach>
													</select>
													
												</td>
												<td><textarea name="taskRemarksByEmployee" rows="" cols="" style="width: 350px">${assignedtasks.taskRemarksByEmployee}</textarea></td>
												<td><c:out value="${assignedtasks.taskRemarksByAdmin}"></c:out></td>
												<td style="text-align: center;">
													<select name="taskStatus" value="${assignedtasks.taskStatus}"  style="width: 200px">
														<c:forEach items="${taskStatusList}" var="status" varStatus="vs">
															<c:choose>
															    <c:when test="${assignedtasks.taskStatus == status }">
															        <option value="${status }" selected="selected">${status.name}</option>
															    </c:when>    
															    <c:otherwise>
															        <option value="${status }">${status.name}</option>
															    </c:otherwise>
															</c:choose>
														</c:forEach>
													</select>
												</td>
												
											</tr>
										</c:forEach>							
									</tbody>
								</table>
							</form>
						</div>
					</div>
				</div>

				</div>

			<div class="span1"></div>
		</div>
	</div>
</div>
<!-- Import Bottom Body -->
<jsp:include page="import_js.jsp"></jsp:include>
<!-- Import Bottom Body -->
<jsp:include page="import_bottom_body.jsp"></jsp:include>

<script>
$(document).ready(function(){
	$("#updateAssignedTask").click(function() {

		var $selectedTaskIds = $("input:checkbox:checked").map(function() {
			return $(this).val();
		}).get();
		if ($selectedTaskIds.length > 0) {
			return true;
		}
		alertMessage('Select atleast one tasks to update');
		return false;
	});

	});
</script>