package br.com.incode.regenerari.model.service.produto.impl;

import br.com.incode.regenerari.entity.ProdutoEntity;
import br.com.incode.regenerari.model.repository.produto.ProdutoRepository;
import br.com.incode.regenerari.model.service.produto.IProdutoService;
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
public class ProdutoServiceImpl extends PlcAbstractServiceEntity<Long, ProdutoEntity> implements IProdutoService {

    @Inject
    private ProdutoRepository produtoRepository;

    @Override
    protected IPlcEntityRepository<Long, ProdutoEntity> getEntityRepository() {
        return produtoRepository;
    }

    @Override
    public ProdutoEntity save(@Valid ProdutoEntity entity) throws PlcException {
        return super.save(entity);
    }

}