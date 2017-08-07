var app = angular.module('app');
app.service('ApplicationService', ["$http", "$interpolate", "$rootScope", function ($http, $interpolate, $rootScope) {
        'use strict';
        return {
            init: function () {
                this.registerEvents();
            },
            registerEvents: function () {
                var xthis = this;
                var $on = $rootScope.$on;
                $rootScope.$on = function (events, fn) {
                    events = events.split(",");
                    for (var i = 0; i < events.length; i++) {
                        $on.call(this, events[i], fn);
                    }
                }
            },
            eval: function (expression, obj) {
                if (!obj) {
                    obj = this;
                }
                return $interpolate(expression)(obj);
            }
        }
    }]).service('AuthService', ['$http', '$rootScope', function ($http, $rootScope) {
        return {
            user: {},
            init: function () {
                return $http({
                    type: 'post',
                    url: '/user/info'
                }).then(function (response) {
                    $rootScope.user = this.user = response.data;
                    $rootScope.$broadcast("authservice.init");
                });                
            },
            getUser: function () {
                return this.user;
            },
            getRoles: function () {
                return this.user.roles;
            }
        };
    }]).run(['ApplicationService', 'AuthService', function (ApplicationService, AuthService) {
        ApplicationService.init();
        AuthService.init();
    }]);