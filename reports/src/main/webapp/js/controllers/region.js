/**
 * Created by timur on 8/24/2014.
 */

var app = angular.module('sportapp.controllers', [], function($locationProvider)
{
    $locationProvider.html5Mode(true);
});

app.controller('regionCtrl', function ($scope, RegionFactory, $location) {
    $scope.hostPrefix = '';//http://localhost:8080';

    $scope.target = $location.search()['dataUUID'];
    $scope.regionIndex = $location.search()['region'];
    console.log($scope.target);

    RegionFactory.query({id: $scope.target, region: $scope.regionIndex}, function (data) {
        $scope.title = data.name;
        $scope.categories = data.categoryReports;

    });
    var replaceAll = function (find, replace, str) {
        while (str.indexOf(find) > -1) {

            str = str.replace(find, replace);
        }
        return str;
    };
    $scope.exportData = function () {
        var fedHtml = replaceAll("<th rowspan", "<th style=\"border:1px solid black;\" rowspan",document.getElementById('exportable').innerHTML);
        fedHtml = replaceAll("<th colspan", "<th style=\"border:1px solid black;\" colspan",fedHtml);
        fedHtml = replaceAll("<td class", "<td style=\"border:1px solid black;\" class",fedHtml);
        fedHtml = replaceAll("<th>", "<th style=\"border:1px solid black;\" >",fedHtml);
        fedHtml = replaceAll("<td style=\"text-align: left\"", "<td style=\"border:1px solid black;\" class",fedHtml);

        var blob = new Blob([fedHtml], {
            type: "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=windows-1251"
        });
        saveAs(blob, "Report.xls");
    };

});