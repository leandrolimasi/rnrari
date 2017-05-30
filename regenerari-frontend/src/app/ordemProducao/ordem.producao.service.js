(function() {
    'use strict';
    angular
        .module('regenerari-frontend')
        .factory('OrdemProducaoService', OrdemProducaoService);

    /** @ngInject */
    function OrdemProducaoService(PlcEntityService, PlcInherit) {

        var Service = PlcInherit.createClass(PlcEntityService, {
            constructor: function() {
                PlcEntityService.call(this, {
                    type: 'ordem-producao',
                    applyMetadata: false
                });
            },
            gerar : function(data){
              return this._post('/gerar', data);
            },
            getNumeroOrdemProducao : function(){
              return this._get('/numeroOrdemProducao');
            }
        });

        return new Service();
    }
})();
