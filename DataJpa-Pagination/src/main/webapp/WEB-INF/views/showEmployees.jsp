<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${!empty employees}">
	<table border="1">
		<tr>
			<th>EMPNO</th>
			<th>ENAME</th>
			<th>SALARY</th>
			<th>DEPTNO</th>
		</tr>
		<c:forEach items="${employees}" var="e">
			<tr>
				<td><c:out value="${e.empno}"></c:out></td>
				<td><c:out value="${e.ename}"></c:out></td>
				<td><c:out value="${e.salary}"></c:out></td>
				<td><c:out value="${e.deptno}"></c:out></td>
			</tr>
		</c:forEach>

	</table>
	<c:if test="${previous}">
		<a href="getEmployees?pageIndex=${cpn-1}">Prev</a>
	</c:if>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<c:if test="${next}">
		<a href="getEmployees?pageIndex=${cpn+1}">next</a>
	</c:if>
</c:if>
