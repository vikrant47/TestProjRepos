angular.module('app').service('UserService', ['$rootScope', 'ApplicationService', 'AuthService',
    function ($rootScope, ApplicationService, AuthService) {
        return {
            updateProfile: function ($scope) {
                return ApplicationService.request({
                    method: 'post',
                    url: '/user/profile/update',
                    data: $scope.user,
                }).then(function (response) {
                    AuthService.updateUserInfo(response);
                });
            }, updatePassword: function ($scope) {
                return ApplicationService.request({
                    method: 'post',
                    url: '/user/password/update',
                    data: {password: $scope.user.password, newPassword: $scope.user.newPassword},
                }).then(function (response) {
                    AuthService.updateUserInfo(response);
                });
            },
        };
    }]);