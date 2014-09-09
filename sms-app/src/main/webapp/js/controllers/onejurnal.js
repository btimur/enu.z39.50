/**
 * Created by admin on 8/24/2014.
 */
angular.module('smsapp.controllers').controller('ShowJurnalCtrl',
    function ($scope, $http, $modalInstance, selectedLib) {

        $scope.jurnal = angular.copy(selectedLib);

        $scope.cancelForm = function () {
            $modalInstance.dismiss('cancel');
        };

    });