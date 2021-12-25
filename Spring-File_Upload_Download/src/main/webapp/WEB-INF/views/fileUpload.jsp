<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h3>
	<c:if test="${msg ne null}">
		<c:out value="${msg}" />
	</c:if>
</h3>
<form action="doUpload" method="post" enctype="multipart/from-data">

	PickFile<input type="file" name="file1" /> <input type="submit"
		name="Upload" />


</form>