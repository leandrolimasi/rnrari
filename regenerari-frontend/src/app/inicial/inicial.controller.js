(function() {
  'use strict';

  angular
    .module('regenerari-frontend')
    .controller('InicialController', InicialController);

  /** @ngInject */
  function InicialController($state, PlcAuthService, PlcRestService, $window, $rootScope) {
    var vm = this;

    vm.isAdmin = _.findIndex($rootScope.user, 'ADMIN');


    vm.loadEnums = function(){
      var service = new PlcRestService({
        path: "/rest/entity/lookup"
      });


      if ($window.localStorage.getItem('unidadeMedidaProduto') == null){
        service.get('/unidadeMedidaProduto').then(function (response) {
          $window.localStorage.setItem('unidadeMedidaProduto', angular.toJson(response.data));
        });
      }

      if ($window.localStorage.getItem('unidadeMedidaInsumo') == null){
        service.get('/unidadeMedidaInsumo').then(function (response) {
          $window.localStorage.setItem('unidadeMedidaInsumo', angular.toJson(response.data));
        });
      }


    }

    vm.logout = function(){
      PlcAuthService.logout().then(function() {
        $state.go('login');
      });
    }


    vm.loadEnums();


  }
})();
