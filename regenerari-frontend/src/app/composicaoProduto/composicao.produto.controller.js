(function() {
  'use strict';

  angular
    .module('regenerari-frontend')
    .controller('ComposicaoProdutoController', ComposicaoProdutoController);

  /** @ngInject */
  function ComposicaoProdutoController($scope, ComposicaoProdutoService, $controller, $state, $window) {
    var vm = this;

    vm.$baseService = ComposicaoProdutoService;
    vm.$baseRoute = 'composicaoProduto';

    vm.detalhes = [{
      title: "Insumos",
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

    vm.getEnumUnidadeMedidaProduto = function(simbol){

      if ($window.localStorage.getItem('unidadeMedidaProduto') != null){
        var unidadeMedidaProduto = angular.fromJson($window.localStorage.getItem('unidadeMedidaProduto'));
        var ret = _.filter(unidadeMedidaProduto, {unidadeMedidaProduto: simbol});
        if (ret && ret[0]){
          return ret[0].descricao;
        }
      }

    }

    vm.getEnumUnidadeMedidaInsumo = function(simbol){

      if ($window.localStorage.getItem('unidadeMedidaInsumo') != null){
        var unidadeMedidaInsumo = angular.fromJson($window.localStorage.getItem('unidadeMedidaInsumo'));
        var ret = _.filter(unidadeMedidaInsumo, {unidadeMedidaInsumo: simbol});
        if (ret && ret[0]){
          return ret[0].descricao;
        }
      }

    }

    vm.columnDefs = [
      { field: 'id', displayName: 'Cod.'}
    ];

    angular.extend(vm, $controller('PlcBaseController', {$scope: $scope, $controllerPlc: vm}));

  }
})();
