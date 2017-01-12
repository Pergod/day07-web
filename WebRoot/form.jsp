<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
	function doSubmit(){
		var submit=document.getElementById("submit");
		input.disabled = 'disabled';
		return true;
	}
</script>
</head>
<body>
	<form action="/day07/doform" method="post" onsubmit="return doSubmit()">
		用户名:<input type="text" name="username"/><br/>
		<input id="submit" type="submit" value="提交" />
	</form>
</body>
</html>