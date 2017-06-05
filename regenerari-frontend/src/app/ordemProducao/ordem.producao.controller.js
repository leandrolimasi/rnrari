(function() {
  'use strict';

  angular
    .module('regenerari-frontend')
    .controller('OrdemProducaoController', OrdemProducaoController);

  /** @ngInject */
  function OrdemProducaoController($scope, OrdemProducaoService, $controller, PlcNotificationService, $state, $uibModal) {
    var vm = this;
    this.formScope = $scope;

    vm.$baseService = OrdemProducaoService;
    vm.$baseRoute = 'ordemProducao';


    vm.columnDefs = [
      { field: 'numero', displayName: 'Número'},
      { field: 'composicaoProduto.produto.nome', displayName: 'Produto'},
      { field: 'motivoOrdemProducaoDescricao', displayName: 'Motivo'},
      { field: 'statusOrdemProducaoDescricao', displayName: 'Status'},
      { field: 'quantidade', displayName: 'Quantidade', cellFilter: 'finance:false:3'}
    ];

    vm.iniciarOrdemProducao = function(idOrdem){
      alert('not implemented yet');
    }

    vm.cancelarOrdemProducao = function(idOrdem){
      var ordemProducao =  vm[vm.$baseRoute];
      OrdemProducaoService.cancelar(ordemProducao).then( function (response) {
        if (response.status === 200){
          vm.abrirModalOrdemProducaoCancelamento(response.data.entity);
        }
      });
    }

    vm.abrirModalOrdemProducaoCancelamento = function(ordemProducao){

      var modalInstance = $uibModal.open({
        animation: true,
        templateUrl: 'app/ordemProducao/ordem-producao-cancelamento-modal.html',
        controller: 'OrdemProducaoModalController',
        controllerAs: 'ordemProducaoModalController',
        resolve: {
          item: function () {
            return ordemProducao;
          }
        }
      });

      modalInstance.result.then(function () {
        $state.go( vm.$baseRoute + '.sel' );
      }, function () {
        $state.go( vm.$baseRoute + '.sel' );
      });

    }

    vm.abrirModalOrdemProducaoGeracao = function(ordemProducao){

      var modalInstance = $uibModal.open({
        animation: true,
        templateUrl: 'app/ordemProducao/ordem-producao-geracao-modal.html',
        controller: 'OrdemProducaoModalController',
        controllerAs: 'ordemProducaoModalController',
        resolve: {
          item: function () {
            return ordemProducao;
          }
        }
      });

      modalInstance.result.then(function () {
        $state.go( vm.$baseRoute + '.sel' );
      }, function () {
        $state.go( vm.$baseRoute + '.sel' );
      });

    }

    vm.gerarOrdemProducao = function(){
      if (this.formScope.ordemProducaoForm.$invalid){
        vm.processValidation(this.formScope.ordemProducaoForm.$error);
        PlcNotificationService.error("CAMPOS_INVALIDOS_TOPICO_027");
        return
      }
      var ordemProducaoDTO =  vm[vm.$baseRoute];
      OrdemProducaoService.gerar(ordemProducaoDTO).then( function (response) {
        if (response.status === 200){
          vm.abrirModalOrdemProducaoGeracao(response.data.entity);
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
