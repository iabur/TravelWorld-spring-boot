<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>travel world</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Bitter:400,700">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/-Login-form-Page-BS4-.css">

</head>

<body class="bg-gradient-primary">
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-9 col-lg-12 col-xl-10">
            <div class="card shadow-lg o-hidden border-0 my-5">
                <div class="card-body p-0">
                    <div class="row">
                        <div class="col-lg-6 d-none d-lg-flex">
                            <div class="flex-grow-1 bg-login-image" style="background-image: url(&quot;/img/login.jpg&quot;);"></div>
                        </div>
                        <div class="col-lg-6">
                            <div class="p-5">
                                <div class="text-center">
                                    <h4 class="text-dark mb-4">Welcome To <span class="font-weight-bold">TRAVEL WORLD</span></h4>
                                </div>
                                <form class="user" action="${pageContext.request.contextPath}/login-processing", method="post">
                                    <div class="form-group"><input class="form-control form-control-user" type="text" id="exampleInputEmail" aria-describedby="emailHelp" placeholder="Enter Email..." name="username"></div>
                                    <div class="form-group"><input class="form-control form-control-user" type="password" id="exampleInputPassword" placeholder="Password" name="password"></div>
                                    <div class="form-group">

                                        <c:if test="${error == 'true'}">
                                            <div class="alert alert-danger" role="alert">
                                                <p>Wrong username or password</p>
                                            </div>
                                        </c:if>
                                    </div><button class="btn btn-primary btn-block text-white btn-user" type="submit">Login</button>
                                    <hr>
                                    <a href="/registration">Need an account? Sign up!</a>
                                    <hr>
                                </form>
                                <div class="text-center"></div>
                                <div class="text-center"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>