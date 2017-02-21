(function() {
    'use strict';
    angular
        .module('regenerari-frontend')
        .factory('ComposicaoProdutoService', ComposicaoProdutoService);

    /** @ngInject */
    function ComposicaoProdutoService(PlcEntityService, PlcInherit) {

        var Service = PlcInherit.createClass(PlcEntityService, {
            constructor: function() {
                PlcEntityService.call(this, {
                    type: 'composicao-produto',
                    applyMetadata: false
                });
            }
        });

        return new Service();
    }
})();
