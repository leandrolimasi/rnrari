(function() {
	'use strict';

	angular
	.module('regenerari-frontend')
	.run(RunBlock);

  /** @ngInject */
	function RunBlock(PlcAuthService) {

		//aplica segurança
		PlcAuthService.load();


	}

})();
