<%--
  Author: Shuai Zheng
  Date: 11/9/16
  Time: 2:44 PM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>--%>
<%--<tiles:insertDefinition name="home"/>--%>
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

    <jsp:include page="/auth"/>

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
            padding-top: 25%;
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
                <li><a href="${pageContext.request.contextPath}/viewhistory/${username}">View History</a></li>

                <!-- TODO: LOCK BEFORE LOGIN, REQUIRED -->

            </ul>
        </div>
    </div>
</nav>

<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <div class="content">
                <h2>Machine Learning</h2>
                <hr>
                <div>
                    <%--<form action="upload" method="post" enctype="multipart/form-data" class="form-inline">--%>
                    <form action="${pageContext.request.contextPath}/uploadFile" method="post"
                          enctype="multipart/form-data" class="form-inline">
                        <div class="form-group">
                            <input type="file" name="file"/>
                        </div>
                        <div class="form-group">
                            <%String username = (String)request.getAttribute("username");
                            System.out.println("username is: "+username);%>
                            <input type="hidden" name="name" value="${username}"/>
                            <input class="btn btn-primary" type="submit" value="upload"/>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>


</body>
</html>





