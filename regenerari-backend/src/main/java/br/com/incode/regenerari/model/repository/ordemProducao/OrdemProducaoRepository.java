package br.com.incode.regenerari.model.repository.ordemProducao;

import br.com.incode.regenerari.entity.OrdemProducaoEntity;
import com.powerlogic.jcompany.core.model.repository.PlcAbstractRepository;

/**
 * Created by leandrolimadasilva on 26/05/17.
 */
public class OrdemProducaoRepository extends PlcAbstractRepository<Long, OrdemProducaoEntity> {


    @Override
    public Class<OrdemProducaoEntity> getEntityType() {
        return OrdemProducaoEntity.class;
    }


}
