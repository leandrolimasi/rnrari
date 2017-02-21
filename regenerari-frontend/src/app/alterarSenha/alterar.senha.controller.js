(function() {
  'use strict';

  angular
    .module('regenerari-frontend')
    .controller('AlterarSenhaController', AlterarSenhaController);

  /** @ngInject */
  function AlterarSenhaController($scope, UsuarioService, $controller) {
    var vm = this;

    vm.$baseService = UsuarioService;
    vm.$baseRoute = 'alterarSenha';

    vm.alterarSenha = function(){
      UsuarioService.alterarSenha(vm[vm.$baseRoute]);
    }

    angular.extend(vm, $controller('PlcBaseController', {$scope: $scope, $controllerPlc: vm}));
  }
})();
