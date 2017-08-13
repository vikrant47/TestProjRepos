
<!DOCTYPE html>
<html ng-app="app">
    <head>
        <jsp:include page="layout/head.jsp"></jsp:include>
        </head>
        <body ng-app="app">
            <div class="app" ui-view ng-controller="AppCtrl"></div>
        <jsp:include page="layout/foot.jsp"></jsp:include>
    </body>
</html>
