angular.module('app').config(
        ['$stateProvider', '$urlRouterProvider', 'MODULE_CONFIG',
            function ($stateProvider, $urlRouterProvider, MODULE_CONFIG) {
                $stateProvider
                        .state('app.user', {
                            template: '<ui-view></ui-view>',
                            abstract: true,
                            data: {
                                title: 'User'
                            },
                            url: '/user',
                            resolve: $stateProvider.load(['/app/scripts/user-profile/UserService.js', '/app/scripts/user-profile/UserController.js'])
                        })
                        .state('app.user.profile', {
                            templateUrl: '/app/scripts/user-profile/user-profile-form.html',
                            controller: 'UserController',
                            data: {
                                title: 'Profile'
                            },
                            url: '/profile',
                        })
                        .state('app.user.password', {
                            url: "/password",
                            templateUrl: '/app/scripts/user-profile/user-password-form.html',
                            controller: 'UserController',
                            data: {
                                title: 'Password'
                            }
                        })
                        .state('app.admin', {
                            template: '<ui-view></ui-view>',
                            abstract: true,
                            data: {
                                title: 'Admin'
                            },
                            url: '/admin',
                            resolve: $stateProvider.load(['ui.select', '/app/scripts/app-admin/AdminService.js', '/app/scripts/app-admin/AdminController.js'])
                        })
                        .state('app.admin.addUser', {
                            templateUrl: '/app/scripts/app-admin/add-user.html',
                            controller: 'AdminController',
                            data: {
                                title: 'Add User'
                            },
                            url: '/addUser'
                        })
                        .state('app.admin.manageuser', {
                            templateUrl: '/app/scripts/app-admin/manage-user.html',
                            controller: 'AdminController',
                            data: {
                                title: 'Manage Users'
                            },
                            url: '/manageUsers'
                        })
            }]);