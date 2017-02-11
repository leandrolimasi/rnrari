(function() {
  'use strict';


  angular
      .module('tour-frontend')
      .constant('$appName', 'Tour')
      .constant('$appVersion', '0.0.1')
      .constant('$contextUrl', '');

  angular
      .module('jcompany-view.commons')
      .constant('$backendUrl', '{{ENVIRONMENT.prd}}')
      .constant('$context', '{{CONTEXT.prd}}');

})();
