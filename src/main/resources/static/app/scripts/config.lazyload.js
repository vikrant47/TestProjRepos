// lazyload config

angular.module('app')
  .constant('MODULE_CONFIG', [
      {
          name: 'ui.select',
          module: true,
          files: [
              '/assets/libs/angular/angular-ui-select/dist/select.min.js',
              '/assets/libs/angular/angular-ui-select/dist/select.min.css'
          ]
      },
      {
          name: 'textAngular',
          module: true,
          files: [
              '/assets/libs/angular/textAngular/dist/textAngular-sanitize.min.js',
              '/assets/libs/angular/textAngular/dist/textAngular.min.js'
          ]
      },
      {
          name: 'vr.directives.slider',
          module: true,
          files: [
              '/assets/libs/angular/venturocket-angular-slider/build/angular-slider.min.js',
              '/assets/libs/angular/venturocket-angular-slider/angular-slider.css'
          ]
      },
      {
          name: 'angularBootstrapNavTree',
          module: true,
          files: [
              '/assets/libs/angular/angular-bootstrap-nav-tree/dist/abn_tree_directive.js',
              '/assets/libs/angular/angular-bootstrap-nav-tree/dist/abn_tree.css'
          ]
      },
      {
          name: 'angularFileUpload',
          module: true,
          files: [
              '/assets/libs/angular/angular-file-upload/angular-file-upload.js'
          ]
      },
      {
          name: 'ngImgCrop',
          module: true,
          files: [
              '/assets/libs/angular/ngImgCrop/compile/minified/ng-img-crop.js',
              '/assets/libs/angular/ngImgCrop/compile/minified/ng-img-crop.css'
          ]
      },
      {
          name: 'smart-table',
          module: true,
          files: [
              '/assets/libs/angular/angular-smart-table/dist/smart-table.min.js'
          ]
      },
      {
          name: 'ui.map',
          module: true,
          files: [
              '/assets/libs/angular/angular-ui-map/ui-map.js'
          ]
      },
      {
          name: 'ngGrid',
          module: true,
          files: [
              '/assets/libs/angular/ng-grid/build/ng-grid.min.js',
              '/assets/libs/angular/ng-grid/ng-grid.min.css',
              '/assets/libs/angular/ng-grid/ng-grid.bootstrap.css'
          ]
      },
      {
          name: 'ui.grid',
          module: true,
          files: [
              '/assets/libs/angular/angular-ui-grid/ui-grid.min.js',
              '/assets/libs/angular/angular-ui-grid/ui-grid.min.css',
              '/assets/libs/angular/angular-ui-grid/ui-grid.bootstrap.css'
          ]
      },
      {
          name: 'xeditable',
          module: true,
          files: [
              '/assets/libs/angular/angular-xeditable/dist/js/xeditable.min.js',
              '/assets/libs/angular/angular-xeditable/dist/css/xeditable.css'
          ]
      },
      {
          name: 'smart-table',
          module: true,
          files: [
              '/assets/libs/angular/angular-smart-table/dist/smart-table.min.js'
          ]
      },
      {
          name: 'dataTable',
          module: false,
          files: [
              '/assets/libs/jquery/datatables/media/js/jquery.dataTables.min.js',
              '/assets/libs/jquery/plugins/integration/bootstrap/3/dataTables.bootstrap.js',
              '/assets/libs/jquery/plugins/integration/bootstrap/3/dataTables.bootstrap.css'
          ]
      },
      {
          name: 'footable',
          module: false,
          files: [
              '/assets/libs/jquery/footable/dist/footable.all.min.js',
              '/assets/libs/jquery/footable/css/footable.core.css'
          ]
      },
      {
          name: 'easyPieChart',
          module: false,
          files: [
              '/assets/libs/jquery/jquery.easy-pie-chart/dist/jquery.easypiechart.fill.js'
          ]
      },
      {
          name: 'sparkline',
          module: false,
          files: [
              '/assets/libs/jquery/jquery.sparkline/dist/jquery.sparkline.retina.js'
          ]
      },
      {
          name: 'plot',
          module: false,
          files: [
              '/assets/libs/jquery/flot/jquery.flot.js',
              '/assets/libs/jquery/flot/jquery.flot.resize.js',
              '/assets/libs/jquery/flot/jquery.flot.pie.js',
              '/assets/libs/jquery/flot.tooltip/js/jquery.flot.tooltip.min.js',
              '/assets/libs/jquery/flot-spline/js/jquery.flot.spline.min.js',
              '/assets/libs/jquery/flot.orderbars/js/jquery.flot.orderBars.js'
          ]
      },
      {
          name: 'vectorMap',
          module: false,
          files: [
              '/assets/libs/jquery/bower-jvectormap/jquery-jvectormap-1.2.2.min.js',
              '/assets/libs/jquery/bower-jvectormap/jquery-jvectormap.css', 
              '/assets/libs/jquery/bower-jvectormap/jquery-jvectormap-world-mill-en.js',
              '/assets/libs/jquery/bower-jvectormap/jquery-jvectormap-us-aea-en.js'
          ]
      },
      {
          name: 'moment',
          module: false,
          files: [
              '/assets/libs/jquery/moment/moment.js'
          ]
      }
    ]
  )
  .config(['$ocLazyLoadProvider', 'MODULE_CONFIG', function($ocLazyLoadProvider, MODULE_CONFIG) {
      $ocLazyLoadProvider.config({
          debug: false,
          events: false,
          modules: MODULE_CONFIG
      });
  }]);
