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
						<br>
						<div>
							<table class="table table-bordered table-striped">
								<thead style="background: #CCC;color: #FFF;font-size: 22px;">
									<tr>
										<th>SN#</th>
										<th>Select</th>
										<th>Client</th>
										<th>Task</th>
										<th>Employee Remarks</th>
										<th>Manager Remarks</th>
										<th>Status</th>
										<th><a class="btn btn-success">Update All</a></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${completedTasksList}" var="completedtasks" varStatus="status">
										<tr>	
											<td><c:out value="${status.index + 1}"></c:out></td>
											<td><input type="checkbox" value="taskIds"></td>
											<td><c:out value="${completedtasks.clientDto.clientName}"></c:out></td>
											<td><c:out value="${completedtasks.natureOfAssignmentDto.natureOfAssignmentName}"></c:out></td>
											<td><textarea name="tasksRemarksByEmployee" rows="" cols="" style="width: 350px">${completedtasks.taskRemarksByEmployee}</textarea></td>
											<td><textarea name="taskRemarksByAdmin" rows="" cols="" style="width: 350px">${completedtasks.taskRemarksByAdmin}</textarea></td>
											<td>
											
												<select name="taskStatus" value="${completedtasks.taskStatus}"  style="width: 200px">
													<option value="-1">-</option>
													<c:forEach items="${taskStatusList}" var="status" varStatus="vs">
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
											 <td style="text-align: center;"><a href="/caapp/tasks/updateEmployeeRemarks/${completedtasks.id}/${completedtasks.taskRemarksByEmployee}" class="btn btn-primary">Update</a></td>  
											
										</tr>
									</c:forEach>							
								</tbody>
							</table>
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