(function() {
    'use strict';
    angular
        .module('regenerari-frontend')
        .config(MudarSenhaRouterConfig);

    /** @ngInject */
    function MudarSenhaRouterConfig($stateProvider) {
        $stateProvider
            .state('alterarSenha', {
                url: '/alterarsenha',
                abstract: true,
                templateUrl: 'app/inicial/inicial.html',
                controller: 'InicialController',
                controllerAs: 'inicialController'
            });
        $stateProvider
            .state('alterarSenha.man', {
                url: '/alterarsenhaman/:id',
                parent: 'alterarSenha',
                templateUrl: 'app/alterarSenha/alterar-senha-man.html',
                access: 'private'
            });

    }
})();
