(function() {
  'use strict';
  angular
    .module('regenerari-frontend')
    .factory('UsuarioService', UsuarioService);

  /** @ngInject */
  function UsuarioService(PlcEntityService, PlcInherit) {

    var Service = PlcInherit.createClass(PlcEntityService, {
      constructor: function() {
        PlcEntityService.call(this, {
          type: 'usuario',
          applyMetadata: false
        });
      },

      alterarSenha : function(data){
        return this._post('/alterarSenha', data);
      }
    });

    return new Service();
  }
})();
