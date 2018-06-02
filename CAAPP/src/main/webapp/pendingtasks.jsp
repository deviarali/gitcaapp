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
						<p align="center">Pending Tasks</p>
					</div>
					<div class="widget-content nopadding">
						<table class="table table-bordered table-striped">
							<thead>
								<tr>
									<th>Sl No.</th>
									<th>Client</th>
									<th>Task</th>
									<th>Employee Remarks</th>
									<th>Manager Remarks</th>
									<th>Status</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${pendingTasksList}" var="pendingtasks" varStatus="status">
									<tr>	
										<td><c:out value="${status.index + 1}"></c:out></td>
										<td><c:out value="${pendingtasks.clientDto.clientName}"></c:out></td>
										<td><c:out value="${pendingtasks.natureOfAssignmentDto.natureOfAssignmentName}"></c:out></td>
										<td><textarea name="tasksRemarksByEmployee" rows="" cols="" style="width: 400px">${pendingtasks.taskRemarksByEmployee}</textarea></td>
										<td><textarea name="taskRemarksByAdmin" rows="" cols="" style="width: 400px">${pendingtasks.taskRemarksByAdmin}</textarea></td>
										<td>
										
											<select name="taskStatus" value="${pendingtasks.taskStatus}"  style="width: 200px">
												<option value="-1">-</option>
												<c:forEach items="${taskStatusList}" var="status" varStatus="vs">
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
										 <td style="text-align: center;"><a href="/caapp/tasks/updateEmployeeRemarks/${pendingtasks.id}/${pendingtasks.taskRemarksByEmployee}" class="btn btn-primary">Update</a></td>  
										
									</tr>
								</c:forEach>							
							</tbody>
						</table>
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