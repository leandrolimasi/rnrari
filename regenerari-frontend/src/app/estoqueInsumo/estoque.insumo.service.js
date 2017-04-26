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
            },
            entrada : function(data){
              return this._post('/entrada', data);
            },
            baixaExcepcional : function(data){
              return this._post('/baixa-excepcional', data);
            },
            getPosicaoEstoque : function(idInsumo){
              return this._get('/posicao-estoque/'+idInsumo);
            }
        });

        return new Service();
    }
})();
