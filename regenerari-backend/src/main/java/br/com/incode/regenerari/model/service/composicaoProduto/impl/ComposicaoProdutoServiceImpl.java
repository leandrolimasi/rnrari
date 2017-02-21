package br.com.incode.regenerari.model.service.composicaoProduto.impl;

import br.com.incode.regenerari.entity.ComposicaoProdutoEntity;
import br.com.incode.regenerari.model.repository.composicaoProduto.ComposicaoProdutoRepository;
import br.com.incode.regenerari.model.service.composicaoProduto.IComposicaoProdutoService;
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
public class ComposicaoProdutoServiceImpl extends PlcAbstractServiceEntity<Long, ComposicaoProdutoEntity> implements IComposicaoProdutoService {

    @Inject
    private ComposicaoProdutoRepository composicaoProdutoRepository;

    @Override
    protected IPlcEntityRepository<Long, ComposicaoProdutoEntity> getEntityRepository() {
        return composicaoProdutoRepository;
    }

    @Override
    public ComposicaoProdutoEntity save(@Valid ComposicaoProdutoEntity entity) throws PlcException {
        return super.save(entity);
    }

}