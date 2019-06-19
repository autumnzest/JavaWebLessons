<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>

<script src="js/jquery.min.js">
</script>
<script>
$(function() {
	$("#submit").click(function() {
		$.post("/Test2/LoginServlet", {
			username : $('#username').val(),
			password : $('#password').val()
		}, function(data, status) {
			if (data != null && data == "success") {
			       $(location).attr('href', '/Test2/UserList');
			}else{
				alert("username or password is wrong!");
			}
		});
	});
	$("#signup").click(function() {
		$(location).attr('href', '/Test2/useradd.html');
	});
});
</script>
</head>
<body>
	<div>
		<input type="text" id="username">
	</div>
	<div>
		<input type="password" id="password">
	</div>
	<div>
		<button id="submit">login</button>
		<button id="signup">sign up</button>
	</div>
</body>
</html>
