/**
 * Created by timur on 8/22/2014.
 */

var app = angular.module('z3950.controllers', []);


app.controller('SearchCtrl', function ($scope, LibrariesFactory, $http, $modal, $location, $window) {
    $scope.hostPrefix = '';//http://localhost:8080';
    $scope.dataUUID = $location.search()['dataUUID'];
    $scope.formData = {
        maxResult: 10,
        term: $location.search()['isbn'],
        nextElement: 0,
        booktype: "educational.registry.uuid"};
    $scope.importUUID = '';
    $scope.notFound = false;
    $scope.importDo = false;
    $scope.libraries = {};
    $scope.alerts = [];

    LibrariesFactory.query({}, function (data) {
        $scope.libraries = data;
    });

    $scope.loadBooks = function () {
        if (!angular.isUndefined($scope.books) && $scope.resultCount > $scope.books.length){
            $scope.formData.nextElement = $scope.books.length;
            searchOneLibrary();
        }
    };

    $scope.searchOne = function (libraryId) {
        $scope.formData.libraryId = libraryId;
        searchOneLibrary();
    };

    function searchOneLibrary() {
        $scope.termClass = 'searchTermProgress';
        $scope.pageLoad = true;
        if ($scope.formData.nextElement == 0) {
            $scope.books = [];
        }
        $http({
            method: 'POST',
            url: $scope.hostPrefix + '/z3950-app/rest/search/simpleSeacrh',
            data: $scope.formData,  // pass in data as strings
            headers: { 'Content-Type': 'application/json' },
            crossDomain: true
        })
            .success(function (data) {
                console.log(data);
                $scope.termClass = 'searchTermNormal';
                $scope.showMultiLib = false;
                $scope.books.push.apply($scope.books, data.books);
                $scope.resultCount = data.count;
                $scope.notFound = data.count == 0;
                $scope.pageLoad = false;
            })
            .error(function (data, status, headers, config) {
                $scope.termClass = 'searchTermNormal';
                $scope.pageLoad = false;
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
            $scope.formData.nextElement = 0;
            $scope.resultCount = 0;
            $http({
                method: 'POST',
                url: $scope.hostPrefix + '/z3950-app/rest/search/multiSeacrh',
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


    function redirectToPortal(data) {
        var destinationUrl = '/manage/forms/small/edit/' + data;
        $window.location.href = destinationUrl;
        $window.open(destinationUrl);
//        $window.location.reload();
    }

    $scope.importBook = function (book) {

        book.dataUUID = $scope.dataUUID;
        $scope.selectedBook = book;


        $scope.importDo = true;
        $http({
            method: 'POST',
            url: $scope.hostPrefix + '/z3950-app/rest/search/importBook',
            data: {id: book.id, libraryId: book.libraryId, booktype: $scope.formData.booktype},  // dataUUID: $scope.dataUUID,
            headers: { 'Content-Type': 'application/json' }  // set the headers so angular passing info as form data (not request payload)
        })
            .success(function (data) {
                console.log(data);
                $scope.importDo = false;
                if (data != null && data !== 'error') {
                    $scope.alerts.push({ type: 'success', msg: 'Импорт карточки успешно произведен!'});
                    redirectToPortal(data);
                } else {
                    $scope.alerts.push({type: 'danger', msg: 'Операция выполнена не успешна!'});
                }

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

    $scope.closeAlert = function (index) {
        $scope.alerts.splice(index, 1);
    };


});
