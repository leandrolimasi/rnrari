(function() {
  'use strict';

  angular
    .module('regenerari-frontend')
    .controller('EstoqueInsumoController', EstoqueInsumoController);

  /** @ngInject */
  function EstoqueInsumoController($scope, EstoqueInsumoService, $controller) {
    var vm = this;

    vm.$baseService = EstoqueInsumoService;
    vm.$baseRoute = 'estoqueInsumo';

    vm.columnDefs = [
      { field: 'insumo.codigo', displayName: 'Cód.'},
      { field: 'insumo.nome', displayName: 'Nome'},
      { field: 'quantidade', displayName: 'Quantidade', cellFilter: 'finance:false:3'},
      { field: 'valorUnitario', displayName: 'Valor Un.', cellFilter: 'finance:true:3'}
    ];

    angular.extend(vm, $controller('PlcBaseController', {$scope: $scope, $controllerPlc: vm}));
  }
})();
