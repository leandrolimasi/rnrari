(function() {
  'use strict';

  angular
    .module('regenerari-frontend')
    .controller('OrdemProducaoController', OrdemProducaoController);

  /** @ngInject */
  function OrdemProducaoController($scope, OrdemProducaoService, $controller, PlcNotificationService) {
    var vm = this;


    vm.$baseService = OrdemProducaoService;
    vm.$baseRoute = 'ordemProducao';


    vm.columnDefs = [
      { field: 'numero', displayName: 'Número'},
      { field: 'produto.nome', displayName: 'Produto'},
      { field: 'statusOrdemProducao', displayName: 'Status'}
    ];

    vm.gerar = function(){
      if ($scope.ordemProducao.$invalid){
        vm.processValidation($scope.ordemProducao.$error);
        PlcNotificationService.error("CAMPOS_INVALIDOS_TOPICO_027");
        return
      }
      var ordemProducaoDTO =  vm[vm.$baseRoute];
      OrdemProducaoService.gerar(ordemProducaoDTO).then( function (response) {
        if (response.status == 200){
          //vm.abrirModalEstoque(response.data.entity);
        }
      });
    }

    vm.getNumeroOrdemProducao = function(){
      OrdemProducaoService.getNumeroOrdemProducao().then( function (response) {
        if (response.data.entity){
          vm[vm.$baseRoute].numero = response.data.entity.timestamp;
        }
      });
    }

    vm.afterNew = function(){
      vm.getNumeroOrdemProducao();
    }

    angular.extend(vm, $controller('PlcBaseController', {$scope: $scope, $controllerPlc: vm}));

  }
})();
