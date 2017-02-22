(function() {
  'use strict';

  angular
    .module('regenerari-frontend')
    .controller('AlterarSenhaController', AlterarSenhaController);

  /** @ngInject */
  function AlterarSenhaController($rootScope, $scope, UsuarioService, $controller, $state, PlcNotificationService) {
    var vm = this;

    vm.$baseService = UsuarioService;
    vm.$baseRoute = 'alterarSenha';

    angular.extend(vm, $controller('PlcBaseController', {$scope: $scope, $controllerPlc: vm}));

    vm.alterarSenhaUsuario = function(){
      if ($scope.formAlterarSenha.$invalid){
        vm.processValidation($scope.formAlterarSenha.$error);
        PlcNotificationService.error("CAMPOS_INVALIDOS_TOPICO_027");
        return
      }
      var alterarSenhaDTO =  vm[vm.$baseRoute];
      alterarSenhaDTO['idUsuario'] = $rootScope.user.usuario.id;
      UsuarioService.alterarSenha(alterarSenhaDTO).then( function (response) {
        vm[vm.$baseRoute] = {};
        if (response.status == 200 && response.data.entity && response.data.entity.id){
          $state.go('inicial.home');
        }
      });
    };

  }
})();
