(function() {
  'use strict';
  angular
    .module('regenerari-frontend')
    .config(EntradaInsumoRouterConfig);

  /** @ngInject */
  function EntradaInsumoRouterConfig($stateProvider) {
    $stateProvider
      .state('entradaInsumo', {
        url: '/entradainsumo',
        abstract: true,
        templateUrl: 'app/inicial/inicial.html',
        controller: 'InicialController',
        controllerAs: 'inicialController'
      });
    $stateProvider
      .state('entradaInsumo.man', {
        url: '/entradainsumoman',
        parent: 'entradaInsumo',
        templateUrl: 'app/entradaInsumo/entrada-insumo.html',
        access: 'private'
      });

  }
})();
