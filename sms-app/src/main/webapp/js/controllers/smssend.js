/**
 * Created by timur on 8/24/2014.
 */

var app = angular.module('smsapp.controllers', []), sendQueryMessage;

app.controller('SmsSendCtrl', function ($scope, $http) {
    $scope.hostPrefix = '';//http://localhost:8080';
    $scope.isDisabled = true;
    $scope.typemassage = 'info';
    $scope.alerts = [];
    $scope.contacts = [];
    $scope.userSendId = '0';
    $scope.isShowClearBtn = false;

    $scope.sendMessage = function () {
//        , phones: $scope.selectedUserForm.phones

       angular.forEach($scope.contacts,function(entry) {
            if(entry.phones==null || entry.phones.length==0)
            {
                $scope.alerts.push({ type: 'danger', msg: entry.fullName+ ': Отсутсвует номер телефон'});
                $scope.isShowClearBtn = true;
            }else
            {
                sendQueryMessage(entry.fullName, entry.userId);
            }
        });


    };
    sendQueryMessage = function(fullName, userSendId) {
        return  $http({
            method: 'GET',
            url: $scope.hostPrefix + '/sms-app/rest/smssend/sendMessage',
            params: {userId: userSendId, message: $scope.noticeText },
            headers: { 'Content-Type': 'application/json' },
            crossDomain: true
        })
            .success(function (data) {
                if (data.success == true) {
                    $scope.alerts.push({ type: 'success', msg: fullName+ ': Сообщение отправлено!'});
                } else {
                    $scope.alerts.push({ type: 'danger', msg: fullName+ ': Доставка сообщения не удалась!'});
                }

            });
    };
    $scope.clearAlert = function() {
        $scope.alerts = [];
        $scope.isShowClearBtn = false;
    };
    $scope.closeContacts = function(index) {
        $scope.contacts.splice(index, 1);
        if($scope.contacts==null || $scope.contacts.length==0)
        {
            $scope.isShowClearBtn = false;
        }
    };
    $scope.closeAlert = function (index) {
        $scope.alerts.splice(index, 1);
    };

    $scope.selectUserFio = function (userId, fio) {
        console.log(userId);
        $scope.userSendId = userId;
        var userForm;
        $http({
            method: 'GET',
            url: $scope.hostPrefix + '/sms-app/rest/smssend/getUserInfo',
            params: {userId: userId },
            headers: { 'Content-Type': 'application/json' },
            crossDomain: true
        })
            .success(function (data) {


                var selectedUserForm = data;
                selectedUserForm.fullName = fio;
                selectedUserForm.userId = userId;
                if (selectedUserForm.iin == null) {
                    selectedUserForm.iin = "Нет данных";

                }
                if (selectedUserForm.phones == null || selectedUserForm.phones.length==0) {
                    selectedUserForm.type = 'danger';
                } else {
                    selectedUserForm.type = 'info';
                    $scope.isDisabled = $scope.isDisabled && false;
                }
                $scope.contacts.push(selectedUserForm);
                $scope.selectUserByFio = null;
            })

        console.log(userForm);
    };

    $scope.getLocation = function (val) {

        return  $http({
            method: 'GET',
            url: $scope.hostPrefix + '/sms-app/rest/smssend/getListUser',
            params: {term: val },
            headers: { 'Content-Type': 'application/json' },
            crossDomain: true
        })
            .then(function (res) {
                return res.data;
            });

    };


});