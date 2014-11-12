'use strict';

/* Services */

var services = angular.module('sportapp.services', ['ngResource']);

services.factory('FederationFactory', function ($resource) {
    return $resource('/reports/rest/federation', {}, {
        query: { method: 'GET'}
    })
});

services.factory('RegionFactory', function ($resource) {
    return $resource('/reports/rest/region', {}, {
        query: { method: 'GET'}
    })
});


