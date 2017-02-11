(function() {
  'use strict';

  angular
    .module('regenerari-frontend')
    .controller('UsuarioController', UsuarioController);

  /** @ngInject */
  function UsuarioController($scope, UsuarioService, $controller) {
    var vm = this;


    vm.$baseService = UsuarioService;
    vm.$baseRoute = 'usuario';


    vm.detalhes = [{
      titulo: "label.heading.det1.usuario",
      name: "roles",
      template: "app/usuario/usuario-man-perfil.html"
    }];


    vm.columnDefs = [
        { field: 'id', displayName: 'Cod.'},
       { field: 'login', displayName: 'Login'}
    ];



    angular.extend(vm, $controller('PlcBaseController', {$scope: $scope, $controllerPlc: vm}));




  }
})();
