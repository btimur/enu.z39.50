'use strict';

/* Services */

var services = angular.module('z3950.services', ['ngResource']);

services.factory('ZSeacrhFactory', function ($resource) {
//    url = url || '/z3950/rest/jurnal/status';
    return{
        simpleSearch : function(pathUrl,$params){
            return $resource(pathUrl, {}, {
                query: {
                    method: 'POST',
                    params: $params,
                    headers: {'Content-Type': 'application/json'}

                }
            })
        }
    }


});
