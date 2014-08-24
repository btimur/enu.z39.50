'use strict';
/**
 * Created by timur on 8/22/2014.
 */

angular.module('z3950.controllers').controller('CardCtrl', function ($scope, $http, $modalInstance, selectedBook) {

    $scope.selectedBook = selectedBook;

    $scope.loadMarc = function(){
        if($scope.selectedBook.marc != null){
            return;
        }
        $http({
            method: 'GET',
            url: '/z3950-app/rest/search/loadMarc',
            params: {libraryId : $scope.selectedBook.libraryId, id : $scope.selectedBook.id }
        })
            .success(function (data) {
               document.getElementById("loadDiv").style.display = 'none';
                var table = document.getElementById("marcTable");
                var rows = table.rows.length - 1;
                for(var i=0; i<rows; i++) {
                    table.deleteRow(1);
                }

                var inputData =  data.marc.split("\n");
                for(var i=0; i<inputData.length; i++) {
                    var val = inputData[i].trim();
                    var row = table.insertRow(table.rows.length);
                    var cell1 = row.insertCell(0);
                    var cell2 = row.insertCell(1);
                    var sep =val.indexOf('LEADER',0);
                    if(sep<0)
                    {
                        sep = 3;
                    }else
                    {
                        sep =6;
                    }
                    if(val.length>sep)
                    {
                        cell1.innerHTML ='<strong>'+val.substring(0,sep)+'</strong>';
                    }
                    if(val.length>sep+1)
                    {
                        cell2.innerHTML =val.substring(sep,val.length-sep-1);
                    }
                }
                console.log(data);
//                $scope.selectedBook.marc = data.marc;
            })
            .error(function (data, status, headers, config) {
                console.log(data + '\n' + status + '\n' + headers + '\n' + config);
            });
    };

    $scope.loadDescr = function(){
        if($scope.selectedBook.marc != null){
            return;
        }
        $http({
            method: 'GET',
            url: '/z3950-app/rest/search/loadDescr',
            params: {libraryId : $scope.selectedBook.libraryId, id : $scope.selectedBook.id }
        })
            .success(function (data) {
                console.log(data);
                $scope.selectedBook.attributes = data;
            })
            .error(function (data, status, headers, config) {
                console.log(data + '\n' + status + '\n' + headers + '\n' + config);
            });
    };


    $scope.close = function () {
        $modalInstance.close();
    };

});