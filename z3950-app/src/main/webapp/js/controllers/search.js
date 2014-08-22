/**
 * Created by timur on 8/22/2014.
 */

var app = angular.module('z3950.controllers', []);


app.controller('SearchCtrl', function ($scope, $http, ngDialog,$modal) {
    $scope.formData = {maxResult: 10};
    $scope.importUUID = '';
    $scope.notFound = false;
    $scope.importDo = false;
    $scope.libraries = {};

    angular.element(document).ready(function () {
        $http({
            method: 'GET',
            url: '/z3950-app/rest/search/getFindLibraries',
            headers: { 'Content-Type': 'application/json' }  // set the headers so angular passing info as form data (not request payload)
        })
            .success(function (data) {
                console.log(data);
                $scope.libraries = data;
            })
            .error(function (data, status, headers, config) {
            });
    });

    $scope.searchOne = function(libraryId){
        $scope.formData.libraryId = libraryId;
        searchOneLibrary();
    };

    function searchOneLibrary() {
        $scope.termClass = 'searchTermProgress';
        $http({
            method: 'POST',
            url: '/z3950-app/rest/search/simpleSeacrh',
            data: $scope.formData,  // pass in data as strings
            headers: { 'Content-Type': 'application/json' }  // set the headers so angular passing info as form data (not request payload)
        })
            .success(function (data) {
                console.log(data);
                $scope.termClass = 'searchTermNormal';
                $scope.showMultiLib = false;
                $scope.books = data;
                $scope.notFound = data == null || data.length == 0;
            })
            .error(function (data, status, headers, config) {
                $scope.termClass = 'searchTermNormal';
            });
    }

    $scope.processForm = function () {

        $scope.librarySelected = [];
        $scope.showMultiLib = false;
        angular.forEach($scope.libraries, function (lib) {
            if (lib.useSearch) {
                $scope.librarySelected.push(lib);
            }
        });
        function searchMulti(simpleSearch) {
            $http({
                method: 'POST',
                url: '/z3950-app/rest/search/multiSeacrh',
                data: simpleSearch,  // pass in data as strings
                headers: { 'Content-Type': 'application/json' }  // set the headers so angular passing info as form data (not request payload)
            })
                .success(function (data) {
                    console.log(data);
//                    $scope.termClass = 'searchTermNormal';
                    angular.forEach($scope.librarySelected, function (lib) {
                        if (lib.id == data.libraryId) {
                            lib.countResult = data.countResult;
                            lib.load = false;
                        }
                    });
                })
                .error(function (data, status, headers, config) {
//                    $scope.termClass = 'searchTermNormal';
                    console.log(data + '\n' + status + '\n' + headers + '\n' + config);
                });
        }

        if ($scope.librarySelected.length > 1) {
            $scope.showMultiLib = true;
            angular.forEach($scope.librarySelected, function (lib) {
                $scope.formData.libraryId = lib.id;
                lib.load = true;
                searchMulti(angular.copy($scope.formData));
            });

        } else if ($scope.librarySelected.length == 1) {
            $scope.formData.libraryId = $scope.librarySelected[0].id;
            searchOneLibrary();
        }

//        searchOneLibrary();
    };



    $scope.importBook = function (book) {

        $scope.selectedBook = book;

        $scope.importDo = true;
        $http({
            method: 'POST',
            url: '/z3950-app/rest/search/importBook',
            data: book,  // pass in data as strings
            headers: { 'Content-Type': 'application/json' }  // set the headers so angular passing info as form data (not request payload)
        })
            .success(function (data) {
                console.log(data);
                $scope.importDo = false;
                if (data != null && data.length > 1) {
                    $scope.importUUID = data;
                    ngDialog.open({
                        template: 'secondDialog',
                        scope: $scope
                    });
                }else{
                    $scope.importUUID = null;
                    ngDialog.open({
                        template: '<h2>Импорт карточки</h2><p>Операция выполнена не успешна</p>',
                        plain: true
                    });
                }
//                ngDialog.cl
            })
            .error(function (data, status, headers, config) {
                $scope.importDo = false;
            });
    };
    $scope.showAdditional = function (book) {
        $scope.selectedBook = book;
        var modalInstance = $modal.open({
            templateUrl: 'partials/card.html',
            controller: 'CardCtrl',
            size: 'lg',
            resolve: {
                selectedBook: function () {
                    return $scope.selectedBook;
                }
            }});
    }

});
