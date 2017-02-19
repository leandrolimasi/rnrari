(function() {
    'use strict';
    angular
        .module('regenerari-frontend')
        .config(ProdutoRouterConfig);

    /** @ngInject */
    function ProdutoRouterConfig($stateProvider) {
        $stateProvider
            .state('produto', {
                url: '/produto',
                abstract: true,
                templateUrl: 'app/inicial/inicial.html',
                controller: 'InicialController',
                controllerAs: 'inicialController'
            });
        $stateProvider
            .state('produto.man', {
                url: '/produto/:id',
                parent: 'produto',
                templateUrl: 'app/produto/produto-man.html',
                access: 'private'
            });
        $stateProvider
            .state('produto.sel', {
                url: '/produtosel',
                parent: 'produto',
                templateUrl: 'app/produto/produto-sel.html',
                access: 'private'
            });
    }
})();
