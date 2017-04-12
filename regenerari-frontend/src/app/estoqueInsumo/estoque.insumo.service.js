(function() {
    'use strict';
    angular
        .module('regenerari-frontend')
        .factory('EstoqueInsumoService', EstoqueInsumoService);

    /** @ngInject */
    function EstoqueInsumoService(PlcEntityService, PlcInherit) {

        var Service = PlcInherit.createClass(PlcEntityService, {
            constructor: function() {
                PlcEntityService.call(this, {
                    type: 'estoque-insumo',
                    applyMetadata: false
                });
            }
        });

        return new Service();
    }
})();
