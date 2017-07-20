(function() {
  'use strict';

  angular
    .module('regenerari-frontend')
    .controller('InsumoController', InsumoController);

  /** @ngInject */
  function InsumoController($scope, InsumoService, $controller, $state, $document) {
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

    vm.afterInitialize = function(){

      if ($state.current.name == 'insumo.man'){
        if (vm[vm.$baseRoute] && vm[vm.$baseRoute]['id']){
          var elem1 =  angular.element( $document[0].querySelector( "[name='insumo.nome']" ))[0];
          elem1.focus();
        }else{
          var elem2 =  angular.element( $document[0].querySelector( "[name='insumo.codigo']" ))[0];
          elem2.focus();
        }
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


    vm.columnDefs = [
      { field: 'codigo', displayName: 'Código'},
      { field: 'nome', displayName: 'Nome'}
    ];

    angular.extend(vm, $controller('PlcBaseController', {$scope: $scope, $controllerPlc: vm}));

  }
})();
