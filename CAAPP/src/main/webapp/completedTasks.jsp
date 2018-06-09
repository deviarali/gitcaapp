<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Import Top Body -->
<jsp:include page="/import_top_body.jsp"></jsp:include>
<jsp:include page="/nav_bar.jsp"></jsp:include>

<div id="content">

	<jsp:include page="/sticky_nav_bar.jsp"></jsp:include>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span1"></div>
			<div class="span10">
				<div class="widget-box">
					<div class="widget-title">
						<p align="center">Completed Tasks</p>
					</div>
					<div class="widget-content nopadding">
						<div>
							<form method="post" action="/caapp/tasks/updateCompletedTask">
								<div style="padding: 10px">
									<c:if test="${not empty alert_msg }">
										<label class="info"><c:out value="${alert_msg}"></c:out></label>
									</c:if>
								</div>
								<c:if test="${not empty completedTasksList }">
									<div align="right" style="padding: 10px;">
										<input type="submit" id="updateCompletedTask" class="btn btn-primary" value="Update All" title="Update Selected">
									</div>
								</c:if>
								<table class="table table-bordered table-striped">
									<thead style="background: #CCC;">
										<tr>
											<th>SN#</th>
											<th>Select</th>
											<th>Client</th>
											<th>Task</th>
											<th>Employee Remarks</th>
											<th>Manager Remarks</th>
											<th>Status</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${completedTasksList}" var="completedtasks" varStatus="status">
											<tr>	
												<td style="text-align: center;"><c:out value="${status.index + 1}"></c:out></td>
												<td>
													<input type="checkbox" class="selectedTaskIds" name="selectedTaskIds" value="${completedtasks.id }">
													<input type="hidden" name="taskId" value="${completedtasks.id }">
												</td>
												<td><c:out value="${completedtasks.clientDto.clientName}"></c:out></td>
												<td><c:out value="${completedtasks.natureOfAssignmentDto.natureOfAssignmentName}"></c:out></td>
												<td><textarea name="taskRemarksByEmployee" disabled="disabled" rows="" cols="" style="width: 350px">${completedtasks.taskRemarksByEmployee}</textarea></td>
												<td><textarea name="taskRemarksByAdmin" rows="" cols="" style="width: 350px">${completedtasks.taskRemarksByAdmin}</textarea></td>
												<td style="text-align: center;">
													<select name="taskStatus" value="${completedtasks.taskStatus}"  style="width: 200px">
														<c:forEach items="${completedTaskStatusList}" var="status" varStatus="vs">
															<c:choose>
															    <c:when test="${completedtasks.taskStatus == status }">
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
	$("#updateCompletedTask").click(function() {

		var $selectedTaskIds = $("input:checkbox:checked").map(function() {
			return $(this).val();
		}).get();
		if ($selectedTaskIds.length > 0) {
			return true;
		}
		alert('Select atleast one tasks to update');
		return false;
	});

	});
</script>