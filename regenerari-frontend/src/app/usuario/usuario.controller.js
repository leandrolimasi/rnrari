(function() {
  'use strict';

  angular
    .module('regenerari-frontend')
    .controller('UsuarioController', UsuarioController);

  /** @ngInject */
  function UsuarioController($scope, UsuarioService, $controller, $state) {
    var vm = this;


    vm.$baseService = UsuarioService;
    vm.$baseRoute = 'usuario';


    vm.detalhes = [{
      title: "Perfil",
      name: "roles",
      template: "app/usuario/usuario-man-perfil.html"
    }];


    vm.new = function () {
      vm[vm.$baseRoute] = new Object();
      vm.addItemDetail('usuarioController.usuario.roles');
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
      { field: 'id', displayName: 'Cod.'},
      { field: 'login', displayName: 'Login'}
    ];



    angular.extend(vm, $controller('PlcBaseController', {$scope: $scope, $controllerPlc: vm}));




  }
})();
