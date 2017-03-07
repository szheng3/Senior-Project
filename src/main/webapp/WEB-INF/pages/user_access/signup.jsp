<%--
  Author: Shuai Zheng, Alex Almanza
  Date: 1/29/17
  Time: 11:29 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="include.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>New User Signup</title>

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
            <a href="${pageContext.request.contextPath}/" class="navbar-brand"><span class="glyphicon glyphicon-picture"></span>
                Home</a>
        </div>
        <div class="collapse navbar-collapse" id="bs-nav-demo">
            <ul class="navbar-nav navbar-right nav">
                <li>Already have an account?</li>
                <li><a href="${pageContext.request.contextPath}/login">Log In</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <div class="content">
                <h1>Sign Up</h1>
                <form:form id="signupForm" method="post" action="signup" modelAttribute="signupBean" class="form-horizontal">
                    <div class="form-group">
                        <div class="col-sm-4 col-sm-push-4">
                            <form:input id="username" name="username" path="username" class="form-control" type="text" placeholder="username" />
                            <p style="color: #ff1700"><c:out value="${username_msg}"/></p>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-4 col-sm-push-4">
                            <form:input id="password" name="password" path="password" class="form-control" type="password" placeholder="password"/>
                            <p style="color: #ff1700"><c:out value="${password_msg}"/></p>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-4 col-sm-push-4">
                            <button class="btn btn-primary form-control">Submit</button>
                        </div>
                    </div>
                </form:form>
                <%--TODO: have rules accessible in a global way--%>
                Username Rules:
                <ol>
                    <li>Only contains alphanumeric characters, underscore and dot.</li>
                    <li>Underscore and dot can't be at the end or start of a username<br>(e.g _username / username_ / .username / username.).</li>
                    <li>Underscore and dot can't be next to each other<br>(e.g user_.name).</li>
                    <li>Underscore or dot can't be used multiple times in a row<br>(e.g user__name / user..name).</li>
                    <li>Number of characters must be between 8 to 20.</li>
                </ol>
            </div>
        </div>
    </div>
</div>

</body>
</html>
