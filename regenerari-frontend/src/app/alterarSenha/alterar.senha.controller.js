(function() {
  'use strict';

  angular
    .module('regenerari-frontend')
    .controller('AlterarSenhaController', AlterarSenhaController);

  /** @ngInject */
  function AlterarSenhaController($rootScope, $scope, UsuarioService, $controller, $state) {
    var vm = this;

    vm.$baseService = UsuarioService;
    vm.$baseRoute = 'alterarSenha';

    $scope.alterarSenha = function(){
      var alterarSenhaDTO =  vm[vm.$baseRoute];
      alterarSenhaDTO['idUsuario'] = $rootScope.user.usuario.id;
      UsuarioService.alterarSenha(alterarSenhaDTO).then( function (response) {
        vm[vm.$baseRoute] = {};
        if (response.status == 200 && response.data.entity && response.data.entity.id){
          $state.go('inicial.home');
        }
      });
    };

    angular.extend(vm, $controller('PlcBaseController', {$scope: $scope, $controllerPlc: vm}));
  }
})();
