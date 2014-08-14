'use strict';

/* Controllers */


var app = angular.module('z3950.controllers', []);


app.controller('SearchCtrl', function ($scope,  $http) {
    $scope.formData = {};
    $scope.processForm = function () {
//        var $params =
//        ZSeacrhFactory.simpleSearch('/enu-z3950/rest/search/simpleSeacrh',$scope.formData, function (result1) {
//            console.log('search z3950');
//            $scope.message = result1;
//        });
        $scope.termClass = 'searchTermProgress';

        $http({
            method  : 'POST',
            url     : '/z3950-app/rest/search/simpleSeacrh',
            data    : $scope.formData,  // pass in data as strings
            headers : { 'Content-Type': 'application/json' }  // set the headers so angular passing info as form data (not request payload)
        })
            .success(function(data) {
                console.log(data);
                $scope.termClass = 'searchTermNormal';
                $scope.books = data;
//                if (!data.success) {
//                    // if not successful, bind errors to error variables
//                    $scope.message = data.errors.name;
////                    $scope.errorSuperhero = data.errors.superheroAlias;
//                } else {
//                    // if successful, bind success message to message
//                    $scope.message = data.message;
//                }
            });

    };

});
