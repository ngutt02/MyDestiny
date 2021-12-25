<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${message ne null}">
	<!-- <div class="alert alert-light" role="alert"> -->
		<!-- <strong>/strong> -->
		<c:out value="${message}" />
	<!-- </div> -->
</c:if><br><br>

<a href="addEmployee">Add Employee</a><br>
<a href="listEmployees">List Employee</a>
