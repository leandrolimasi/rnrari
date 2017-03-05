package br.com.incode.regenerari.model.repository.produto;

import br.com.incode.regenerari.auth.AppAuthenticatedUserInfo;
import br.com.incode.regenerari.entity.InsumoEntity;
import br.com.incode.regenerari.entity.ProdutoEntity;
import com.powerlogic.jcompany.core.exception.PlcException;
import com.powerlogic.jcompany.core.model.qbe.OrderBy;
import com.powerlogic.jcompany.core.model.qbe.OrderByDirection;
import com.powerlogic.jcompany.core.model.qbe.SearchParameters;
import com.powerlogic.jcompany.core.model.repository.PlcAbstractRepository;
import com.powerlogic.jcompany.core.rest.auth.PlcAuthenticatedUserInfo;

import javax.enterprise.inject.spi.CDI;
import javax.persistence.metamodel.ManagedType;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * Created by leandrolimadasilva on 21/12/16.
 */
public class ProdutoRepository extends PlcAbstractRepository<Long, ProdutoEntity> {

    @Override
    public Class<ProdutoEntity> getEntityType() {
        return ProdutoEntity.class;
    }

    @Override
    public List<ProdutoEntity> findAll(ProdutoEntity entity) throws PlcException {
        SearchParameters sp = new SearchParameters();

        ManagedType<InsumoEntity> mt = getEntityManager().getMetamodel().entity(InsumoEntity.class);
        sp.addOrderBy(new OrderBy(OrderByDirection.ASC, mt.getAttribute("nome")));

        sp.caseInsensitive().anywhere();

        sp.addMultiSelectProperties("id", "codigo", "nome");

        return super.find(entity, sp);
    }

    @Override
    protected void logicalRemove(ProdutoEntity entity) {

        if (entity.getProdutoExperimental()){
            physicalRemove(entity);
        }else{
            HttpServletRequest request = CDI.current().select(HttpServletRequest.class).get();
            AppAuthenticatedUserInfo userInfo = (AppAuthenticatedUserInfo)
                    request.getSession().getAttribute(PlcAuthenticatedUserInfo.PROPERTY);

            entity.setUsuarioInativacao(userInfo.getUsuario());
            entity.setDataInativacao(new Date());

            super.logicalRemove(entity);
        }

    }


}
