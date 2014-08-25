'use strict';

// Declare app level module which depends on filters, and services
angular.module('z3950',
    [ 'z3950.controllers','z3950.services', 'ui.bootstrap', 'ngRoute', 'infinite-scroll'])

    .config(function ($routeProvider, $locationProvider) {
        $routeProvider.when('/', {templateUrl: 'index.html', controller: 'SearchCtrl'});
        $locationProvider.html5Mode(true);
    })

;
