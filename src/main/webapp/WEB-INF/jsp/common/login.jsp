<%-- 
    Document   : register
    Created on : Aug 1, 2017, 9:05:55 PM
    Author     : Office
--%>
<!DOCTYPE html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <jsp:include page="../layout/head.jsp"/>
    </head>
    <body class="app header-fixed sidebar-fixed aside-menu-fixed aside-menu-hidden">


        <div class="app flex-row align-items-center ng-scope">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-md-5">
                        <div class="card-group mb-0">
                            <div class="card p-4">
                                <form action="/login"  method="post">
                                    <div class="card-block">
                                        <h1>Login</h1>
                                        <p class="text-muted">Sign In to your account</p>
                                        <div class="input-group mb-3">
                                            <span class="input-group-addon"><i class="icon-user"></i>
                                            </span>
                                            <input name="email" type="email" class="form-control" placeholder="Email">
                                        </div>
                                        <div class="input-group mb-4">
                                            <span class="input-group-addon"><i class="icon-lock"></i>
                                            </span>
                                            <input name="password" type="password" class="form-control" placeholder="Password">
                                        </div>
                                        <div class="row">
                                            <div class="col-6">
                                                <button type="submit" class="btn btn-primary px-4">Login</button>
                                            </div>
                                            <div class="col-6 text-right">
                                                <button type="button" class="btn btn-link px-0">Forgot password?</button>
                                            </div>
                                        </div>
                                    </div>
                                    <c:if test="${param.error}">
                                        <div class="row">
                                            <div class="col-xs-12">
                                                <p style="font-size: 20; color: #FF1C19;">Email or Password invalid, please verify</p>
                                            </div>
                                        </div>
                                    </c:if>
                                </form>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Bootstrap and necessary plugins -->
        <script src="/assets/bower_components/jquery/dist/jquery.min.js"></script>
        <script src="/assets/bower_components/tether/dist/js/tether.min.js"></script>
        <script src="/assets/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
    </body>
</html>