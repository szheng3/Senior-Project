<%@ page import="java.io.BufferedReader" %>
<%@ page import="java.io.FileReader" %><%--
  Created by IntelliJ IDEA.
  User: Leo
  Date: 2/20/2017
  Time: 1:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>View History from DB</title>

</head>

<body>



<a>The number of files being read is:<%=request.getAttribute("last_id") %></a> <br/>
<a><%
    int last_id = (Integer)request.getAttribute("last_id");
    String outputAddr = session.getServletContext().getRealPath("/");
    for(int i=1; i<=last_id; i++) {
%>            <br/>
    <%
        out.println("The BLOB number "+i+" returns result:");
    %>            <br/>
    <%
        String txtFilePath = outputAddr+ "/output";
        BufferedReader bfrdr = new BufferedReader(new FileReader(txtFilePath+i+".txt"));
        StringBuilder sb = new StringBuilder();
        String line;
        while((line = bfrdr.readLine())!=null){
            sb.append(line+"\n");
        }
        out.println(sb.toString());
    %>
    <br/>
    <%
        }
    %></a>
</body>
</html>