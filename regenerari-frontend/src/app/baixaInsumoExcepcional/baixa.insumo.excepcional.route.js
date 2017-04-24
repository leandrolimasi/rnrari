(function() {
  'use strict';
  angular
    .module('regenerari-frontend')
    .config(BaixaInsumoExcepcionalRouterConfig);

  /** @ngInject */
  function BaixaInsumoExcepcionalRouterConfig($stateProvider) {
    $stateProvider
      .state('baixaInsumoExcepcional', {
        url: '/baixainsumoexcepcional',
        abstract: true,
        templateUrl: 'app/inicial/inicial.html',
        controller: 'InicialController',
        controllerAs: 'inicialController'
      });
    $stateProvider
      .state('baixaInsumoExcepcional.man', {
        url: '/baixainsumoexcepcionalman',
        parent: 'baixaInsumoExcepcional',
        templateUrl: 'app/baixaInsumoExcepcional/baixa-insumo-excepcional.html',
        access: 'private'
      });

  }
})();
