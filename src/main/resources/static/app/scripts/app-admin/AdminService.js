angular.module('app').service('AdminService', ['$rootScope', 'ApplicationService', 'AuthService',
    function ($rootScope, ApplicationService, AuthService) {
        var xthis = {
            roles: [],
            users: [],
            getRoles: function () {
                return this.roles;
            },
            init: function () {
                if (this.roles.length == 0) {
                    ApplicationService.request({
                        method: 'get',
                        url: '/appAdmin/roles/all'
                    }).then(function (response) {
                        angular.merge(xthis.roles, response.data.modal);
                    });
                }

            },
            addUser: function (user) {
                return ApplicationService.request({
                    method: 'post',
                    url: '/appAdmin/user/add',
                    data: user,
                }).then(function (response) {

                });
            },
            updateUser: function (user) {
                return ApplicationService.request({
                    method: 'post',
                    url: '/appAdmin/user/update',
                    data: user,
                }).then(function (response) {

                });
            },
            getAllUsers: function () {
                return this.users;
            },
            loadAllUsers: function () {
                return ApplicationService.request({
                    method: 'get',
                    url: '/appAdmin/user/all'
                }).then(function (response) {
                       angular.merge(xthis.users,response.data.modal);
                });
            },
        };
        xthis.init();
        return xthis;
    }]);