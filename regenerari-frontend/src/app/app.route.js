(function() {
	'use strict';

	angular
	.module('regenerari-frontend')
	.config(RouterConfig);

	/** @ngInject */
	function RouterConfig($stateProvider, $urlRouterProvider, $locationProvider, $contextUrl) {

    $stateProvider.state('login',{
      url : '/login',
      templateUrl: 'app/login/login.html',
      controller: 'LoginController',
      controllerAs: 'loginController',
      access: 'public'
    })

    $urlRouterProvider.otherwise($contextUrl+'/inicial/home');
    $locationProvider.html5Mode(false);
	}

})();


