<html>
<body>
<h2>Hello World!</h2>
<%--在表单中进行重定向--%>
<form action="${pageContext.request.contextPath}/login" method="get">
    用户名：<input type="text" name="username"> <br>
    密码: <input type="password" name="password"> <br>
    <input type="submit">
</form>
</body>
</html>
