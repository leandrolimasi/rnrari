(function() {
  'use strict';

  angular
    .module('regenerari-frontend')
    .controller('BaixaInsumoExcepcionalController', BaixaInsumoExcepcionalController);

  /** @ngInject */
  function BaixaInsumoExcepcionalController($scope, EstoqueInsumoService, $controller, PlcNotificationService) {
    var vm = this;

    vm.$baseService = EstoqueInsumoService;
    vm.$baseRoute = 'baixaInsumoExcepcional';

    angular.extend(vm, $controller('PlcBaseController', {$scope: $scope, $controllerPlc: vm}));


    vm.baixaInsumo = function(){
      if ($scope.baixaInsumoExcepcional.$invalid){
        vm.processValidation($scope.baixaInsumoExcepcional.$error);
        PlcNotificationService.error("CAMPOS_INVALIDOS_TOPICO_027");
        return
      }
      var baixaInsumoExcepcional =  vm[vm.$baseRoute];
      EstoqueInsumoService.baixaExcepcional(baixaInsumoExcepcional).then( function (response) {
        if (response.status == 200){
          vm[vm.$baseRoute] = {};
        }
      });
    };

  }
})();
