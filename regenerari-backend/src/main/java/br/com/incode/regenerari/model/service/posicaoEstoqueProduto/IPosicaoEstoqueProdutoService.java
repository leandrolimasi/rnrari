package br.com.incode.regenerari.model.service.posicaoEstoqueProduto;

import br.com.incode.regenerari.entity.PosicaoEstoqueProdutoEntity;
import br.com.incode.regenerari.entity.ProdutoEntity;
import com.powerlogic.jcompany.core.model.service.IPlcEntityService;

import javax.ejb.Local;

/**
 * Created by leandrolimadasilva on 07/06/17.
 */
@Local
public interface IPosicaoEstoqueProdutoService extends IPlcEntityService<Long, PosicaoEstoqueProdutoEntity> {

    /** Recupera posicao estoque de produto
     *
     * @param produto
     * @return
     */
    PosicaoEstoqueProdutoEntity recuperaPosicaoEstoqueProduto(ProdutoEntity produto);

}
