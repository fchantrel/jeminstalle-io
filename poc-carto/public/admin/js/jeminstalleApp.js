/*
 * Main module of jeminstalle.io
 */
var jeminstalleApp = angular.module('jeminstalleApp',['ngRoute']);

// Routes
jeminstalleApp.config(['$routeProvider', function($routeProvider) {
                  $routeProvider
                    .when('/metrics', {templateUrl: 'admin/partials/metrics.html', controller: 'MetricsController'})
                    .when('/evaluation', {templateUrl: 'partials/evaluation.html', controller: 'evaluationCtrl'})
                    .otherwise({redirectTo: '/metrics'});
                  }]);

/*
 * Constant factory
 * Returns an object that contains all useful constant values
 */
jeminstalleApp.constant('conf', {
    'metrics_endpoint':'http://localhost:8080/advancedmetrics/',
    'jeminstalle_local':'http://localhost:8080/find?limit=5'
});