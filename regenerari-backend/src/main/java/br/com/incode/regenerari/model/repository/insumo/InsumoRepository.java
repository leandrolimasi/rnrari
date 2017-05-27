package br.com.incode.regenerari.model.repository.insumo;

import br.com.incode.regenerari.auth.AppAuthenticatedUserInfo;
import br.com.incode.regenerari.entity.InsumoEntity;
import com.powerlogic.jcompany.core.commons.search.PlcPagedResult;
import com.powerlogic.jcompany.core.commons.search.PlcPagination;
import com.powerlogic.jcompany.core.model.qbe.OrderBy;
import com.powerlogic.jcompany.core.model.qbe.OrderByDirection;
import com.powerlogic.jcompany.core.model.qbe.SearchParameters;
import com.powerlogic.jcompany.core.model.repository.PlcAbstractRepository;
import com.powerlogic.jcompany.core.rest.auth.PlcAuthenticatedUserInfo;

import javax.enterprise.inject.spi.CDI;
import javax.persistence.metamodel.ManagedType;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by leandrolimadasilva on 21/12/16.
 */
public class InsumoRepository extends PlcAbstractRepository<Long, InsumoEntity> {


    @Override
    public Class<InsumoEntity> getEntityType() {
        return InsumoEntity.class;
    }

    @Override
    public PlcPagedResult<InsumoEntity> findPaged(InsumoEntity entity, SearchParameters sp, PlcPagination<InsumoEntity> config) {

        ManagedType<InsumoEntity> mt = getEntityManager().getMetamodel().entity(InsumoEntity.class);
        sp.addOrderBy(new OrderBy(OrderByDirection.ASC, mt.getAttribute("nome")));
        sp.caseInsensitive().anywhere();

        return super.findPaged(entity, sp, config);
    }

    @Override
    protected void logicalRemove(InsumoEntity entity) {
        HttpServletRequest request = CDI.current().select(HttpServletRequest.class).get();
        AppAuthenticatedUserInfo userInfo = (AppAuthenticatedUserInfo)
                request.getSession().getAttribute(PlcAuthenticatedUserInfo.PROPERTY);

        entity.setUsuarioInativacao(userInfo.getUsuario());
        entity.setDataInativacao(new Date());

        super.logicalRemove(entity);
    }

}
