<%--
  Author: Shuai Zheng
  Date: 11/22/16
  Time: 11:45 PM
--%>
<%@page import="java.io.File"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.net.URL"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.BufferedReader"%>
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
<br/>


<%

    String outputAddr = session.getServletContext().getRealPath("/");
    String txtFilePath = outputAddr+ "/output.txt";
    BufferedReader bfrdr = new BufferedReader(new FileReader(txtFilePath));
    String line;
    String[][] splittedLine = new String[17][17];
    int j=0;
    while((line = bfrdr.readLine())!= null){
        String[] parts = line.split("\\s+");
        for(int i=0; i<17; i++)
            splittedLine[i][j] = parts[i];
        j++;
    }

%>

<TABLE>
    <% for(int row=0;row<17;row++) { %>
        <TR>
            <% for(int col=0;col<17;col++) { %>
                <TD> <%=splittedLine[col][row]%>
                </TD>
            <% } %>
        </TR>
    <% } %>
</TABLE>


</body>
</html>

