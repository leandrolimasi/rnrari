(function() {
    'use strict';
    angular
        .module('regenerari-frontend')
        .factory('ProdutoService', ProdutoService);

    /** @ngInject */
    function ProdutoService(PlcEntityService, PlcInherit) {

        var Service = PlcInherit.createClass(PlcEntityService, {
            constructor: function() {
                PlcEntityService.call(this, {
                    type: 'produto',
                    applyMetadata: false
                });
            }
        });

        return new Service();
    }
})();
