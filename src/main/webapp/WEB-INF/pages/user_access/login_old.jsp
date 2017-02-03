<%--
  Created by IntelliJ IDEA.
  User: Alex Almanza
  Date: 1/31/17
  Time: 1:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="include.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login</title>
</head>
    <body>
        <h1>${message}</h1>
        <form:form id="loginForm" method="post" action="login" modelAttribute="loginBean">
            <form:label path="username">Enter your user-name</form:label>
            <form:input id="username" name="username" path="username" /><br>
            <form:label path="username">Please enter your password</form:label>
            <form:password id="password" name="password" path="password" /><br>
            <input type="submit" value="Submit" />
        </form:form>
    </body>
</html>
