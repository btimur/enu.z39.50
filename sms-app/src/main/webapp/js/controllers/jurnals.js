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
            template: '<td>{{item.dateSend | date: "short"}}</td>' +
                '<td>{{item.orderBookName}}</td>' +
                '<td>{{item.fio}}</td>' +
                '<td>{{item.iin}}</td>' +
                '<td>{{item.phone}}</td>' +
                '<td>{{item.result}}</td>' +

                '<td><a ng-click="$parent.showDetails({selectedId: item.id});"><span class="glyphicon glyphicon-info-sign"></span></a></td>'

        }

    });

app.controller('JurnalsCtrl', function ($scope, JurnalsFactory, $modal, $http) {
    $scope.hostPrefix = '';//http://localhost:8080';
    $scope.alerts = [];
    $scope.maxSize = 10;
    $scope.countRecord = 10;
    $scope.bigCurrentPage = 1;
    $scope.searchModel = '';



    $scope.$watch('myDateRange', function () {
        searchJunrals();
    })
    $scope.changeTerm = function (term) {
        $scope.searchModel=term;
        searchJunrals();
    };

    $scope.changed = function (pageNo) {
        $scope.bigCurrentPage = pageNo;
        searchJunrals();
    };

//    $scope.pageChanged = function() {
//        console.log('Page changed to: ' + $scope.bigCurrentPage);
//    };

   /* $scope.setPage = function (pageNo) {
        $scope.currentPage = pageNo;
    };

    $scope.pageChanged = function() {
        console.log('current');
        searchJunrals();
    };*/

    $scope.ranges = {
        Сегодня: [new moment().startOf('day'), moment()],
        "Со вчера": [moment().subtract("days", 1), moment()],
        "7 дней назад": [moment().subtract("days", 7), moment()],
        "За этот месяц": [moment().subtract("days", 30), moment()],
        "За последний месяц": [moment().startOf("month"), moment().endOf("month")]}

    JurnalsFactory.query({}, function (data) {
//        $scope.jurnals = data;
    });
    $scope.showDetails = function (selectedId) {
        console.log(selectedId);
        $http({
            method: 'GET',
            url: $scope.hostPrefix + '/sms-app/rest/jurnal/'+selectedId.selectedId,
            headers: { 'Content-Type': 'application/json' },
            crossDomain: true
        })
            .success(function (data) {
                var selectedLib = data;
                var modalInstance = $modal.open({
                    templateUrl: 'partials/onejurnal.html',
                    controller: 'ShowJurnalCtrl',
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


    searchJunrals = function () {
        if ($scope.myDateRange == null) {
            return;
        }
        var st = $scope.myDateRange.startDate;
        var end = $scope.myDateRange.endDate;
        end = end.add(1,"days").subtract("hours", 1);
        $scope.formData = {pageSize:   $scope.maxSize ,page: $scope.bigCurrentPage-1, term: $scope.searchModel, beginDate: st, endDate: end};

        $http({
            method: 'POST',
            url: $scope.hostPrefix + '/sms-app/rest/jurnal/searchJurnals',
            data: $scope.formData,  // pass in data as strings
            headers: { 'Content-Type': 'application/json' },
            crossDomain: true
        })
            .success(function (data) {
                console.log(data);
                $scope.countRecord =data.countRecord;
                $scope.jurnals = data.jurnals;

            })
            .error(function (data, status, headers, config) {
                $scope.termClass = 'searchTermNormal';
                $scope.pageLoad = false;
            });
    }


});
