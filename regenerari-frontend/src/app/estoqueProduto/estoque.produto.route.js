(function() {
  'use strict';
  angular
    .module('regenerari-frontend')
    .config(EstoqueProdutoRouterConfig);

  /** @ngInject */
  function EstoqueProdutoRouterConfig($stateProvider) {
    $stateProvider
      .state('estoqueProduto', {
        url: '/estoqueProduto',
        abstract: true,
        templateUrl: 'app/inicial/inicial.html',
        controller: 'InicialController',
        controllerAs: 'inicialController'
      });
    $stateProvider
      .state('estoqueProduto.sel', {
        url: '/estoqueprodutosel',
        parent: 'estoqueProduto',
        templateUrl: 'app/estoqueProduto/estoque-produto-sel.html',
        access: 'private'
      });

  }
})();
