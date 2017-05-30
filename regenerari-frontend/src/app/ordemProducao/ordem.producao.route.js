(function() {
    'use strict';
    angular
        .module('regenerari-frontend')
        .config(OrdemProducaoRouterConfig);

    /** @ngInject */
    function OrdemProducaoRouterConfig($stateProvider) {
        $stateProvider
            .state('ordemProducao', {
                url: '/ordem-producao',
                abstract: true,
                templateUrl: 'app/inicial/inicial.html',
                controller: 'InicialController',
                controllerAs: 'inicialController'
            });
        $stateProvider
            .state('ordemProducao.man', {
                url: '/ordem-producao/:id',
                parent: 'ordemProducao',
                templateUrl: 'app/ordemProducao/ordem-producao-man.html',
                access: 'private'
            });
        $stateProvider
            .state('ordemProducao.sel', {
                url: '/ordem-producao-sel',
                parent: 'ordemProducao',
                templateUrl: 'app/ordemProducao/ordem-producao-sel.html',
                access: 'private'
            });
    }
})();
