(function() {
  'use strict';

  angular
    .module('regenerari-frontend')
    .controller('EntradaInsumoController', EntradaInsumoController);

  /** @ngInject */
  function EntradaInsumoController($scope, EstoqueInsumoService, $controller, PlcNotificationService) {
    var vm = this;

    vm.$baseService = EstoqueInsumoService;
    vm.$baseRoute = 'entradaInsumo';

    angular.extend(vm, $controller('PlcBaseController', {$scope: $scope, $controllerPlc: vm}));

    vm.entradaEstoqueInsumo = function(){
      if ($scope.entradaInsumo.$invalid){
        vm.processValidation($scope.entradaInsumo.$error);
        PlcNotificationService.error("CAMPOS_INVALIDOS_TOPICO_027");
        return
      }
      var entradaInsumoDTO =  vm[vm.$baseRoute];
      EstoqueInsumoService.entrada(entradaInsumoDTO).then( function (response) {
        if (response.status == 200){
          vm[vm.$baseRoute] = {};
        }
      });
    };

  }
})();
