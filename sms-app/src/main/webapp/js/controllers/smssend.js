/**
 * Created by timur on 8/24/2014.
 */

var app = angular.module('smsapp.controllers', []);

app.controller('SmsSendCtrl', function ($scope, $http, SmsSendFactory) {

    $scope.hostPrefix = '';//http://localhost:8080';
    $scope.isDisabled=true;

    $scope.sendMessage = function() {
        return  $http({
            method: 'GET',
            url: $scope.hostPrefix + '/sms-app/rest/smssend/sendMessage',
            params: {phones : $scope.selectedUserForm.phones, message: $scope.noticeText },
            headers: { 'Content-Type': 'application/json' },
            crossDomain: true
        })
            .success(function (data) {
                return  $scope.replyText =data.message;
            });

    };
        $scope.selectUserFio = function(userId) {
        console.log(userId);
        var userForm;
        $http({
            method: 'GET',
            url: $scope.hostPrefix + '/sms-app/rest/smssend/getUserInfo',
            params: {userId : userId },
            headers: { 'Content-Type': 'application/json' },
            crossDomain: true
        })
            .success(function (data) {
                $scope.selectedUserForm =data;
                if($scope.selectedUserForm.iin==null)
                {
                    $scope.selectedUserForm.iin="Нет данных";
                }
                if($scope.selectedUserForm.phones==null)
                {
                    $scope.selectedUserForm.phones="Нет данных";
                    $scope.isDisabled=true;
                }else{
                    $scope.isDisabled=false;
                }
            })

        console.log(userForm);
    };

    $scope.getLocation = function(val) {

        return  $http({
            method: 'GET',
            url: $scope.hostPrefix + '/sms-app/rest/smssend/getListUser',
            params: {term : val },
            headers: { 'Content-Type': 'application/json' },
            crossDomain: true
        })
            .then(function(res){
                return res.data;
            });

    };


});