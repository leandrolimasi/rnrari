package br.com.incode.regenerari.rest;

/**
 * Created by leandrolimadasilva on 30/01/17.
 */

import br.com.incode.regenerari.entity.InsumoEntity;
import br.com.incode.regenerari.entity.ProdutoEntity;
import br.com.incode.regenerari.messages.AppBeanMessages;
import br.com.incode.regenerari.model.service.insumo.IInsumoService;
import com.powerlogic.jcompany.core.exception.PlcException;
import com.powerlogic.jcompany.core.model.service.IPlcEntityService;
import com.powerlogic.jcompany.core.rest.auth.PlcNotAuthenticated;
import com.powerlogic.jcompany.core.rest.entity.PlcAbstractEntityRest;
import com.powerlogic.jcompany.core.rest.messages.PlcMessageIntercept;
import org.hibernate.exception.ConstraintViolationException;

import javax.ejb.EJBTransactionRolledbackException;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by leandrolimasi on 20/02/2017.
 */
@PlcNotAuthenticated
@Path("/entity/insumo")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
@PlcMessageIntercept
public class InsumoRest extends AppBaseRest<Long, InsumoEntity> {

    @Inject
    private IInsumoService insumoService;

    @Override
    protected IPlcEntityService<Long, InsumoEntity> getEntityService() {
        return insumoService;
    }


    @Override
    public boolean remove(InsumoEntity entity) throws PlcException {
        boolean ret = false;
        try {
            ret = super.remove(entity);
        }catch (EJBTransactionRolledbackException e){
            Throwable throwable = e.getCause();
            if (findConstraintViolationException(throwable) instanceof ConstraintViolationException) {
                throw new PlcException(AppBeanMessages.INSUMO_ERROR_VINCULO_COMPOSICAO);
            }

        }
        return ret;
    }

}
