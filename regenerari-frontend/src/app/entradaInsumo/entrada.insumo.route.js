(function() {
  'use strict';
  angular
    .module('regenerari-frontend')
    .config(EntradaInsumoRouterConfig);

  /** @ngInject */
  function EntradaInsumoRouterConfig($stateProvider) {
    $stateProvider
      .state('entradaInsumo', {
        url: '/entradaInsumo',
        abstract: true,
        templateUrl: 'app/inicial/inicial.html',
        controller: 'InicialController',
        controllerAs: 'inicialController'
      });
    $stateProvider
      .state('entradaInsumo', {
        url: '/entradaInsumo/',
        parent: 'entradaInsumo',
        templateUrl: 'app/entradaInsumo/entrada-insumo.html',
        access: 'private'
      });

  }
})();
