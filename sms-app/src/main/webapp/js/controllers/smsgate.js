/**
 * Created by timur on 8/24/2014.
 */

var app = angular.module('smsapp.controllers', []);


app.controller('SmsGatesCtrl', function ($scope, SmsGatesFactory, SmsGateFactory, $modal) {

    $scope.alerts = [];

    SmsGatesFactory.query({}, function (data) {
        $scope.gates = data;
    });

    $scope.addGate = function () {
        var modalInstance = $modal.open({
            templateUrl: 'partials/onegate.html',
            controller: 'OneGateCtrl',
            size: 'lg'
        });
        modalInstance.result.then(function (gate) {
            $scope.smsgate.push(gate);
            $scope.alerts.push({ type: 'success', msg: 'Добавлена сообщение!'});
        }, function () {
//            $scope.alerts.push({ type: 'danger', msg: 'Операция выполнена не успешна!'});
        });
    };

    $scope.removeGate = function (selectedGate) {
        var modalInstance = $modal.open({
            templateUrl: 'myModalContent.html',
            controller: 'OneGateCtrl',
            size: 'sm'
        });
        modalInstance.result.then(function () {
            SmsGateFactory.delete({id: selectedGate.id}, function(){
                $scope.alerts.push({ type: 'info', msg: 'Удалена сообщение!'});
                $scope.gates = $scope.gates.filter(function(item) {
                    return item.id !== selectedGate.id;
                });
            });
        }, function () {
//            $scope.alerts.push({ type: 'danger', msg: 'Операция выполнена не успешна!'});
        });
    }

    $scope.editGate = function (selectedGate) {
        var modalInstance = $modal.open({
            templateUrl: 'partials/onegate.html',
            controller: 'EditGateCtrl',
            size: 'lg',
            resolve: {
                selectedLib: function () {
                    return selectedGate;
                }
            }
        });
        modalInstance.result.then(function (editLib) {
            $scope.gates.splice($scope.gates.indexOf($selectedGate), 1, editLib);
            $scope.alerts.push({ type: 'info', msg: 'Обновлены данные сообщении!'});
        }, function () {
//            $scope.alerts.push({ type: 'danger', msg: 'Операция выполнена не успешна!'});
        });
    }

    $scope.closeAlert = function (index) {
        $scope.alerts.splice(index, 1);
    };

});