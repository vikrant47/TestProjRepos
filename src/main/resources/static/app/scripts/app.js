'use strict';

/**
 * @ngdoc overview
 * @name app
 * @description
 * # app
 *
 * Main module of the application.
 */
angular.module('app', [
    'ngAnimate',
    'ngAria',
    'ngCookies',
    'ngMessages',
    'ngResource',
    'ngSanitize',
    'ngTouch',
    'ngMaterial',
    'ngStorage',
    'ngStore',
    'ui.router',
    'ui.utils',
    'ui.bootstrap',
    'ui.load',
    'ui.jp',
    'pascalprecht.translate',
    'oc.lazyLoad',
    'angular-loading-bar'
])
angular.module('app').service('ApplicationService', ["$http", "$interpolate", "$rootScope",
    function ($http, $interpolate, $rootScope) {
        return {
            init: function () {
                this.registerEvents();
            },
            loading: function (show) {
                $rootScope.showLoading = show;
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
            }, request: function (options) {
                var xthis = this;
                this.loading(true);
                return $http(options).then(function (response) {
                    if (response.data.error) {
                        //ModalService.error.open();
                    }
                    xthis.loading(false);
                    return response;
                });
            }
        }
    }]);
