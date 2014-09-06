/**
 * Created by admin on 8/24/2014.
 */
angular.module('smsapp.controllers').controller('OneGateCtrl',
    function ($scope, $http, $modalInstance, SmsGatesFactory) {

        $scope.gate = {enabled: true, sCharset: 'UTF8', nameSms: 'новая'};

        $scope.applyForm = function () {
            SmsGatesFactory.create($scope.gate, function (data) {
                console.log(data);
                $modalInstance.close(data);
            });
        };

        $scope.cancelForm = function () {
            $modalInstance.dismiss('cancel');
        };

        $scope.okForm = function () {
            $modalInstance.close('ok');
        };
    })


    .controller('EditGateCtrl',
    function ($scope, $http, $modalInstance, selectedLib, SmsGateFactory) {

        $scope.gate = angular.copy(selectedLib);

        $scope.applyForm = function () {
            var parametr = $scope.gate;
            LibFactory.update({id: $scope.gate.id }, $scope.gate, function (data) {
                console.log(data);
                $modalInstance.close(data);
            });
        };

        $scope.cancelForm = function () {
            $modalInstance.dismiss('cancel');
        };

    });