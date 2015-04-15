'use strict';

/* Services */
jeminstalleApp.factory('MetricsService',function ($http,conf) {
    		return {
            get: function() {
                var promise = $http.get(conf.metrics_endpoint).then(function(response){
                    return response.data;
                });
                return promise;
            }
        };
    });
