(function() {
  'use strict';

  angular
    .module('regenerari-frontend')
    .controller('ComposicaoProdutoController', ComposicaoProdutoController);

  /** @ngInject */
  function ComposicaoProdutoController($scope, ComposicaoProdutoService, $controller, $state) {
    var vm = this;

    vm.$baseService = ComposicaoProdutoService;
    vm.$baseRoute = 'composicaoProduto';

    vm.detalhes = [{
      title: "Itens",
      name: "itemComposicaoProduto",
      template: "app/composicaoProduto/composicao-produto-man-item.html"
    }];


    vm.new = function () {
      vm[vm.$baseRoute] = new Object();
      $state.go( vm.$baseRoute + '.man',  {id: undefined} );
    };

    vm.afterSave = function (response) {
      if (response.status == 200 && response.data.entity && response.data.entity.id){
        $state.go( vm.$baseRoute + '.man', {id: response.data.entity.id} );
      }
    };

    vm.addItemDetail = function (detail) {

      var attr = detail.getValueFromObject($scope);
      if(angular.isUndefined(attr)){
        attr = [];
      }

      attr.push(new Object());
      detail.setValueToObject($scope, attr);


    };

    vm.columnDefs = [
      { field: 'id', displayName: 'Cod.'}
    ];



    angular.extend(vm, $controller('PlcBaseController', {$scope: $scope, $controllerPlc: vm}));




  }
})();