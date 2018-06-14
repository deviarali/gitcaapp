<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
						<h5>Pending Tasks</h5>
					</div>
					<div class="widget-content nopadding">
						<div>
							<form method="post" action="/caapp/tasks/updatePendingTask">
								<div style="padding: 10px">
									<c:if test="${not empty alert_msg }">
										<label class="info"><c:out value="${alert_msg}"></c:out></label>
									</c:if>
								</div>
								<c:if test="${not empty pendingTasksList }">
									<div align="right" style="padding: 10px;">
										<input type="submit" id="updatePendingTask" class="btn btn-primary" value="Update All" title="Update Selected">
									</div>
								</c:if>
								<table class="table table-bordered table-striped">
									<thead style="background: #CCC;">
										<tr>
											<th>SN#</th>
											<th>Select</th>
											<th>Client</th>
											<th>Task</th>
											<th>Priority</th>
											<th>Employee</th>
											<th>Employee Remarks</th>
											<th>Manager Remarks</th>
											<th>Completed Date</th>
											<th>Status</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${pendingTasksList}" var="pendingtasks" varStatus="status">
											<tr style="
												<c:choose>
												    <c:when test="${pendingtasks.taskStatus eq 'COMPLETED'}">
														background-color:#CCC;
												    </c:when>    
												    <c:otherwise>
														<c:if test="${pendingtasks.priorityStatus eq 'EMERGENCY'}">
															background-color:#ee5f5b;
															color: #fff;
														</c:if>
												    </c:otherwise>
												</c:choose>
												" 
											>	
												<td style="text-align: center;"><c:out value="${status.index + 1}"></c:out></td>
												<td>
													<input type="checkbox" <c:if test="${pendingtasks.taskStatus eq 'COMPLETED'}">disabled="disabled"</c:if> class="selectedTaskIds" name="selectedTaskIds" value="${pendingtasks.id }">
													<input type="hidden" name="taskId" value="${pendingtasks.id }">
												</td>
												<td><c:out value="${pendingtasks.clientDto.clientName}"></c:out></td>
												<td><c:out value="${pendingtasks.priorityStatus.name}"></c:out></td>
												<td><c:out value="${pendingtasks.natureOfAssignmentDto.natureOfAssignmentName}"></c:out></td>
												<td><c:out value="${pendingtasks.taskAssigneeId.employeeName}"></c:out></td>
												<c:choose>
												    <c:when test="${pendingtasks.taskStatus eq 'COMPLETED'}">
														<td><c:out value="${pendingtasks.taskRemarksByEmployee}"></c:out></td>
														<td><c:out value="${pendingtasks.taskRemarksByAdmin}"></c:out></td>
														<td><fmt:formatDate pattern="MM/dd/yyyy" value="${pendingtasks.completedDate.time}" type="date" /></td>
														<td>${pendingtasks.taskStatus.name}</td>
												    </c:when>    
												    <c:otherwise>
														<td><textarea name="taskRemarksByAdmin" rows="" cols="" style="width: 350px">${pendingtasks.taskRemarksByEmployee}</textarea></td>
														<td><c:out value="${pendingtasks.taskRemarksByAdmin}"></c:out></td>
														<td><fmt:formatDate pattern="MM/dd/yyyy" value="${pendingtasks.completedDate.time}" type="date" /></td>
														<td style="text-align: center;">
															<select name="taskStatus" value="${pendingtasks.taskStatus}" <c:if test="${pendingtasks.taskStatus eq 'COMPLETED'}">disabled="disabled"</c:if> style="width: 200px">
																<c:forEach items="${pendingTaskStatusList}" var="status" varStatus="vs">
																	<c:choose>
																	    <c:when test="${pendingtasks.taskStatus == status }">
																	        <option value="${status }" selected="selected">${status.name}</option>
																	    </c:when>    
																	    <c:otherwise>
																	        <option value="${status }">${status.name}</option>
																	    </c:otherwise>
																	</c:choose>
																</c:forEach>
															</select>
														</td>
												    </c:otherwise>
												</c:choose>
												
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
	$("#updatePendingTask").click(function() {

		var $selectedTaskIds = $("input:checkbox:checked").map(function() {
			return $(this).val();
		}).get();
		if ($selectedTaskIds.length > 0) {
			return true;
		}
		alertMessage('Select atleast one tasks...');
		return false;
	});

	});
</script>