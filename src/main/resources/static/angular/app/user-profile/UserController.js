angular.module('app').controller('UserController',
        ['$scope', '$rootScope', 'ApplicationService', 'AuthService', 
            function ($scope, $rootScope, ApplicationService, AuthService) {
                $scope.userReplica = angular.extend({}, $rootScope.user);
            }]);