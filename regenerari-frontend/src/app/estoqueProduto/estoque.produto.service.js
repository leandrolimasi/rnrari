(function() {
    'use strict';
    angular
        .module('regenerari-frontend')
        .factory('EstoqueProdutoService', EstoqueProdutoService);

    /** @ngInject */
    function EstoqueProdutoService(PlcEntityService, PlcInherit) {

        var Service = PlcInherit.createClass(PlcEntityService, {
            constructor: function() {
                PlcEntityService.call(this, {
                    type: 'estoque-produto',
                    applyMetadata: false
                });
            },
            getPosicaoEstoque : function(idProduto){
              return this._get('/posicao-estoque/'+idProduto);
            }
        });

        return new Service();
    }
})();
