package br.com.incode.regenerari.model.repository.ordemProducao;

import br.com.incode.regenerari.entity.NumeroOrdemProducaoEntity;
import com.powerlogic.jcompany.core.model.repository.PlcAbstractRepository;

/**
 * Created by leandrolimadasilva on 26/05/17.
 */
public class NumeroOrdemProducaoRepository extends PlcAbstractRepository<Long, NumeroOrdemProducaoEntity> {


    @Override
    public Class<NumeroOrdemProducaoEntity> getEntityType() {
        return NumeroOrdemProducaoEntity.class;
    }


}
