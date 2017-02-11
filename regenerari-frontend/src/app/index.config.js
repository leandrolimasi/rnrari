(function() {
  'use strict';

  angular
    .module('regenerari-frontend')
    .config(AppConfig);

  /** @ngInject */
  function AppConfig($locationProvider,$httpProvider, $backendUrl, PlcRestServiceProvider,  $translateProvider,
                     tmhDynamicLocaleProvider, NotificationProvider, blockUIConfig) {

    PlcRestServiceProvider.setServiceUrl($backendUrl);

    $locationProvider.html5Mode(false);

    $translateProvider.preferredLanguage('pt_BR');
    $httpProvider.defaults.useXDomain = true;
    $httpProvider.defaults.withCredentials = true;

    delete $httpProvider.defaults.headers.common['X-Requested-With'];

    $translateProvider.useMissingTranslationHandlerLog();

    $translateProvider.useUrlLoader($backendUrl + '/rest/mensagens/i18n', {
      queryParameter : 'locale'
    });

    $translateProvider.useLocalStorage();

    $translateProvider.useSanitizeValueStrategy('escape');

    tmhDynamicLocaleProvider.localeLocationPattern("https://code.angularjs.org./1.5.5/i18n/angular-locale_{{locale}}.js");

    NotificationProvider.setOptions({
      delay: 20000,
      startTop: 20,
      startRight: 10,
      verticalSpacing: 20,
      horizontalSpacing: 20,
      positionX: 'right',
      positionY: 'top'
    });

    blockUIConfig.message = 'Aguarde ...';


  }

})();
