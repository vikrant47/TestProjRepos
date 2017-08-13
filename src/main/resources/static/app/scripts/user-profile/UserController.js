angular.module('app').controller('UserController',
        ['$scope', '$rootScope', 'UserService','AuthService',
            function ($scope, $rootScope, UserService,AuthService) {
                $scope.user = angular.extend({}, AuthService.getCurrentUser());
                $scope.updateUserProfile = function () {
                    UserService.updateProfile($scope);
                }
                $scope.updatePassword = function () {
                    UserService.updatePassword($scope);
                }
            }]);