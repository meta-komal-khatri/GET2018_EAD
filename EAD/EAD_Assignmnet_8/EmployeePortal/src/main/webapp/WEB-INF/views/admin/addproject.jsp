<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<form action="addproject" method="post">
		<table>
			<tr>
				<td>Description</td>
				<td><input type="text" name="description"></td>
			</tr>
			<tr>
				<td>Start Date </td>
				<td><input type="date" name="start_date"></td>
			</tr>
			<tr>
				<td>End Date </td>
				<td><input type="date" name="end_date"></td>
			</tr>
			<tr>
				<td>Project Logo</td>
				<td><input type="file" name="end_date"></td>
			</tr>
			<tr>
				<td colspan="2" ><input type="submit"  value="Add Project"></td>
			</tr>
		</table>
		<input type="submit" value="submit">
	</form>
	
</body>
</html>