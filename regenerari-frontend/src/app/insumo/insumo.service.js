(function() {
    'use strict';
    angular
        .module('regenerari-frontend')
        .factory('InsumoService', InsumoService);

    /** @ngInject */
    function InsumoService(PlcEntityService, PlcInherit) {

        var Service = PlcInherit.createClass(PlcEntityService, {
            constructor: function() {
                PlcEntityService.call(this, {
                    type: 'insumo',
                    applyMetadata: false
                });
            }
        });

        return new Service();
    }
})();
