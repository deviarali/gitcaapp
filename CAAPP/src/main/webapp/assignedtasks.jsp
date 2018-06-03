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
						<p align="center">Assigned Tasks</p>
					</div>
					<div class="widget-content nopadding">
						<br>
						<table class="table table-bordered table-striped">
								<thead style="background: #CCC;">
								<tr>
									<th>Sl No.</th>
									<th>Assignee</th>
									<th>Name of the client</th>
									<th>Nature Of Work</th>
									<th>Start Date</th>
									<th>status</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${listOfAssignedTasks}" var="assignedtasks" varStatus="status">
									<tr>
										<td><c:out value="${status.index + 1}"></c:out></td>
										<td><c:out value="${assignedtasks.taskAssigneeId.employeeName}"></c:out></td>
										<td><c:out value="${assignedtasks.clientDto.clientName}"></c:out></td>
										<td><c:out value="${assignedtasks.natureOfAssignmentDto.natureOfAssignmentName}"></c:out></td>
										<td style="text-align: center;"><c:out value="${assignedtasks.startDate}"></c:out></td>
										<td style="text-align: center;"><c:out value="${assignedtasks.taskStatus}"></c:out></td>
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