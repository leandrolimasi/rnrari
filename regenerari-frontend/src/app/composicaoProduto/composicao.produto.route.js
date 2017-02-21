(function() {
    'use strict';
    angular
        .module('regenerari-frontend')
        .config(ComposicaoProdutoRouterConfig);

    /** @ngInject */
    function ComposicaoProdutoRouterConfig($stateProvider) {
        $stateProvider
            .state('composicaoProduto', {
                url: '/composicaoproduto',
                abstract: true,
                templateUrl: 'app/inicial/inicial.html',
                controller: 'InicialController',
                controllerAs: 'inicialController'
            });
        $stateProvider
            .state('composicaoProduto.man', {
                url: '/composicaoproduto/:id',
                parent: 'composicaoProduto',
                templateUrl: 'app/composicaoProduto/composicao-produto-man.html',
                access: 'private'
            });
        $stateProvider
            .state('composicaoProduto.sel', {
                url: '/composicaoprodutosel',
                parent: 'composicaoProduto',
                templateUrl: 'app/composicaoProduto/composicao-produto-sel.html',
                access: 'private'
            });
    }
})();
