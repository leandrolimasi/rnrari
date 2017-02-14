(function() {
	'use strict';

	angular
	.module('regenerari-frontend')
	.config(RouterConfig);

	/** @ngInject */
	function RouterConfig($stateProvider, $urlRouterProvider, $locationProvider, $contextUrl) {

		// the log-on screen
		$stateProvider.state('login',{
			url : $contextUrl+'/plc-login',
			templateUrl: 'app/login/login.html',
			controller: 'PlcLoginController',
			controllerAs: 'plcLoginController',
			access: 'public'
		})


		$stateProvider
		.state('app', {
			url: $contextUrl+'/app',
			templateUrl: 'app/app.html'
		});

		$stateProvider
		.state('app.inicial', {
			url: '/inicial',
			parent: 'app',
			templateUrl: 'app/inicial/inicial.html',
			controller: 'InicialController',
			controllerAs: 'inicialController'
		});

    $stateProvider
      .state('app.403', {
        url: '/403',
        parent: 'app',
        templateUrl: 'app/errors/error403.html'
      });


		$locationProvider.html5Mode(false);
		$urlRouterProvider.otherwise($contextUrl+'/app/inicial');
	}

})();


