package br.com.incode.regenerari.model.repository.produto;

import br.com.incode.regenerari.entity.InsumoEntity;
import br.com.incode.regenerari.entity.ProdutoEntity;
import com.powerlogic.jcompany.core.model.repository.PlcAbstractRepository;

/**
 * Created by leandrolimadasilva on 21/12/16.
 */
public class ProdutoRepository extends PlcAbstractRepository<Long, ProdutoEntity> {

    @Override
    public Class<ProdutoEntity> getEntityType() {
        return ProdutoEntity.class;
    }

}
