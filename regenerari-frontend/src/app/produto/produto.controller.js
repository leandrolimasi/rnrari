(function() {
  'use strict';

  angular
    .module('regenerari-frontend')
    .controller('ProdutoController', ProdutoController);

  /** @ngInject */
  function ProdutoController($scope, ProdutoService, $controller, $state, $document) {
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


    vm.afterInitialize = function(){

      if ($state.current.name == 'produto.man'){
        if (vm[vm.$baseRoute] && vm[vm.$baseRoute]['id']){
          var elem1 =  angular.element( $document[0].querySelector( "[name='produto.nome']" ))[0];
          elem1.focus();
        }else{
          var elem2 =  angular.element( $document[0].querySelector( "[name='produto.codigo']" ))[0];
          elem2.focus();
        }
      }


    }



    vm.columnDefs = [
      { field: 'codigo', displayName: 'Código'},
      { field: 'nome', displayName: 'Nome' },
      { field: 'statusDescricao', displayName: 'Status' }
    ];

    angular.extend(vm, $controller('PlcBaseController', {$scope: $scope, $controllerPlc: vm}));

  }
})();
