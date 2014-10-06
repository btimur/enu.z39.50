'use strict';

// Declare app level module which depends on filters, and services
angular.module('z3950',
    [ 'z3950.controllers','z3950.services', 'ui.bootstrap', 'ngPasswordStrength'])
    .config(function (datepickerConfig) {
        datepickerConfig.showWeeks = false;
    })
;
