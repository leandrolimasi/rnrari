(function() {
	'use strict';

	angular
	.module('regenerari-frontend')
	.config(AppConfig);

  /** @ngInject */
	function AppConfig(PlcMenuLoaderProvider) {

		PlcMenuLoaderProvider.addMenuPath('app/components/json/menu.json');



	}

})();
