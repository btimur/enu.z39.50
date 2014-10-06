/**
 * Created by timur on 10/3/14.
 */
angular.module('z3950.controllers').controller('OneExternalCtrl',
    function ($scope,  $modalInstance, ExternalsFactory) {

        $scope.ext = {dateAdd: new Date(),block: false, deleted :false, dateEnd: new Date()};
        $scope.ext.dateEnd.setDate($scope.ext.dateEnd.getDate() + 90);

        $scope.applyForm = function () {
            ExternalsFactory.create($scope.ext, function (data) {
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


    .controller('EditExtCtrl',
    function ($scope, $modalInstance, selectedExternal, ExtFactory) {

        $scope.ext = angular.copy(selectedExternal);

        $scope.applyForm = function () {
            var parametr = $scope.ext;
            ExtFactory.update({id: $scope.ext.id }, $scope.ext, function (data) {
                console.log(data);
                $modalInstance.close(data);
            });
        };

        $scope.cancelForm = function () {
            $modalInstance.dismiss('cancel');
        };

    });