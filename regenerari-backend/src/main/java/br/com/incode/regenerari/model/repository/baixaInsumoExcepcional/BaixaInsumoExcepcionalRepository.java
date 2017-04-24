package br.com.incode.regenerari.model.repository.baixaInsumoExcepcional;

import br.com.incode.regenerari.entity.BaixaInsumoExcepcionalEntity;
import com.powerlogic.jcompany.core.model.repository.PlcAbstractRepository;

/**
 * Created by leandrolimadasilva on 24/04/17.
 */
public class BaixaInsumoExcepcionalRepository extends PlcAbstractRepository<Long, BaixaInsumoExcepcionalEntity> {

    @Override
    public Class<BaixaInsumoExcepcionalEntity> getEntityType() {
        return BaixaInsumoExcepcionalEntity.class;
    }

}

