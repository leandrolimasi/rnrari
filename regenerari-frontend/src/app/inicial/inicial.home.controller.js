(function() {
  'use strict';

  angular
    .module('regenerari-frontend')
    .controller('InicialHomeController', InicialHomeController);

  /** @ngInject */
  function InicialHomeController($scope, $rootScope, PlcAuthService, $state) {
    var vm = this;
    vm.user = $rootScope.user;

	vm.logout = function() {
			PlcAuthService.logout().then(function() { // not logged
        $rootScope.user = null;
				$state.go('login');
			});

		}



  }
})();
