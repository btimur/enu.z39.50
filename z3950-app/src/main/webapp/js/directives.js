'use strict';

/* Directives */


//angular.module('ngdemo.directives', []).
//  directive('appVersion', ['version', function(version) {
//    return function(scope, elm, attrs) {
//      elm.text(version);
//    };
//  }]);

angular.module('z3950.controllers').directive('whenScrolled', function ($window) {
    return function (scope, element, attrs) {
        var $myWindow = angular.element($window);
        var raw = element[0];
        $myWindow.bind('scroll',
            function () {
               console.log(raw.scrollTop + raw.offsetHeight);
               console.log(raw.scrollHeight);
                if (raw.scrollTop + raw.offsetHeight >= raw.scrollHeight) {
                    scope.$apply(attr.whenScrolled);
                }
//
//                var elementHeight = element.height();
//                var scrollAmount = $myWindow.scrollTop();
//                var delta = 10;
//                if (elementHeight - (scrollAmount + delta) < 0) {
//                    scope.$apply(attrs.whenScrolled);
//                }
            });
    };
});
