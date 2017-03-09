<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            padding-top: 3%;
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
    <div class="content">

        <br/>
        The number of files being read is:<%=request.getAttribute("last_id") %>
        <br/>
        <%
            int last_id = (Integer)request.getAttribute("last_id");
            String outputAddr = session.getServletContext().getRealPath("/");
            for(int i = 1; i<=last_id; i++) {
        %>
        <br/>
        <%
            out.println("The BLOB number "+i+" returns result:");
        %>
        <br/>
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
            BufferedReader bfrdr1 = new BufferedReader(new FileReader(txtFilePath+i+"_time.txt"));
            StringBuilder sb1 = new StringBuilder();
            String line1;
            while((line1 = bfrdr1.readLine())!=null) {
                sb1.append(line1+"\n");
            }
            out.println(sb1.toString());
        %>
        <br/>
        <%
            }
        %>
    </div>

</div>
</body>
</html>