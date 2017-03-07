package br.com.incode.regenerari.model.service.produto.impl;

import br.com.incode.regenerari.bo.ProdutoBO;
import br.com.incode.regenerari.entity.ComposicaoProdutoEntity;
import br.com.incode.regenerari.entity.ProdutoEntity;
import br.com.incode.regenerari.messages.AppBeanMessages;
import br.com.incode.regenerari.model.repository.composicaoProduto.ComposicaoProdutoRepository;
import br.com.incode.regenerari.model.repository.produto.ProdutoRepository;
import br.com.incode.regenerari.model.service.produto.IProdutoService;
import com.powerlogic.jcompany.commons.interceptor.validation.PlcValidationInterceptor;
import com.powerlogic.jcompany.core.exception.PlcException;
import com.powerlogic.jcompany.core.model.repository.IPlcEntityRepository;
import com.powerlogic.jcompany.core.model.service.PlcAbstractServiceEntity;
import org.apache.commons.collections.CollectionUtils;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by leandrolimadasilva on 20/12/16.
 */
@Stateless
@Interceptors({PlcValidationInterceptor.class})
public class ProdutoServiceImpl extends PlcAbstractServiceEntity<Long, ProdutoEntity> implements IProdutoService {

    @Inject
    private ProdutoBO produtoBO;

    @Inject
    private ProdutoRepository produtoRepository;

    @Inject
    private ComposicaoProdutoRepository composicaoProdutoRepository;


    @Override
    protected IPlcEntityRepository<Long, ProdutoEntity> getEntityRepository() {
        return produtoRepository;
    }

    @Override
    public ProdutoEntity save(@Valid ProdutoEntity entity) throws PlcException {
        produtoBO.validaAlteracaoCodigo(entity);
        produtoBO.configuraAlteracaoPreco(entity);
        produtoBO.validaAlteracaoExperimental(entity);
        return super.save(entity);
    }

    @Override
    public void remove(ProdutoEntity entity) throws PlcException {

        ComposicaoProdutoEntity composicaoProduto = new ComposicaoProdutoEntity();
        composicaoProduto.setProduto(entity);
        List<ComposicaoProdutoEntity> l = composicaoProdutoRepository.find(composicaoProduto);

        if (CollectionUtils.isNotEmpty(l)){
            throw new PlcException(AppBeanMessages.PRODUTO_ERROR_VINCULO_COMPOSICAO);
        }

        super.remove(entity);
    }
}