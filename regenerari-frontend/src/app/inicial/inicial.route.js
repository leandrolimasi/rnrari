(function() {
  'use strict';

  angular
    .module('regenerari-frontend')
    .config(routerConfig);

  /** @ngInject */
  function routerConfig($stateProvider) {
    $stateProvider
      .state('inicial', {
        url:'/inicial',
        templateUrl: 'app/inicial/inicial.html',
        controller: 'InicialController',
        controllerAs: 'inicialController'
      });

    $stateProvider
      .state('inicial.home', {
        url: '/home',
        parent: 'inicial',
        templateUrl: 'app/inicial/inicial-home.html',
        controller: 'InicialHomeController',
        controllerAs: 'inicialHomeController',
        access: 'private'
      });
  }

})();
