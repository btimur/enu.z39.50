/**
 * Created by timur on 8/24/2014.
 */
angular.module('z3950.controllers').controller('OneLibCtrl',
    function ($scope, $http, $modalInstance, LibrariesFactory) {

        $scope.lib = {queryType: 'PREFIX_QUERY',
            useSearch: true, encoding: 'UTF8', zFormat: 'RUSMARC', zport: 210, nameLib: 'новая'};

        $scope.applyForm = function () {
            LibrariesFactory.create($scope.lib, function (data) {
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


    .controller('EditLibCtrl',
    function ($scope, $http, $modalInstance, selectedLib, LibFactory) {

        $scope.lib = angular.copy(selectedLib);

        $scope.applyForm = function () {
            var parametr = $scope.lib;
            LibFactory.update({id: $scope.lib.id }, $scope.lib, function (data) {
                console.log(data);
                $modalInstance.close(data);
            });
        };

        $scope.cancelForm = function () {
            $modalInstance.dismiss('cancel');
        };

    });