(function() {
    'use strict';
    angular
        .module('regenerari-frontend')
        .config(InsumoRouterConfig);

    /** @ngInject */
    function InsumoRouterConfig($stateProvider) {
        $stateProvider
            .state('insumo', {
                url: '/insumo',
                abstract: true,
                templateUrl: 'app/inicial/inicial.html',
                controller: 'InicialController',
                controllerAs: 'inicialController'
            });
        $stateProvider
            .state('insumo.man', {
                url: '/insumoman/:id',
                parent: 'insumo',
                templateUrl: 'app/insumo/insumo-man.html',
                access: 'private'
            });
        $stateProvider
            .state('insumo.sel', {
                url: '/insumosel',
                parent: 'insumo',
                templateUrl: 'app/insumo/insumo-sel.html',
                access: 'private'
            });
    }
})();
