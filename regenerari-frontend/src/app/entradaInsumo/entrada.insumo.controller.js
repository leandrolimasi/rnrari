(function() {
  'use strict';

  angular
    .module('regenerari-frontend')
    .controller('EntradaInsumoController', EntradaInsumoController);

  /** @ngInject */
  function EntradaInsumoController($scope, EstoqueInsumoService, $controller) {
    var vm = this;

    vm.$baseService = EstoqueInsumoService;
    vm.$baseRoute = 'entradaInsumo';

    angular.extend(vm, $controller('PlcBaseController', {$scope: $scope, $controllerPlc: vm}));

  }
})();
