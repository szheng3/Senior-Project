<%--
  Author: Shuai Zheng
  Date: 1/29/17
  Time: 11:29 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            <a href="/SeniorProjectVersion2/" class="navbar-brand"><span class="glyphicon glyphicon-picture"></span>
                Home</a>
        </div>
        <div class="collapse navbar-collapse" id="bs-nav-demo">
            <ul class="navbar-nav navbar-right nav">


                <li><a href="SignIn">Log In</a></li>
                <li><a href="SignUp">Sign Up</a></li>


            </ul>


        </div>

    </div>
</nav>
<div class="container">
</div>


<div class="container">
    <div class="row">
        <div class="text-center">
            <h1>Sign Up</h1>
            <form action="Up" method="POST" class="form-horizontal">
                <div class="form-group">
                    <div class="col-sm-4 col-sm-push-4">
                        <input class="form-control" name="username" type="text" placeholder="username">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-4 col-sm-push-4">
                        <input class="form-control" name="password" type="password" placeholder="password">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-4 col-sm-push-4">
                        <button class="btn btn-primary form-control">Submit</button>
                    </div>

                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
