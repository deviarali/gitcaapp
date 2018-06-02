<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Import Top Body -->
<jsp:include page="/import_top_body.jsp"></jsp:include>
<jsp:include page="/nav_bar.jsp"></jsp:include>

<div id="content">

	<jsp:include page="/sticky_nav_bar.jsp"></jsp:include>
	<div class="container-fluid">
		<div class="row-fluid">

			<div class="span3">
				<div class="widget-box">
					<div class="widget-title" style="background-color: #848d97;">
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
						<p align="center">Assigned Tasks</p>
					</div>
					<div class="widget-content nopadding">
						<table class="table table-bordered table-striped">
							<thead>
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
											<td><c:out value="${status.index}"></c:out></td>
												<td><c:out value="${assignedtasks.taskAssigneeId.employeeName}"></c:out></td>
												<td><c:out value="${assignedtasks.clientDto.clientName}"></c:out></td>
												<td><c:out value="${assignedtasks.natureOfAssignmentDto.natureOfAssignmentName}"></c:out></td>
												<td><c:out value="${assignedtasks.startDate}"></c:out></td>
												<td><c:out value="${assignedtasks.taskStatusId.tasksStatusName}"></c:out></td>
											</tr>
										</c:forEach>
							</tbody>
						</table>
					</div>
				</div>

			</div>

			<div class="span2">
				<div class="widget-box">
					<div class="widget-title" style="background-color: #848d97;">
						<p>Important Links</p>
					</div>
					<div class="widget-content">
						<div align="left">
							<a href="WWW.GST.GOV.IN">WWW.GST.GOV.IN</a><br /> <a
								href="WWW.ICAI.ORG">WWW.ICAI.ORG</a><br /> <a
								href="WWW.MCA.GOV.IN">WWW.MCA.GOV.IN</a><br /> <a
								href="WWW.PT.KAR.NIC.IN">WWW.PT.KAR.NIC.IN</a><br /> <a
								href="WWW.ESI">WWW.ESI</a><br /> <a href="WWW.EPF">WWW.EPF</a><br />
							<a href="WWW. S & E">WWW. S & E</a><br /> <a href="WWW.RBI.ORG">WWW.GST.GOV.IN</a><br />
							<a href="WWW.HDFCBANK.OCM">WWW.HDFCBANK.OCM</a><br />
						</div>
					</div>
				</div>
			</div>

		</div>
		<!-- Import Bottom Body -->
		<jsp:include page="import_js.jsp"></jsp:include>
		<!-- Import Bottom Body -->
		<jsp:include page="import_bottom_body.jsp"></jsp:include>