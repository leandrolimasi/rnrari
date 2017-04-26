(function() {
  'use strict';

  angular
    .module('regenerari-frontend')
    .controller('BaixaInsumoExcepcionalController', BaixaInsumoExcepcionalController);

  /** @ngInject */
  function BaixaInsumoExcepcionalController($scope, EstoqueInsumoService, $controller, PlcNotificationService, $uibModal, $window) {
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
          vm.abrirModalEstoque(response.data.entity);
        }
      });
    };

    $scope.$watch("baixaInsumoExcepcionalController.baixaInsumoExcepcional.insumo", function(newObj, oldObj) {
      if  ((newObj && !oldObj) || (newObj && oldObj && newObj.id !== oldObj.id)){
        EstoqueInsumoService.getPosicaoEstoque(newObj.id).then( function (response) {
          if (response.status == 200){
            vm.estoqueAtualInsumo = response.data.entity.quantidade;
          }
        });
      }
    });


    vm.abrirModalEstoque = function(estoque){

      var modalInstance = $uibModal.open({
        animation: true,
        templateUrl: 'app/estoqueInsumo/estoque-insumo-modal.html',
        controller: 'EstoqueInsumoModalController',
        controllerAs: 'estoqueInsumoModalController',
        resolve: {
          item: function () {
            return estoque;
          }
        }
      });

      modalInstance.result.then(function () {
        $window.location.reload();
      }, function () {
        $window.location.reload();
      });

    }


  }
})();
