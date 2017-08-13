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
    <body ng-app="app" class="ng-scope">
        <!-- uiView:  --><div class="app ng-scope" ui-view="" ng-controller="AppCtrl" style=""><div class="indigo bg-big ng-scope"><!-- uiView:  --><div ui-view="" class="fade-in-down smooth ng-scope">  <div class="center-block w-xxl w-auto-xs p-v-md ng-scope">
                        <div class="p-lg panel md-whiteframe-z1 text-color m">
                            <div class="m-b text-sm ng-binding">
                                Sign in with your Materil Account
                            </div>
                            <form action="/login" method = "post" name="form" class="ng-pristine ng-valid-email ng-invalid ng-invalid-required">
                                <div class="md-form-group float-label">
                                    <input type="email" class="md-input ng-pristine ng-valid-email ng-invalid ng-invalid-required ng-touched" name="email" required="" tabindex="0" aria-required="true" aria-invalid="true" style="">
                                    <label>Email</label>
                                </div>
                                <div class="md-form-group float-label">
                                    <input type="password" class="md-input ng-pristine ng-untouched ng-invalid ng-invalid-required" name="password" required="" tabindex="0" aria-required="true" aria-invalid="true">
                                    <label>Password</label>
                                </div>      
                                <div class="m-b-md">        
                                    <label class="md-check">
                                        <input type="checkbox"><i class="indigo"></i> Keep me signed in
                                    </label>
                                </div>
                                <button md-ink-ripple="" type="submit" class="md-btn md-raised pink btn-block p-h-md">Sign in<div class="md-ripple-container" style=""></div></button>
                                    <c:if test="${param.error}">
                                    <div class="m-b-md">
                                        <p style="font-size: 20; color: #FF1C19;">Email or Password invalid, please verify</p>
                                    </div>
                                </c:if>
                            </form>
                        </div>

                        <div class="p-v-lg text-center">
                            <div class="m-b"><button href="#forgotPsw" class="md-btn" href="#/access/forgot-password">Forgot password?</button></div>
                            <div>Do not have an account? <button href="#requestAccount" class="md-btn" href="#/access/signup">Request for account</button></div>
                        </div>
                    </div>
                </div></div></div>

        <div class="jvectormap-label"></div>
    </body>
</html>