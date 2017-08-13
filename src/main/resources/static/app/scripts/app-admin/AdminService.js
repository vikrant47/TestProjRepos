angular.module('app').service('AdminService', ['$rootScope', 'ApplicationService',
    function ($rootScope, ApplicationService) {
        var xthis = {
            roles: [],
            getRoles: function () {
                return this.roles;
            },
            init: function () {
                if (this.roles.length == 0) {
                    ApplicationService.request({
                        method: 'get',
                        url: '/appAdmin/roles/all'
                    }).then(function (response) {
                        angular.merge(xthis.roles,response.data.data);
                    });
                }

            },
            addUser: function (user) {
                return ApplicationService.request({
                    method: 'post',
                    url: '/admin/user/add',
                    data: user,
                }).then(function (response) {

                });
            },
            updateUser: function (user) {
                return ApplicationService.request({
                    method: 'post',
                    url: '/admin/user/update',
                    params: user,
                }).then(function (response) {

                });
            },
        };
        xthis.init();
        return xthis;
    }]);