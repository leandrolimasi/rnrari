package br.com.incode.regenerari.rest;

/**
 * Created by leandrolimadasilva on 21/02/17.
 */

import br.com.incode.regenerari.entity.ComposicaoProdutoEntity;
import br.com.incode.regenerari.model.service.composicaoProduto.IComposicaoProdutoService;
import com.powerlogic.jcompany.core.model.service.IPlcEntityService;
import com.powerlogic.jcompany.core.rest.auth.PlcNotAuthenticated;
import com.powerlogic.jcompany.core.rest.entity.PlcAbstractEntityRest;
import com.powerlogic.jcompany.core.rest.messages.PlcMessageIntercept;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by leandrolimasi on 20/02/2017.
 */
@PlcNotAuthenticated
@Path("/entity/composicao-produto")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
@PlcMessageIntercept
public class ComposicaoProdutoRest extends PlcAbstractEntityRest<Long, ComposicaoProdutoEntity> {

    @Inject
    private IComposicaoProdutoService composicaoProdutoService;

    @Override
    protected IPlcEntityService<Long, ComposicaoProdutoEntity> getEntityService() {
        return composicaoProdutoService;
    }

}
