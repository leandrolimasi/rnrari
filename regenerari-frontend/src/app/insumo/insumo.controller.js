(function() {
  'use strict';

  angular
    .module('regenerari-frontend')
    .controller('InsumoController', InsumoController);

  /** @ngInject */
  function InsumoController($scope, InsumoService, $controller, $state) {
    var vm = this;


    vm.$baseService = InsumoService;
    vm.$baseRoute = 'insumo';



    vm.new = function () {
      vm[vm.$baseRoute] = new Object();
      $state.go( vm.$baseRoute + '.man',  {id: undefined} );
    };

    vm.afterSave = function (response) {
      if (response.status == 200 && response.data.entity && response.data.entity.id){
        $state.go( vm.$baseRoute + '.man', {id: response.data.entity.id} );
      }
    };


    vm.columnDefs = [
      { field: 'id', displayName: 'Cod.'},
      { field: 'nome', displayName: 'Nome'}
    ];

    angular.extend(vm, $controller('PlcBaseController', {$scope: $scope, $controllerPlc: vm}));

  }
})();
