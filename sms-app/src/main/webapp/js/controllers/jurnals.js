/**
 * Created by timur on 8/24/2014.
 */

var app = angular.module('smsapp.controllers', []);

var beginStartDate = new Date();
var beginEndDate = new Date().setMonth(1);

$('#reportrange').daterangepicker(
    {
//        beginStartDate: moment().subtract('days', 29),
//        beginEndDate: moment(),
        minDate: '01/01/2012',
        maxDate: '12/31/2014',
        dateLimit: { days: 60 },
        showDropdowns: true,
        showWeekNumbers: true,
        timePicker: false,
        timePickerIncrement: 1,
        timePicker12Hour: true,
        ranges: {
            'Сегодня': [new Date(), new Date()],
            'Вчера': [new Date().setDate(1), new Date().setDate(1)],
            '7 дней назад': [new Date().setDate(6), new Date()],
            '30 дней назад': [new Date().setDate(29), new Date()],
            'За этот месяц': [new Date().setUTCMonth(new Date().getMonth(),1),  new Date()]
        },
        opens: 'left',
        buttonClasses: ['btn btn-default'],
        applyClass: 'btn-small btn-primary',
        cancelClass: 'btn-small',
        format: 'DD/MM/YYYY',
        separator: ' to ',
        locale: {
            applyLabel: 'Выбрать',
            fromLabel: 'От',
            toLabel: 'По',
            customRangeLabel: 'Иное',
            daysOfWeek: ['Вс', 'Пн', 'Вт', 'Ср', 'Чт', 'Пт', 'Сб'],
            monthNames: ['Январь', 'Февраль', 'Март', 'Апрель', 'Май', 'Июнь', 'Июль', 'Август', 'Сентябрь', 'Октябрь', 'Ноябрь', 'Декабрь'],
            firstDay: 1
        }
    },
    function (start, end) {
        console.log("Callback has been called!");
        $('#reportrange span').html(start.format('D MMMM YYYY') + ' - ' + end.format('D MMMM YYYY'));
        beginStartDate = start.format('MM/DD/YYYY');
        beginEndDate = end.format('MM/DD/YYYY');

    }

);

app.controller('JurnalsCtrl', function ($scope, JurnalsFactory, $modal) {

    $scope.alerts = [];

    JurnalsFactory.query({}, function (data) {
        $scope.jurnals = data;
    });


    $scope.showDetails = function (selectedGate) {
        var modalInstance = $modal.open({
            templateUrl: 'partials/onejurnal.html',
            controller: 'ShowJurnalCtrl',
            size: 'lg',
            resolve: {
                selectedLib: function () {
                    return selectedGate;
                }
            }
        });
    }

    $scope.closeAlert = function (index) {
        $scope.alerts.splice(index, 1);
    };

});