'use strict';

// Declare app level module which depends on filters, and services
angular.module('ocrapp',
    [ 'ocrapp.controllers', 'flow'])
    .config(['flowFactoryProvider', function (flowFactoryProvider) {
        flowFactoryProvider.defaults = {
            permanentErrors: [404, 500, 501],
            testChunks: false,
            maxChunkRetries: 1,
            chunkRetryInterval: 5000,
            simultaneousUploads: 4,
            singleFile: false
        };
        flowFactoryProvider.on('catchAll', function (event) {
            console.log('catchAll', arguments);
        });
        // Can be used with different implementations of Flow.js
        // flowFactoryProvider.factory = fustyFlowFactory;
    }]);