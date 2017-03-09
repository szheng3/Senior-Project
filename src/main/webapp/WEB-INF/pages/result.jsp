<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Author: Shuai Zheng
  Date: 11/22/16
  Time: 11:45 PM
--%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.File" %>
<%@ page import="java.io.FileReader" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>File Upload Example in JSP and Servlet - Java web application</title>

    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css"
          href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
    <link href="http://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet"
          type="text/css">
    <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.4.js"></script>
    <script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

    <style>
        body {
            background: url(http://creative-automata.com/wp-content/uploads/2015/03/binary-code-9004-2560x1600.jpg);
            background-size: cover;
            background-position: center;
        }

        body,
        html {
            width: 100%;
            height: 100%;
            font-family: "Lato";
            color: white;
        }

        h1 {
            font-weight: 700;
            font-size: 5em;
        }

        .content {
            padding-top: 10%;
            text-align: center;
            text-shadow: 0px 4px 3px rgba(0, 0, 0, 0.4),
            0px 8px 13px rgba(0, 0, 0, 0.1),
            0px 18px 23px rgba(0, 0, 0, 0.1);
        }

        hr {
            width: 400px;
            border-top: 1px solid #f8f8f8;
            border-bottom: 1px solid rgba(0, 0, 0, 0.2);
        }

    </style>

</head>

<body>
<%--<div id="result">
    <h3>${requestScope["message"]}</h3>

</div>--%>

<%--<IFRAME src="file://${requestScope["download"]}"/>--%>

<%--file://${requestScope["download"]}--%>

<%--<a href="file://${requestScope["download"]}">--%>
<%--<img border="0" src="http://publichealthconference.co/2016/wp-content/uploads/2016/01/Click-to-Download.png"--%>
<%-->--%>
<%--</a>--%>


<%--<%response.sendRedirect("file://%>${requestScope["download"]}<%");%>--%>

<br/>

<%--${requestScope["download"]}--%>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-nav-demo"
                    aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a href="${pageContext.request.contextPath}/?username=${username}" class="navbar-brand"><span
                    class="glyphicon glyphicon-picture"></span>
                Home</a>
        </div>

        <div class="collapse navbar-collapse" id="bs-nav-demo">
            <ul class="navbar-nav    navbar-right nav">

                <c:choose>
                    <c:when test="${username!=null}">
                        <li><a><c:out value="${username}"/></a></li>
                        <li><a href="${pageContext.request.contextPath}/login">Log Out</a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="${pageContext.request.contextPath}/login">Log In</a></li>
                        <li><a href="${pageContext.request.contextPath}/signup">Sign Up</a></li>
                    </c:otherwise>
                </c:choose>


            </ul>
        </div>
    </div>
</nav>


<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <div class="content">
                <h2>Result</h2>
                <hr>


                <%
                    String rootPath = System.getProperty("catalina.home");
                    File dir = new File(rootPath + File.separator + "tmpFiles");
//                    String outputAddr = session.getServletContext().getRealPath("/");
                    String fileName = dir.getAbsolutePath()
                            + File.separator + "output.txt";

//    String fileName=request.getSession().getServletContext().getRealPath("") + File.separator + "output.txt";
                    try {

                        //Create object of FileReader
                        FileReader inputFile = new FileReader(fileName);

                        //Instantiate the BufferedReader Class
                        BufferedReader bufferReader = new BufferedReader(inputFile);

                        //Variable to hold the one line data
                        String line;

                        // Read file line by line and print on the console
                        while ((line = bufferReader.readLine()) != null) {
                            out.print("<h5>\n" + line + "<h5/>");
                        }
                        //Close the buffer reader
                        bufferReader.close();
                    } catch (Exception e) {
                        System.out.println("Error while reading file line by line:" + e.getMessage());
                    }

                %>


            </div>
        </div>
    </div>
</div>


</body>
</html>

