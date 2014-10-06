/**
 * Created by timur on 10/3/14.
 */
var app = angular.module('z3950.controllers', []);


app.controller('ExternalCtrl', function ($scope, ExternalsFactory, $modal, ExtFactory) {

    $scope.alerts = [];

    ExternalsFactory.query({all:true}, function (data) {
        $scope.externals = data;
    });

    $scope.addLib = function () {
        var modalInstance = $modal.open({
            templateUrl: 'partials/onepwd.html',
            controller: 'OneExternalCtrl',
            size: 'lg'
        });
        modalInstance.result.then(function (ext) {
            $scope.externals.push(ext);
            $scope.alerts.push({ type: 'success', msg: 'Добавлен пользователь!'});
        }, function () {
//            $scope.alerts.push({ type: 'danger', msg: 'Операция выполнена не успешна!'});
        });
    };

    $scope.removeLib = function (selectedExt) {
        var modalInstance = $modal.open({
            templateUrl: 'myModalContent.html',
            controller: 'OneExternalCtrl',
            size: 'sm'
        });
        modalInstance.result.then(function () {
            ExtFactory.delete({id: selectedExt.id}, function(){
                $scope.alerts.push({ type: 'info', msg: 'Удален пользователь!'});
                $scope.externals = $scope.externals.filter(function(item) {
                    return item.id !== selectedExt.id;
                });
            });
        }, function () {
//            $scope.alerts.push({ type: 'danger', msg: 'Операция выполнена не успешна!'});
        });
    }

    $scope.editLib = function (selectedExt) {
        var modalInstance = $modal.open({
            templateUrl: 'partials/onepwd.html',
            controller: 'EditExtCtrl',
            size: 'lg',
            resolve: {
                selectedExternal: function () {
                    return selectedExt;
                }
            }
        });
        modalInstance.result.then(function (editExt) {
            $scope.externals.splice($scope.externals.indexOf(selectedExt), 1, editExt);
            $scope.alerts.push({ type: 'info', msg: 'Обновлены данные пользователя!'});
        }, function () {
//            $scope.alerts.push({ type: 'danger', msg: 'Операция выполнена не успешна!'});
        });
    }

    $scope.closeAlert = function (index) {
        $scope.alerts.splice(index, 1);
    };

});