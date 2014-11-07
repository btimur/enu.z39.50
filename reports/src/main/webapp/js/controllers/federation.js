/**
 * Created by timur on 8/24/2014.
 */

var app = angular.module('sportapp.controllers', [], function($locationProvider)
{
    $locationProvider.html5Mode(true);
});

app.controller('federationCtrl', function ($scope, FederationFactory, $http, $location) {
    $scope.hostPrefix ='';//http://localhost:8080';
    $scope.target = $location.search()['dataUUID'];
    console.log($scope.target);
    $scope.isViewButton = true;

    FederationFactory.query({id: $scope.target}, function (data) {
        $scope.title = data.name;
        $scope.categories = data.categoryReports;
        $scope.isViewButton = data.isConfederation;
        $scope.fdTitle = data.fdTitle;
        $scope.records = data.records;
        $scope.fdRegion = data.fdRegion;
    });
    $scope.classView = "region";
    $scope.titleView = "По федерациям";
    $scope.isRegion = false;
    $scope.changeView = function () {
        if ($scope.classView === "region") {
            $scope.titleView = "По обалстям";
            $scope.classView = "fed";
            $scope.isRegion = true;
        }
        else {
            $scope.classView = "region";
            $scope.titleView = "По федерациям";
            $scope.isRegion = false;
        }
    };

    var replaceAll = function (find, replace, str) {
            while (str.indexOf(find) > -1) {

                str = str.replace(find, replace);
            }
            return str;
    };
    $scope.exportData = function () {
        var blob;

        var fedHtml = replaceAll("<th rowspan", "<th style=\"border:1px solid black;\" rowspan",document.getElementById('exportableFed').innerHTML);
        fedHtml = replaceAll("<th colspan", "<th style=\"border:1px solid black;\" colspan",fedHtml);
        fedHtml = replaceAll("<td class", "<td style=\"border:1px solid black;\" class",fedHtml);
        fedHtml = replaceAll("<th>", "<th style=\"border:1px solid black;\" >",fedHtml);
        fedHtml = replaceAll("<td style=\"text-align: left\"", "<td style=\"border:1px solid black;\" class",fedHtml);

        var regHtml = replaceAll("<td ng-repeat", "<td style=\"border:1px solid black;\" ng-repeat",document.getElementById('exportableReg').innerHTML);
        regHtml = replaceAll("<td style=\"text-align: left\"", "<td style=\"border:1px solid black;\" class",regHtml);
        regHtml = replaceAll("<th data", "<th style=\"border:1px solid black;\" data",regHtml);

        if ($scope.classView != "region") {
            blob = new Blob([regHtml], {
                type: "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=windows-1251"
            });
        } else {
            blob = new Blob([fedHtml], {
                type: "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=windows-1251"
            });
        }
        saveAs(blob, "Report.xls");
    };

    $scope.keys = function (obj) {
        return obj ? Object.keys(obj) : [];
    }
    $scope.syncData = function () {
        console.log('start');
        return  $http({
            method: 'GET',
            url: $scope.hostPrefix + '/reports/rest/federation/syncData',
            headers: { 'Content-Type': 'application/json' },
            crossDomain: true
        })
            .success(function (data) {
            });
    };
});