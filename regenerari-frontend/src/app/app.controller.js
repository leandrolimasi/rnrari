(function() {
	'use strict';


	angular
	.module('regenerari-frontend')
	.controller('AppController', AppController);

	/** @ngInject */
	function AppController($rootScope, $scope, $cookies, $state, PlcAuthService, $window, $document) {
		var vm = this;
		vm.toggle =  true;
		vm.menuItems = [];

		/**
		 * Sidebar Toggle & Cookie Control
		 */
		var mobileView = 992;

		vm.getWidth = function() {
			return $window.innerWidth;
		};

		$scope.$watch(vm.getWidth, function(newValue) {
			if (newValue >= mobileView) {
				if (angular.isDefined($cookies.get('toggle'))) {
					vm.toggle = ! $cookies.get('toggle') ? false : true;
				} else {
					vm.toggle = true;
				}
			} else {
				vm.toggle = false;
			}

		});

		vm.toggleSidebar = function() {
			vm.toggle = !vm.toggle;
		}

    $window.onresize = function() {
			$scope.$apply();
		}

		vm.logout = function() {
			PlcAuthService.logout()
			.then(function() { // not logged
        $rootScope.user = null;
				$state.go('login');
			});

		}

		vm.profileShow = function() {
      $document[0].getElementById('profile').className= "item dropdown open";
		};

		vm.profileHide = function() {
      $document[0].getElementById('profile').className= "item dropdown";
		};

		vm.notificationShow = function() {
      $document[0].getElementById('notification').className= "item dropdown open";
		};

		vm.notificationHide = function() {
      $document[0].getElementById('notification').className= "item dropdown";
		};

	}

})();
