(function() {
    'use strict';
    angular
        .module('regenerari-frontend')
        .config(UsuarioRouterConfig);
    /** @ngInject */
    function UsuarioRouterConfig($stateProvider) {
        $stateProvider
            .state('usuario', {
                url: '/usuario',
                abstract: true,
                templateUrl: 'app/inicial/inicial.html',
                controller: 'InicialController',
                controllerAs: 'inicialController'
            });
        $stateProvider
            .state('usuario.man', {
                url: '/usuarioman/:id',
                parent: 'usuario',
                templateUrl: 'app/usuario/usuario-man.html',
                access: 'private'
            });
        $stateProvider
            .state('usuario.sel', {
                url: '/usuariosel',
                parent: 'usuario',
                templateUrl: 'app/usuario/usuario-sel.html',
                access: 'private'
            });
    }
})();