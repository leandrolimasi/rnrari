package br.com.incode.regenerari.bo;

import br.com.incode.regenerari.entity.EstoqueInsumoEntity;
import br.com.incode.regenerari.entity.ProdutoEntity;
import br.com.incode.regenerari.messages.AppBeanMessages;
import br.com.incode.regenerari.model.repository.produto.ProdutoRepository;
import br.com.incode.regenerari.util.AppUtil;
import com.powerlogic.jcompany.core.exception.PlcException;

import javax.inject.Inject;
import java.util.Date;

/**
 * Created by leandrolimadasilva on 16/04/17.
 */
public class EstoqueInsumoBO extends AppBO {

    @Inject
    private AppUtil appUtil;

    @Inject
    private ProdutoRepository produtoRepository;

    /**
     * verifica campos validos
     *
     * @param entity
     */
    public void validaEntradaEstoque(EstoqueInsumoEntity entity) {

        if (entity.getQuantidade().doubleValue() <= 0){
            throw new PlcException(AppBeanMessages.ESTOQUE_INSUMO_QUANTIDADE_ZERO);
        }

        if (entity.getValorCompraTotal().doubleValue() <= 0){
            throw new PlcException(AppBeanMessages.ESTOQUE_INSUMO_VALORCOMPRATOTAL_ZERO);
        }

        if (entity.getData().getTime() > new Date().getTime()){
            throw new PlcException(AppBeanMessages.ESTOQUE_INSUMO_DATA_PASSADO);
        }

    }


}