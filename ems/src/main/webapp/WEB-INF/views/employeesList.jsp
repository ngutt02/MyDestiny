<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<table border="1">
	<tr>
		<th>Empno</th>
		<th>Ename</th>
		<th>Salary</th>
		<th>Deptno</th>
		<th>Actions</th>
	</tr>
	<c:if test="${!empty employees}">
		<c:forEach items="${employees}" var="e">
			<tr>
				<td><c:out value="${e.empno}" /></td>
				<td><c:out value="${e.ename}" /></td>
				<td><c:out value="${e.sal}" /></td>
				<td><c:out value="${e.deptno}" /></td>
				<td><a href="editEmployee?id=${e.empno}"><img
						src=images/edit.png width="30" height="30"></a> <a
					href="deleteEmployee?id=${e.empno}"><img src=images/delete.png
						width="30" height="30" /></a></td>
			</tr>

		</c:forEach>

	</c:if>

</table>
<c:if test="${previous}">
	<a href="listEmployees?pageIndex=${cpn-1}">Previous</a>
</c:if>

<c:if test="${next}">
	<a href="listEmployees?pageIndex=${cpn+1}">Next</a>
</c:if>
<!-- <a href="index">Index Page</a> -->