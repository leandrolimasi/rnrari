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
    vm.activeProduto = {};

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
      console.log(response);
      if (response.status == 200 && response.data.entity && response.data.entity.id){
        $state.go( vm.$baseRoute + '.man', {id: response.data.entity.id} );
      }
    };

    //	save a record with required field validation
    vm.save = function () {

          if (vm.beforeSave()){
            if ($scope.form.$invalid){
              vm.processValidation($scope.form.$error);
              PlcNotificationService.error("CAMPOS_INVALIDOS_TOPICO_027");
              return
            }

            vm.$baseService.save(vm[vm.$baseRoute]).then( function (response) {

              if (response.status == 200 && response.data.entity && response.data.entity.id){
                vm[vm.$baseRoute] = response.data.entity;
                $state.go( vm.$baseRoute + '.man', {id: response.data.entity.id} );
              }

              vm.afterSave(response);

            }).catch(function (err) {
              vm.afterSave(err);
            });
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

    $scope.$watch("composicaoProdutoController.composicaoProduto.produto", function(newObj, oldObj) {
      if  ((newObj && !oldObj) || (newObj && oldObj && newObj.id !== oldObj.id)){
        vm.activeProduto = newObj;
        if (!vm[vm.$baseRoute].rendimento || (oldObj && newObj.id !== oldObj.id)){
          vm[vm.$baseRoute].rendimento = newObj.quantidadeApresentacao;
        }
      }
    });


    vm.columnDefs = [
      { field: 'id', displayName: 'Cód.'},
      { field: 'produto.nome', displayName: 'Produto'},
      { field: 'composicaoExperimentalDescricao', displayName: 'Experimental'}
    ];

    angular.extend(vm, $controller('PlcBaseController', {$scope: $scope, $controllerPlc: vm}));

  }
})();
