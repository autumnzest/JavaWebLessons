<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.test.Bean.UserBean"%>

<html>
<head>
<link rel="stylesheet" href="css/main.css" />
<title>userlist</title>
</head>
<body>

	<jsp:useBean id="users" class="java.util.ArrayList" scope="request">

	</jsp:useBean>

	<table border="1">
		<tr>
			<th>name</th>
			<th>pass</th>
			<th>sex</th>
			<th>age</th>
			<th>country</th>
			<th>memo</th>
		</tr>
		<%
			Iterator iter = users.iterator();
			while (iter.hasNext()) {
				UserBean stn = new UserBean();
				stn = (UserBean) iter.next();
		%>
		<tr>
			<td><%=stn.getName()%></td>
			<td><%=stn.getPassword()%></td>
			<td><%=stn.getSex()%></td>
			<td><%=stn.getAge()%></td>
			<td><%=stn.getCountry()%></td>
			<td><%=stn.getMemo()%></td>
		</tr>
		<%
			}
		%>

	</table>
	<div>
		<a href="useradd.html">sing up</a>&nbsp;&nbsp;&nbsp;<a
			href="login.jsp">logout</a>
	</div>
</body>
</html>
