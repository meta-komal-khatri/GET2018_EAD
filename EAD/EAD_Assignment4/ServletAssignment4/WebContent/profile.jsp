<%@page import="sun.misc.BASE64Encoder"%>
<%@page import="com.metacube.servletassignment4.facade.UserFacade"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="LogOutServlet" mathod="get">
	<%
			UserFacade userFacade=UserFacade.getInstance();
			String email=null;
			String base64String;
			byte[] image=null;
			HttpSession sessionProfileJsp=request.getSession(false);
			if(session!=null){
				email=(String) session.getAttribute("user");
			
				//System.out.println(email);
			}
			else{
				RequestDispatcher rd=request.getRequestDispatcher("/user_login.html");  
				rd.forward(request, response);
			}
			
		%>
		<table>
			<tr>
				
				<td alighn="right"><input type="text" value=<%=userFacade.userName(email).getFirstName()%> name="first_name" border="0">
				<img src="data:image/png;base64,"+<%=request.getAttribute("image") %>>
				
				
				<input type="submit" value="LogOut" name="btn_logout"></td></form>
			</tr>
			
		</table>
	
</body>
</html>