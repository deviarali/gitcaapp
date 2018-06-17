<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${isAdmin}">
	<div class="widget-box">
		<div class="widget-title" align="center">
			<span class="icon"> <i class="icon-th"></i>
			</span>
			<h5>Admin Management</h5>
		</div>
		<div class="widget-content">
			<div align="left" style="line-height: 1.6">
				<a href="/caapp/applicationUser">Application User</a><br /> <a href="/caapp/userRole">User Roles</a><br /> <a href="/caapp/natureOfAssignment">Nature Of Assignments</a><br /> <a href="/caapp/parameter">System Parameters</a><br />
				<!-- <a href="WWW.GST.GOV.IN">Important News (marquee)</a><br /> -->
			</div>
		</div>
	</div>
</c:if>