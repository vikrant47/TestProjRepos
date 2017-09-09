angular.module('app').controller('AdminController',
        ['$scope', '$rootScope', 'AdminService',
            function ($scope, $rootScope, AdminService) {
                $scope.roles = AdminService.getAllRoles();
                $scope.user = {};
                $scope.addUser = function () {
                    AdminService.addUser($scope.user)
                };
                $scope.updateUser = function () {
                    AdminService.updateUser($scope.user)
                };
                 $scope.users = AdminService.getAllUsers();
                 $scope.loadAllUsers = function () {
                    AdminService.loadAllUsers()
                };
                
            }]);