/**
 * Created by admin on 8/24/2014.
 */
angular.module('smsapp.controllers').controller('ShowOrderCtrl',
    function ($scope, $http, $modalInstance, selectedLib) {

        $scope.order = angular.copy(selectedLib);

        $scope.cancelForm = function () {
            $modalInstance.dismiss('cancel');
        };

    });