<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="content-header">
		<div id="breadcrumb">
			<a href="/caapp/" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a>
		</div>
	</div>
	<div class="container-fluid">
		<div class="quick-actions_homepage" id="sticky-div">
			<ul class="quick-actions">
				<c:if test="${isAdmin}">
					<li><a href="/caapp/client"> <i class="icon-people"></i> Client </a></li>
					<li><a href="/caapp/employee"> <i class="icon-people"></i> Employee </a></li>
				</c:if>
				
				<c:if test="${isAdmin or isManager}">
					<li><a href="/caapp/tasks/createTasks"> <i class="icon-people"></i> Add Tasks </a></li>
				</c:if>
				<li><a href="/caapp/tasks/assignedTasks"> <i class="icon-people"></i> Assigned tasks </a></li>
				<li><a href="/caapp/tasks/pendingTasks"> <i class="icon-calendar"></i> Pending tasks </a></li>
				<c:if test="${isAdmin or isManager}">
					<li><a href="/caapp/tasks/completedTasks"> <i class="icon-calendar"></i> Completed tasks </a></li>
				</c:if>
			</ul>
		</div>
	</div>