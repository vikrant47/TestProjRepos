var app = angular.module('app');
app.service('AuthService', ['ApplicationService', '$rootScope', function (ApplicationService, $rootScope) {
        var xthis = {
            currentUser: {},
            updateUserInfo: function (response) {
                $rootScope.currentUser = this.currentUser = response.data.modal;
            },
            init: function () {
                return ApplicationService.request({
                    url: '/user/info'
                }).then(function (response) {
                    xthis.updateUserInfo(response);
                    $rootScope.$broadcast("authservice.init");
                });
            },
            getCurrentUser: function () {
                var user = angular.extend({}, this.currentUser);
                user.roles = [];
                return user;
            },
            getRoles: function () {
                return this.currentUser.roles;
            }
        };
        return xthis;
    }]).run(['ApplicationService', 'AuthService', function (ApplicationService, AuthService) {
        ApplicationService.init();
        AuthService.init();
    }]);