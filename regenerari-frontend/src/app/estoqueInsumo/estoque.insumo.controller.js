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


    vm.afterInitialize = function(){
      if (vm[vm.$baseRoute+'Arg']){
        vm[vm.$baseRoute+'Arg'].insumo = {};
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

    angular.extend(vm, $controller('PlcBaseController', {$scope: $scope, $controllerPlc: vm}));
  }
})();
