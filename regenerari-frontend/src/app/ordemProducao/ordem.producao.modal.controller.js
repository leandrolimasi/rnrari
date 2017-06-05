(function() {
  'use strict';

  angular
    .module('regenerari-frontend')
    .controller('OrdemProducaoModalController', OrdemProducaoModalController);

  /** @ngInject */
  function OrdemProducaoModalController($uibModalInstance, item) {
    var vm  = this;

    vm.item = item;

    vm.ok = function () {
      $uibModalInstance.close(vm.item);
    };

  }
})();
