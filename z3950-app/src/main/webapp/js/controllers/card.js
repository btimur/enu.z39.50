'use strict';
/**
 * Created by timur on 8/22/2014.
 */

angular.module('z3950.controllers').controller('CardCtrl', function ($scope, $http, $modalInstance, selectedBook) {

    $scope.selectedBook = selectedBook;

    $scope.loadMarc = function(){
        if($scope.selectedBook.marc != null){
            return;
        }
        $http({
            method: 'GET',
            url: '/z3950-app/rest/search/loadMarc',
            params: {libraryId : $scope.selectedBook.libraryId, id : $scope.selectedBook.id }
        })
            .success(function (data) {
                console.log(data);
                $scope.selectedBook.marc = data;
            })
            .error(function (data, status, headers, config) {
                console.log(data + '\n' + status + '\n' + headers + '\n' + config);
            });
    };

    $scope.loadDescr = function(){
        if($scope.selectedBook.attributes != null){
            return;
        }
        $http({
            method: 'GET',
            url: '/z3950-app/rest/search/loadDescr',
            params: {libraryId : $scope.selectedBook.libraryId, id : $scope.selectedBook.id }
        })
            .success(function (data) {
                console.log(data);
                $scope.selectedBook.attributes = data;
            })
            .error(function (data, status, headers, config) {
                console.log(data + '\n' + status + '\n' + headers + '\n' + config);
            });
    };


    $scope.close = function () {
        $modalInstance.close();
    };

});