package br.com.incode.regenerari.model.service.ordemProducao.impl;

import br.com.incode.regenerari.entity.OrdemProducaoEntity;
import br.com.incode.regenerari.model.repository.ordemProducao.OrdemProducaoRepository;
import br.com.incode.regenerari.model.service.ordemProducao.IOrdemProducaoService;
import com.powerlogic.jcompany.commons.interceptor.validation.PlcValidationInterceptor;
import com.powerlogic.jcompany.core.model.repository.IPlcEntityRepository;
import com.powerlogic.jcompany.core.model.service.PlcAbstractServiceEntity;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.interceptor.Interceptors;

/**
 * Created by leandrolimadasilva on 26/05/17.
 */
@Stateless
@Interceptors({PlcValidationInterceptor.class})
public class OrdemProducaoServiceImpl extends PlcAbstractServiceEntity<Long, OrdemProducaoEntity> implements IOrdemProducaoService {

    @Inject
    private OrdemProducaoRepository ordemProducaoRepository;

    @Override
    protected IPlcEntityRepository<Long, OrdemProducaoEntity> getEntityRepository() {
        return ordemProducaoRepository;
    }


}