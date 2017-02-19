package br.com.incode.regenerari.model.service.insumo.impl;

import br.com.incode.regenerari.entity.InsumoEntity;
import br.com.incode.regenerari.model.repository.insumo.InsumoRepository;
import br.com.incode.regenerari.model.service.insumo.IInsumoService;
import com.powerlogic.jcompany.commons.interceptor.validation.PlcValidationInterceptor;
import com.powerlogic.jcompany.core.exception.PlcException;
import com.powerlogic.jcompany.core.model.repository.IPlcEntityRepository;
import com.powerlogic.jcompany.core.model.service.PlcAbstractServiceEntity;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.validation.Valid;

/**
 * Created by leandrolimadasilva on 20/12/16.
 */
@Stateless
@Interceptors({PlcValidationInterceptor.class})
public class InsumoServiceImpl extends PlcAbstractServiceEntity<Long, InsumoEntity> implements IInsumoService {

    @Inject
    private InsumoRepository insumoRepository;

    @Override
    protected IPlcEntityRepository<Long, InsumoEntity> getEntityRepository() {
        return insumoRepository;
    }

    @Override
    public InsumoEntity save(@Valid InsumoEntity entity) throws PlcException {
        return super.save(entity);
    }

}