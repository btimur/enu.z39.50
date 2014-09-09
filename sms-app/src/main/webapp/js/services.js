'use strict';

/* Services */

var services = angular.module('smsapp.services', ['ngResource']);

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

services.factory('SmsGatesFactory', function ($resource) {
    return $resource('/sms-app/rest/smsgate', {}, {
        query: { method: 'GET', isArray: true },
        create: { method: 'POST' }
    })
});


services.factory('SmsGateFactory', function ($resource) {
    return $resource( '/sms-app/rest/smsgate/:id', {}, {
        show: { method: 'GET' },
        update: { method: 'PUT', params: {id: '@id'} },
        delete: { method: 'DELETE', params: {id: '@id'} }
    })
});

services.factory('JurnalsFactory', function ($resource) {
    return $resource('/sms-app/rest/jurnal', {}, {
        query: { method: 'GET', isArray: true },
        create: { method: 'POST' }
    })
});
