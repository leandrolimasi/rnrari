package br.com.incode.regenerari.model.repository.composicaoProduto;

import br.com.incode.regenerari.entity.ComposicaoProdutoEntity;
import com.powerlogic.jcompany.core.model.repository.PlcAbstractRepository;

/**
 * Created by leandrolimadasilva on 21/12/16.
 */
public class ComposicaoProdutoRepository extends PlcAbstractRepository<Long, ComposicaoProdutoEntity> {

    @Override
    public Class<ComposicaoProdutoEntity> getEntityType() {
        return ComposicaoProdutoEntity.class;
    }

}
