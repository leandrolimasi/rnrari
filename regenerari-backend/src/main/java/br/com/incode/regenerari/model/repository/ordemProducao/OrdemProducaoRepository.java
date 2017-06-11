package br.com.incode.regenerari.model.repository.ordemProducao;

import br.com.incode.regenerari.entity.OrdemProducaoEntity;
import com.powerlogic.jcompany.core.commons.search.PlcPagedResult;
import com.powerlogic.jcompany.core.commons.search.PlcPagination;
import com.powerlogic.jcompany.core.model.qbe.OrderBy;
import com.powerlogic.jcompany.core.model.qbe.OrderByDirection;
import com.powerlogic.jcompany.core.model.qbe.SearchParameters;
import com.powerlogic.jcompany.core.model.repository.PlcAbstractRepository;

import javax.persistence.metamodel.ManagedType;

/**
 * Created by leandrolimadasilva on 26/05/17.
 */
public class OrdemProducaoRepository extends PlcAbstractRepository<Long, OrdemProducaoEntity> {


    @Override
    public Class<OrdemProducaoEntity> getEntityType() {
        return OrdemProducaoEntity.class;
    }


    @Override
    public PlcPagedResult<OrdemProducaoEntity> findPaged(OrdemProducaoEntity entity, SearchParameters sp,
                                                         PlcPagination<OrdemProducaoEntity> config) {

        ManagedType<OrdemProducaoEntity> mt = getEntityManager().getMetamodel().entity(OrdemProducaoEntity.class);
        sp.addOrderBy(new OrderBy(OrderByDirection.DESC, mt.getAttribute("statusOrdemProducao")));
        sp.addOrderBy(new OrderBy(OrderByDirection.ASC, mt.getAttribute("motivoOrdemProducao")));
        sp.addOrderBy(new OrderBy(OrderByDirection.ASC, mt.getAttribute("numero")));
        sp.caseInsensitive().anywhere();

        return super.findPaged(entity, sp, config);
    }
}
