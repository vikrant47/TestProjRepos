angular
.module('app')
.config(['$stateProvider', '$urlRouterProvider', '$ocLazyLoadProvider', '$breadcrumbProvider', function($stateProvider, $urlRouterProvider, $ocLazyLoadProvider, $breadcrumbProvider) {
  $stateProvider
  .state('app.icons', {
    url: "/icons",
    abstract: true,
    template: '<ui-view></ui-view>',
    ncyBreadcrumb: {
      label: 'Icons'
    }
  })
  .state('app.icons.fontawesome', {
    url: '/font-awesome',
    templateUrl: '/angular/app/views/icons/font-awesome.html',
    ncyBreadcrumb: {
      label: 'Font Awesome'
    }
  })
  .state('app.icons.simplelineicons', {
    url: '/simple-line-icons',
    templateUrl: '/angular/app/views/icons/simple-line-icons.html',
    ncyBreadcrumb: {
      label: 'Simple Line Icons'
    }
  })
  .state('app.components', {
    url: "/components",
    abstract: true,
    template: '<ui-view></ui-view>',
    ncyBreadcrumb: {
      label: 'Components'
    }
  })
  .state('app.components.buttons', {
    url: '/buttons',
    templateUrl: '/angular/app/views/components/buttons.html',
    ncyBreadcrumb: {
      label: 'Buttons'
    }   
  }).state('app.components.test', {
    url: '/test',
    templateUrl: '/angular/app/views/components/test.html',
    ncyBreadcrumb: {
      label: 'Buttons'
    }
  })
  .state('app.components.social-buttons', {
    url: '/social-buttons',
    templateUrl: '/angular/app/views/components/social-buttons.html',
    ncyBreadcrumb: {
      label: 'Social Buttons'
    }
  })
  .state('app.components.cards', {
    url: '/cards',
    templateUrl: '/angular/app/views/components/cards.html',
    ncyBreadcrumb: {
      label: 'Cards'
    }
  })
  .state('app.components.forms', {
    url: '/forms',
    templateUrl: '/angular/app/views/components/forms.html',
    ncyBreadcrumb: {
      label: 'Forms'
    }
  })
  .state('app.components.switches', {
    url: '/switches',
    templateUrl: '/angular/app/views/components/switches.html',
    ncyBreadcrumb: {
      label: 'Switches'
    }
  })
  .state('app.components.tables', {
    url: '/tables',
    templateUrl: '/angular/app/views/components/tables.html',
    ncyBreadcrumb: {
      label: 'Tables'
    }
  })
  .state('app.forms', {
    url: '/forms',
    templateUrl: '/angular/app/views/forms.html',
    ncyBreadcrumb: {
      label: 'Forms'
    },
    resolve: {
      loadPlugin: ['$ocLazyLoad', function ($ocLazyLoad) {
        return $ocLazyLoad.load([
          {
            serie: true,
            files: ['js/libs/moment.min.js']
          },
          {
            serie: true,
            files: ['js/libs/daterangepicker.min.js', 'js/libs/angular-daterangepicker.min.js']
          },
          {
            files: ['js/libs/mask.min.js']
          },
          {
            files: ['js/libs/select.min.js']
          }
        ]);
      }],
      loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
        // you can lazy load files for an existing module
        return $ocLazyLoad.load({
          files: ['/angular/app/controllers/forms.js']
        });
      }]
    }
  })
  .state('app.widgets', {
    url: '/widgets',
    templateUrl: '/angular/app/views/widgets.html',
    ncyBreadcrumb: {
      label: 'Widgets'
    },
    resolve: {
      loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
        // you can lazy load controllers
        return $ocLazyLoad.load({
          files: ['/angular/app/controllers/widgets.js']
        });
      }]
    }
  })
  .state('app.charts', {
    url: '/charts',
    templateUrl: '/angular/app/views/charts.html',
    ncyBreadcrumb: {
      label: 'Charts'
    },
    resolve: {
      // Plugins loaded before
      // loadPlugin: ['$ocLazyLoad', function ($ocLazyLoad) {
      //     return $ocLazyLoad.load([
      //         {
      //             serial: true,
      //             files: ['js/libs/Chart.min.js', 'js/libs/angular-chart.min.js']
      //         }
      //     ]);
      // }],
      loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
        // you can lazy load files for an existing module
        return $ocLazyLoad.load({
          files: ['/angular/app/controllers/charts.js']
        });
      }]
    }
  }).state('app.user', {
    url: "/user",
    abstract: true,
    template: '<ui-view></ui-view>',
    ncyBreadcrumb: {
      label: 'User'
    }
  }).state('app.user.profile', {
    url: "/profile",
    templateUrl: '/angular/app/user-profile/user-profile-form.html',
    controller:'UserController',
    ncyBreadcrumb: {
      label: 'Profile'
    },resolve: {
        loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
        // you can lazy load files for an existing module
        return $ocLazyLoad.load({
          files: ['/angular/app/user-profile/UserController.js']
        });
      }]
    }
  })
}]);
