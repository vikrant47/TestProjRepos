angular.module('app').controller('AdminController',
        ['$scope', '$rootScope', 'AdminService',
            function ($scope, $rootScope, AdminService) {
                $scope.roles = AdminService.getRoles();
                $scope.user = {};
                $scope.addUser = function () {
                    AdminService.addUser($scope.user)
                };
                $scope.updateUser = function () {
                    AdminService.updateUser($scope.user)
                };
            }]);