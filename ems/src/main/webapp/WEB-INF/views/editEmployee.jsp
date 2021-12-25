<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<form:form action="update" method="post" modelAttribute="emp">
	<table border="1">
		<tr>
			<td>EmpNo</td>
			<td><form:input path="empno" readOnly="true" /></td>
		</tr>
		<tr>
			<td>Ename</td>
			<td><form:input path="ename" /></td>
		</tr>
		<tr>
			<td>Salary</td>
			<td><form:input path="sal" /></td>
		</tr>
		<tr>
			<td>DeptnNo</td>
			<td><form:input path="deptno" /></td>
		</tr>
		<tr><td>
			<input type="submit" value="Update" /></td>
		</tr>


	</table>
</form:form>