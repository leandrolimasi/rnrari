(function() {
  'use strict';

  angular
    .module('regenerari-frontend')
    .controller('EstoqueInsumoModalController', EstoqueInsumoModalController);

  /** @ngInject */
  function EstoqueInsumoModalController($uibModalInstance, item) {
    var vm  = this;

    vm.item = item;

    vm.ok = function () {
      $uibModalInstance.close(vm.item);
    };


  }
})();
