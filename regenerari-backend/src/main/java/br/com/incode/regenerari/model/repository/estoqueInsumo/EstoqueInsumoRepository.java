package br.com.incode.regenerari.model.repository.estoqueInsumo;

import br.com.incode.regenerari.entity.ComposicaoProdutoEntity;
import br.com.incode.regenerari.entity.EstoqueInsumoEntity;
import com.powerlogic.jcompany.core.model.repository.PlcAbstractRepository;

/**
 * Created by leandrolimadasilva on 12/04/17.
 */
public class EstoqueInsumoRepository extends PlcAbstractRepository<Long, EstoqueInsumoEntity> {

    @Override
    public Class<EstoqueInsumoEntity> getEntityType() {
        return EstoqueInsumoEntity.class;
    }

}
