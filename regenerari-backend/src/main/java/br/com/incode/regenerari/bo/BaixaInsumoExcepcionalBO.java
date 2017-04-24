package br.com.incode.regenerari.bo;

import br.com.incode.regenerari.entity.BaixaInsumoExcepcionalEntity;
import br.com.incode.regenerari.entity.EstoqueInsumoEntity;
import br.com.incode.regenerari.messages.AppBeanMessages;
import br.com.incode.regenerari.model.repository.produto.ProdutoRepository;
import br.com.incode.regenerari.util.AppUtil;
import com.powerlogic.jcompany.core.exception.PlcException;

import javax.inject.Inject;

/**
 * Created by leandrolimadasilva on 24/04/17.
 */
public class BaixaInsumoExcepcionalBO extends AppBO {

    @Inject
    private AppUtil appUtil;

    @Inject
    private ProdutoRepository produtoRepository;

    /**
     * verifica campos validos
     *
     * @param entity
     */
    public void validaBaixaEstoque(BaixaInsumoExcepcionalEntity entity) {

        if (entity.getQuantidade().doubleValue() <= 0){
            throw new PlcException(AppBeanMessages.BAIXA_INSUMO_QUANTIDADE_ZERO);
        }

    }


}