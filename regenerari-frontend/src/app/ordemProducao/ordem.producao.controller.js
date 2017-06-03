(function() {
  'use strict';

  angular
    .module('regenerari-frontend')
    .controller('OrdemProducaoController', OrdemProducaoController);

  /** @ngInject */
  function OrdemProducaoController($scope, OrdemProducaoService, $controller, PlcNotificationService, $state) {
    var vm = this;
    this.formScope = $scope;

    vm.$baseService = OrdemProducaoService;
    vm.$baseRoute = 'ordemProducao';


    vm.columnDefs = [
      { field: 'numero', displayName: 'Número'},
      { field: 'produto.nome', displayName: 'Produto'},
      { field: 'motivoOrdemProducaoDescricao', displayName: 'Motivo'},
      { field: 'statusOrdemProducaoDescricao', displayName: 'Status'},
      { field: 'quantidade', displayName: 'Quantidade'},
      { field: 'id', displayName: 'Ações', cellTemplate: '<div class="ui-grid-cell-contents" >  <button type="button" class="btn btn-primary btn-xs" ng-click="grid.appScope.iniciarOrdemProducao(row.entity.id)">Iniciar</button>  <button type="button" class="btn btn-danger btn-xs">Cancelar</button> </div>'}
    ];

    vm.rowTemplate = '  <div ng-repeat="(colRenderIndex, col) in colContainer.renderedColumns track by col.colDef.name" class="ui-grid-cell" ng-class="{ \'ui-grid-row-header-cell\': col.isRowHeader }"  ui-grid-cell></div>';

    vm.iniciarOrdemProducao = function(idOrdem){
      alert('not implemented yet');
    }

    vm.cancelarOrdemProducao = function(idOrdem){
      alert('not implemented yet');
    }

    vm.gerar = function(){
      if (this.formScope.ordemProducaoForm.$invalid){
        vm.processValidation(this.formScope.ordemProducaoForm.$error);
        PlcNotificationService.error("CAMPOS_INVALIDOS_TOPICO_027");
        return
      }
      var ordemProducaoDTO =  vm[vm.$baseRoute];
      OrdemProducaoService.gerar(ordemProducaoDTO).then( function (response) {
        $state.go( vm.$baseRoute + '.sel' );
      });
    }

    vm.getNumeroOrdemProducao = function(){
      OrdemProducaoService.getNumeroOrdemProducao().then( function (response) {
        if (response.data.entity){
          vm[vm.$baseRoute].numero = response.data.entity.timestamp;
        }
      });
    }

    vm.afterNew = function(){
      vm.getNumeroOrdemProducao();
    }

    var paginationOptions = {
      page: 1,
      size: 25,
      sort: undefined,
      dir: undefined
    };

    vm.gridOptions =  {
        paginationPageSizes: [25, 50, 75],
        paginationPageSize: 25,
        useExternalPagination: true,
        useExternalSorting: true,
        rowTemplate: vm.getRowTemplate,
        columnDefs:  vm.columnDefs,
        appScopeProvider: vm,
        onRegisterApi: function(gridApi) {
          vm.gridApi = gridApi;
          vm.gridApi.core.on.sortChanged(vm, function(grid, sortColumns) {

            paginationOptions.sort = undefined;
            paginationOptions.dir = undefined;

            if (sortColumns.length > 0) {

              angular.forEach(sortColumns, function (value) {
                if (value && value.sort) {
                  if(!paginationOptions.dir){
                    paginationOptions.dir = value.sort.direction +',';
                  }else{
                    paginationOptions.dir += value.sort.direction +',';
                  }

                  if(!paginationOptions.sort){
                    paginationOptions.sort = value.name +',';
                  }else{
                    paginationOptions.sort += value.name +',';
                  }
                }
              });

            }

            vm.$baseService.find(vm[vm.$baseRoute+'Arg'], paginationOptions).then( function (response) {
              vm.gridOptions.data = response.data.entity.list;
              vm.gridOptions.totalItems = response.data.entity.count;
            });

          });
          gridApi.pagination.on.paginationChanged(vm, function (newPage, pageSize) {

            paginationOptions.page = newPage;
            paginationOptions.size = pageSize;

            vm.$baseService.find(vm[vm.$baseRoute+'Arg'], paginationOptions).then( function (response) {
              vm.gridOptions.data = response.data.entity.list;
              vm.gridOptions.totalItems = response.data.entity.count;
            });
          });
        }
    };

    angular.extend(vm, $controller('PlcBaseController', {$scope: $scope, $controllerPlc: vm}));



  }
})();
