/**
 * Created by timur on 8/24/2014.
 */

var app = angular.module('z3950.controllers', []);


app.controller('LibrariesCtrl', function ($scope, LibrariesFactory, LibFactory, $modal) {

    $scope.alerts = [];

    LibrariesFactory.query({}, function (data) {
        $scope.libraries = data;
    });

    $scope.addLib = function () {
        var modalInstance = $modal.open({
            templateUrl: 'partials/onelib.html',
            controller: 'OneLibCtrl',
            size: 'lg'
        });
        modalInstance.result.then(function (lib) {
            $scope.libraries.push(lib);
            $scope.alerts.push({ type: 'success', msg: 'Добавлена библиотека!'});
        }, function () {
//            $scope.alerts.push({ type: 'danger', msg: 'Операция выполнена не успешна!'});
        });
    };

    $scope.removeLib = function (selectedLib) {
        var modalInstance = $modal.open({
            templateUrl: 'myModalContent.html',
            controller: 'OneLibCtrl',
            size: 'sm'
        });
        modalInstance.result.then(function () {
            LibFactory.delete({id: selectedLib.id}, function(){
                $scope.alerts.push({ type: 'info', msg: 'Удалена библиотека!'});
                $scope.libraries = $scope.libraries.filter(function(item) {
                    return item.id !== selectedLib.id;
                });
            });
        }, function () {
//            $scope.alerts.push({ type: 'danger', msg: 'Операция выполнена не успешна!'});
        });
    }

    $scope.editLib = function ($selectedLib) {
        var modalInstance = $modal.open({
            templateUrl: 'partials/onelib.html',
            controller: 'EditLibCtrl',
            size: 'lg',
            resolve: {
                selectedLib: function () {
                    return $selectedLib;
                }
            }
        });
        modalInstance.result.then(function (editLib) {
            $scope.libraries.splice($scope.libraries.indexOf($selectedLib), 1, editLib);
            $scope.alerts.push({ type: 'info', msg: 'Обновлены данные библиотеки!'});
        }, function () {
//            $scope.alerts.push({ type: 'danger', msg: 'Операция выполнена не успешна!'});
        });
    }

    $scope.closeAlert = function (index) {
        $scope.alerts.splice(index, 1);
    };

});