(function() {
  'use strict';

  angular
    .module('regenerari-frontend')
    .config(routerConfig);

  /** @ngInject */
  function routerConfig($stateProvider, $urlRouterProvider) {

    $stateProvider.state('login',{
      url : '/login',
      templateUrl: 'app/login/login.html',
      controller: 'LoginController',
      controllerAs: 'loginController',
      access: 'public'
    })



    $urlRouterProvider.otherwise('/inicial/home');


  }

})();
