package br.com.incode.regenerari.model.repository.produto;

import br.com.incode.regenerari.auth.AppAuthenticatedUserInfo;
import br.com.incode.regenerari.entity.ProdutoEntity;
import com.powerlogic.jcompany.core.commons.search.PlcPagedResult;
import com.powerlogic.jcompany.core.commons.search.PlcPagination;
import com.powerlogic.jcompany.core.exception.PlcException;
import com.powerlogic.jcompany.core.messages.PlcBeanMessages;
import com.powerlogic.jcompany.core.model.domain.PlcSituacao;
import com.powerlogic.jcompany.core.model.qbe.OrderBy;
import com.powerlogic.jcompany.core.model.qbe.OrderByDirection;
import com.powerlogic.jcompany.core.model.qbe.SearchParameters;
import com.powerlogic.jcompany.core.model.repository.PlcAbstractRepository;
import com.powerlogic.jcompany.core.rest.auth.PlcAuthenticatedUserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.inject.spi.CDI;
import javax.persistence.metamodel.ManagedType;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by leandrolimadasilva on 21/12/16.
 */
public class ProdutoRepository extends PlcAbstractRepository<Long, ProdutoEntity> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProdutoRepository.class);

    @Override
    public Class<ProdutoEntity> getEntityType() {
        return ProdutoEntity.class;
    }

    @Override
    public PlcPagedResult<ProdutoEntity> findPaged(ProdutoEntity entity, SearchParameters sp, PlcPagination<ProdutoEntity> config) {

        ManagedType<ProdutoEntity> mt = getEntityManager().getMetamodel().entity(ProdutoEntity.class);
        sp.addOrderBy(new OrderBy(OrderByDirection.ASC, mt.getAttribute("nome")));
        sp.anywhere();
        sp.addMultiSelectProperties("id", "codigo", "nome", "versao", "unidadeMedidaProduto");

        return super.findPaged(entity, sp, config);
    }

    @Override
    public ProdutoEntity save(ProdutoEntity entity) {
        if (entity.getId() == null){
            entity.setSituacao(PlcSituacao.A);
        }
        return super.save(entity);
    }

    @Override
    public void remove(ProdutoEntity entity) {
        try {
            if(Boolean.FALSE.equals(entity.getProdutoExperimental())) {
                this.logicalRemove(entity);
            } else {
                this.physicalRemove(entity);
            }

        } catch (PlcException var3) {
            LOGGER.error(var3.getLocalizedMessage(), var3);
            throw var3;
        } catch (Exception var4) {
            LOGGER.error(var4.getLocalizedMessage(), var4);
            throw PlcBeanMessages.FALHA_PERSISTENCIA_20.create(var4, new String[]{var4.getMessage()});
        }
    }

    @Override
    protected void logicalRemove(ProdutoEntity entity) {

        HttpServletRequest request = CDI.current().select(HttpServletRequest.class).get();
        AppAuthenticatedUserInfo userInfo = (AppAuthenticatedUserInfo)
                request.getSession().getAttribute(PlcAuthenticatedUserInfo.PROPERTY);

        entity.setUsuarioInativacao(userInfo.getUsuario());
        entity.setDataInativacao(new Date());

        entity.setSituacao(PlcSituacao.E);

        super.save(entity);

    }


}
