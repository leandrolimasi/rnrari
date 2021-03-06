package br.com.incode.regenerari.model.service.composicaoProduto.impl;

import br.com.incode.regenerari.entity.ComposicaoProdutoEntity;
import br.com.incode.regenerari.messages.AppBeanMessages;
import br.com.incode.regenerari.model.repository.composicaoProduto.ComposicaoProdutoRepository;
import br.com.incode.regenerari.model.service.composicaoProduto.IComposicaoProdutoService;
import com.powerlogic.jcompany.commons.interceptor.validation.PlcValidationInterceptor;
import com.powerlogic.jcompany.core.exception.PlcException;
import com.powerlogic.jcompany.core.model.domain.PlcSituacao;
import com.powerlogic.jcompany.core.model.repository.IPlcEntityRepository;
import com.powerlogic.jcompany.core.model.service.PlcAbstractServiceEntity;
import org.apache.commons.collections.CollectionUtils;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.validation.Valid;
import java.util.Date;

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

        ComposicaoProdutoEntity composicaoProduto = new ComposicaoProdutoEntity();
        composicaoProduto.setProduto(entity.getProduto());
        composicaoProduto.setComposicaoExperimental(false);

        if (CollectionUtils.isNotEmpty(composicaoProdutoRepository.find(composicaoProduto))){
            throw new PlcException(AppBeanMessages.COMPOSICAO_PRODUTO_EXPERIMENTAL_EXISTENTE);
        }

        if (entity.getId() == null){
            entity.setDataCriacao(new Date());
            entity.setSituacao(PlcSituacao.A);
        }
        return super.save(entity);
    }

}