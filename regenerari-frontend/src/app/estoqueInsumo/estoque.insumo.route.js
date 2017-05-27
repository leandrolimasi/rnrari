(function() {
  'use strict';
  angular
    .module('regenerari-frontend')
    .config(EstoqueInsumoRouterConfig);

  /** @ngInject */
  function EstoqueInsumoRouterConfig($stateProvider) {
    $stateProvider
      .state('estoqueInsumo', {
        url: '/estoqueinsumo',
        abstract: true,
        templateUrl: 'app/inicial/inicial.html',
        controller: 'InicialController',
        controllerAs: 'inicialController'
      });
    $stateProvider
      .state('estoqueInsumo.sel', {
        url: '/estoqueinsumosel',
        parent: 'estoqueInsumo',
        templateUrl: 'app/estoqueInsumo/estoque-insumo-sel.html',
        access: 'private'
      });

  }
})();
