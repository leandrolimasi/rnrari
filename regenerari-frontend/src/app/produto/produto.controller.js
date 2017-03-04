(function() {
  'use strict';

  angular
    .module('regenerari-frontend')
    .controller('ProdutoController', ProdutoController);

  /** @ngInject */
  function ProdutoController($scope, ProdutoService, $controller, $state) {
    var vm = this;


    vm.$baseService = ProdutoService;
    vm.$baseRoute = 'produto';



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
      { field: 'codigo', displayName: 'Código'},
      { field: 'nome', displayName: 'Nome'}
    ];

    angular.extend(vm, $controller('PlcBaseController', {$scope: $scope, $controllerPlc: vm}));

  }
})();
