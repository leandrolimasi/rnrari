(function() {
  'use strict';

  angular
    .module('regenerari-frontend')
    .controller('InicialController', InicialController);

  /** @ngInject */
  function InicialController($state, PlcAuthService) {
    var vm = this;


    vm.logout = function(){
      PlcAuthService.logout().then(function() {
        $state.go('login');
      });
    }




  }
})();
