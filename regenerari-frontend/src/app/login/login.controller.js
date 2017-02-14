(function() {
    'use strict';
    angular
        .module('regenerari-frontend')
        .controller('LoginController', LoginController);

    /** @ngInject */
    function LoginController($rootScope, $state, PlcAuthService, PlcNotificationService, $context) {
        var vm = this;
        vm.username = '';
        vm.password = '';
        vm.$context = $context;

        vm.isLoading = function(){
            return PlcAuthService.isWorking();
        };

        vm.login = function($event) {
            $event.preventDefault();
            if(!vm.username || !vm.password){
                PlcNotificationService.error("FALHA_LOGIN_001");
                return;
            }
            PlcAuthService
                .login(vm.username, vm.password)
                .then(function(userInfo) {
                    if (userInfo){
                        $state.go('inicial.home');
                    }
                }, function(result) {
                    PlcNotificationService.push(result);
                });
        }

        vm.verificaLoginAtivo = function(){
            PlcAuthService.checarSessao().then(function() {
                if (PlcAuthService.isLogged()) {
                    if ($rootScope.user && $rootScope.user){
                        $state.go('inicial.home');
                    }
                }
            });
        }

        vm.verificaLoginAtivo();
    }
})();
