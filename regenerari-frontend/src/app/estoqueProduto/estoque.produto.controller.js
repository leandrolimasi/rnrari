(function() {
  'use strict';

  angular
    .module('regenerari-frontend')
    .controller('EstoqueProdutoController', EstoqueProdutoController);

  /** @ngInject */
  function EstoqueProdutoController($scope, EstoqueProdutoService, $controller) {
    var vm = this;

    vm.$baseService = EstoqueProdutoService;
    vm.$baseRoute = 'estoqueProduto';

    vm.columnDefs = [
      { field: 'produto.codigo', displayName: 'Cód.'},
      { field: 'produto.nome', displayName: 'Nome'},
      { field: 'quantidade', displayName: 'Quantidade', cellFilter: 'finance:false:3'},
      { field: 'eventoEstoque', displayName: 'Evento'},
      { field: 'dataUltimaAlteracao', displayName: 'Data', cellFilter: 'date'}
    ];



    vm.afterInitialize = function(){
      if (vm[vm.$baseRoute+'Arg']){
        vm[vm.$baseRoute+'Arg'].insumo = {};
      }
    }

    angular.extend(vm, $controller('PlcBaseController', {$scope: $scope, $controllerPlc: vm}));
  }
})();
