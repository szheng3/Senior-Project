<%--
  Author: Shuai Zheng
  Date: 11/22/16
  Time: 11:45 PM
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>File Upload Example in JSP and Servlet - Java web application</title>

</head>

<body>
<div id="result">
    <h3>${requestScope["message"]}</h3>

</div>

<%--<IFRAME src="file://${requestScope["download"]}"/>--%>

file://${requestScope["download"]}

<%--<a href="file://${requestScope["download"]}">--%>
<%--<img border="0" src="http://publichealthconference.co/2016/wp-content/uploads/2016/01/Click-to-Download.png"--%>
<%-->--%>
<%--</a>--%>


<%--<%response.sendRedirect("file://%>${requestScope["download"]}<%");%>--%>
</body>
</html>

