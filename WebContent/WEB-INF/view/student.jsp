<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<form:form action="dojstudent" commandName="student" enctype="multipart/form-data">	
		<table style="text-align: center; position: absolute;padding-left: 500px;">
			<tr>
				<td>First Name : </td>
				<td><input name="fname" type="text"></td>
				<td><form:errors path="fname" cssClass="error"/></td>
			</tr>
			<tr>
				<td>Last Name : </td>
				<td><input name="lname" type="text"></td>
				<td><form:errors path="lname" cssClass="error"/></td>
			</tr>
			<tr>
				<td>Address : </td>
				<td><input name="address" type="text" value="${student.address}"></td>
				<td><form:errors path="address" cssClass="error"/></td>
			</tr>
			<tr>
				<td>Course : </td>
				<td><input name="course" type="text"></td>
				<td><form:errors path="course" cssClass="error"/></td>
			</tr>
			<tr>
				<td>Age : </td>
				<td><input name="age" type="text"></td>
				<td><form:errors path="age" cssClass="error"/></td>
			</tr>
			<tr>
				<td>Profile Picture : </td>
				<td><input type="file" name="profilePicture" accept="image/jpeg,image/png,image/gif" /></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="Submit" name="Submit" value="Submit"></td>
			</tr>
		</table>
	
</form:form>