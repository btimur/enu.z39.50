/**
 * Created by timur on 8/24/2014.
 */

var app = angular.module('smsapp.controllers', []);

app.controller('JurnalsCtrl', function ($scope, JurnalsFactory, $modal) {

    $scope.alerts = [];

    JurnalsFactory.query({}, function (data) {
        $scope.jurnals = data;
    });


    $scope.showDetails = function (selectedGate) {
        var modalInstance = $modal.open({
            templateUrl: 'partials/onejurnal.html',
            controller: 'ShowJurnalCtrl',
            size: 'lg',
            resolve: {
                selectedLib: function () {
                    return selectedGate;
                }
            }
        });
    }

    $scope.closeAlert = function (index) {
        $scope.alerts.splice(index, 1);
    };

});