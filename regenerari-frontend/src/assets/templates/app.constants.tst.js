(function() {
  'use strict';

  angular
    .module('regenerari-frontend')
    .constant('$appName', 'Regenerari')
    .constant('$appVersion', '0.0.1')
    .constant('$contextUrl', '');

  angular
    .module('jcompany-view.commons')
    .constant('$context', '{{CONTEXT.tst}}')
    .constant('$backendUrl', '{{ENVIRONMENT.tst}}');

})();
