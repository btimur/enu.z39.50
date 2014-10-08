/**
 * Created by timur on 8/24/2014.
 */

var app = angular.module('smsapp.controllers', ['ngBootstrap'])
    .directive('myElement', function () {
        return {
            scope: {
                item: '=blah',
                showDetails: '&'
            },
            restrict: 'EA',
            template: '<td>{{item.dateofvidacha | date: "short"}}</td>' +
                '<td>{{item.srokvozvrata | date: "short"}}</td>' +
                '<td>{{item.nameofbook}}</td>' +
                '<td>{{item.fio}}</td>' +
                '<td>{{item.iin}}</td>' +
                '<td> <input type="checkbox" ng-model="item.executed" disabled="true"></td>' +
                '<td> <input type="checkbox" ng-model="item.sended" disabled="true"></td>' +
                '<td>{{item.countTry}}</td>' +
                '<td><a ng-click="$parent.showDetails({selectedId: item.id});"><span class="glyphicon glyphicon-info-sign"></span></a></td>'


        }

    }), searchSmsOrders;

app.controller('OrdersCtrl', function ($scope, $modal, $http) {
    $scope.hostPrefix = '';//http://localhost:8080';
    $scope.alerts = [];
    $scope.maxSize = 10;
    $scope.countRecord = 10;
    $scope.bigCurrentPage = 1;
    $scope.searchModel = '';


    $scope.$watch('myDateRange', function () {
        searchSmsOrders();
    })
    $scope.changeTerm = function (term) {
        $scope.searchModel = term;
        searchSmsOrders();
    };

    $scope.changed = function (pageNo) {
        $scope.bigCurrentPage = pageNo;
        searchSmsOrders();
    };

    $scope.ranges = {
        Сегодня: [new moment().startOf('day'), moment()],
        "Со вчера": [moment().subtract("days", 1), moment()],
        "7 дней назад": [moment().subtract("days", 7), moment()],
        "За этот месяц": [moment().subtract("days", 30), moment()],
        "За последний месяц": [moment().startOf("month"), moment().endOf("month")]}

    $scope.showDetails = function (selectedId) {
        console.log(selectedId);
        $http({
            method: 'GET',
            url: $scope.hostPrefix + '/sms-app/rest/order/' + selectedId.selectedId,
            headers: { 'Content-Type': 'application/json' },
            crossDomain: true
        })
            .success(function (data) {
                var selectedLib = data;
                var modalInstance = $modal.open({
                    templateUrl: 'partials/oneorder.html',
                    controller: 'ShowOrderCtrl',
                    size: 'lg',
                    resolve: {
                        selectedLib: function () {
                            return selectedLib;
                        }
                    }
                });
            })
            .error(function (data, status, headers, config) {
                $scope.termClass = 'searchTermNormal';
                $scope.pageLoad = false;
            });
    }

    $scope.closeAlert = function (index) {
        $scope.alerts.splice(index, 1);
    };


    $scope.startSync = function () {
        $http({
            method: 'POST',
            url: $scope.hostPrefix + '/sms-app/rest/order/startSync',
            headers: { 'Content-Type': 'application/json' },
            crossDomain: true
        })
    };

    searchSmsOrders = function () {
        if ($scope.myDateRange == null) {
            return;
        }
        var st = $scope.myDateRange.startDate;
        var end = $scope.myDateRange.endDate;
        end = end.add(1, "days").subtract("hours", 1);
        $scope.formData = {pageSize: $scope.maxSize, page: $scope.bigCurrentPage - 1, term: $scope.searchModel, beginDate: st, endDate: end};

        $http({
            method: 'POST',
            url: $scope.hostPrefix + '/sms-app/rest/order/searchOrders',
            data: $scope.formData,  // pass in data as strings
            headers: { 'Content-Type': 'application/json' },
            crossDomain: true
        })
            .success(function (data) {
                console.log(data);
                $scope.countRecord = data.countRecord;
                $scope.orders = data.smsOrders;

            })
            .error(function (data, status, headers, config) {
                $scope.termClass = 'searchTermNormal';
                $scope.pageLoad = false;
            });
    }


});
