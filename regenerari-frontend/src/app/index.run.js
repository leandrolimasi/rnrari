(function() {
  'use strict';

  angular
    .module('regenerari-frontend')
    .run(runBlock);

  /** @ngInject */
  function runBlock($rootScope, PlcAuthService, $state, $location, $window) {


    var auth = PlcAuthService;

    // Cada troca de view faz checagem de permissao.
    $rootScope.$on('$stateChangeStart', function(event, toState){
        var access = (toState && toState.access) || 'private';
        if (access === 'private') {
          auth.checarSessao().then(function(response) {
            if (!auth.hasRole(access, toState.roles)) {
              if (!auth.isLogged()) {
                $state.go('login');
              } else {
                //FIXME - ajustar
                $location.path('/403');
              }
            }else if (auth.lastAuthURL != ''){
              $location.url(auth.lastAuthURL);
              auth.lastAuthURL = "";
            }

          }, function(error) {
            $state.go('login');
          });
        }
    });
  }

})();
