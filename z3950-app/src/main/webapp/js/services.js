'use strict';

/* Services */

var services = angular.module('z3950.services', ['ngResource']);

//services.factory('ZSeacrhFactory', function ($resource) {
////    url = url || '/z3950/rest/jurnal/status';
//    return{
//        simpleSearch : function(pathUrl,$params){
//            return $resource(pathUrl, {}, {
//                query: {
//                    method: 'POST',
//                    params: $params,
//                    headers: {'Content-Type': 'application/json'}
//
//                }
//            })
//        }
//    }
//});
//var baseUrl = 'http://localhost\\:8080';

services.factory('LibrariesFactory', function ($resource) {
    return $resource('/z3950-app/rest/libraries', {}, {
        query: { method: 'GET', isArray: true },
        create: { method: 'POST' }
    })
});

services.factory('LibFactory', function ($resource) {
    return $resource( '/z3950-app/rest/libraries/:id', {}, {
        show: { method: 'GET' },
        update: { method: 'PUT', params: {id: '@id'} },
        delete: { method: 'DELETE', params: {id: '@id'} }
    })
});

services.factory('ExternalsFactory', function ($resource) {
    return $resource('/z3950-app/rest/externals', {}, {
        query: { method: 'GET', isArray: true },
        create: { method: 'POST' }
    })
});

services.factory('ExtFactory', function ($resource) {
    return $resource( '/z3950-app/rest/externals/:id', {}, {
        show: { method: 'GET' },
        update: { method: 'PUT', params: {id: '@id'} },
        delete: { method: 'DELETE', params: {id: '@id'} }
    })
});
