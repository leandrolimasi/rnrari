package br.com.incode.regenerari.model.service.posicaoEstoqueProduto.impl;

import br.com.incode.regenerari.entity.PosicaoEstoqueProdutoEntity;
import br.com.incode.regenerari.entity.ProdutoEntity;
import br.com.incode.regenerari.model.repository.posicaoEstoqueProduto.PosicaoEstoqueProdutoRepository;
import br.com.incode.regenerari.model.service.posicaoEstoqueProduto.IPosicaoEstoqueProdutoService;
import com.powerlogic.jcompany.commons.interceptor.validation.PlcValidationInterceptor;
import com.powerlogic.jcompany.core.model.repository.IPlcEntityRepository;
import com.powerlogic.jcompany.core.model.service.PlcAbstractServiceEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.interceptor.Interceptors;

/**
 * Created by leandrolimadasilva on 07/06/17.
 */
@Stateless
@Interceptors({PlcValidationInterceptor.class})
public class PosicaoEstoqueProdutoServiceImpl extends PlcAbstractServiceEntity<Long, PosicaoEstoqueProdutoEntity> implements IPosicaoEstoqueProdutoService {

    private static final Logger log = LoggerFactory.getLogger(PosicaoEstoqueProdutoServiceImpl.class);

    @Inject
    private PosicaoEstoqueProdutoRepository posicaoEstoqueProdutoRepository;

    @Override
    protected IPlcEntityRepository<Long, PosicaoEstoqueProdutoEntity> getEntityRepository() {
        return posicaoEstoqueProdutoRepository;
    }

    /**
     * Recupera posicao estoque de produto
     *
     * @param produto
     * @return
     */
    @Override
    public PosicaoEstoqueProdutoEntity recuperaPosicaoEstoqueProduto(ProdutoEntity produto) {
        return posicaoEstoqueProdutoRepository.recuperaPosicaoAtual(produto);
    }
}
