package br.com.incode.regenerari.rest;

import br.com.incode.regenerari.entity.PosicaoEstoqueProdutoEntity;
import br.com.incode.regenerari.entity.ProdutoEntity;
import br.com.incode.regenerari.model.service.posicaoEstoqueProduto.IPosicaoEstoqueProdutoService;
import com.powerlogic.jcompany.commons.util.message.PlcMsgUtil;
import com.powerlogic.jcompany.commons.util.validation.PlcValidationConstraintsDTO;
import com.powerlogic.jcompany.core.exception.PlcException;
import com.powerlogic.jcompany.core.messages.PlcBeanMessages;
import com.powerlogic.jcompany.core.model.service.IPlcEntityService;
import com.powerlogic.jcompany.core.rest.auth.PlcAuthenticated;
import com.powerlogic.jcompany.core.rest.entity.PlcAbstractEntityRest;
import com.powerlogic.jcompany.core.rest.messages.PlcMessageIntercept;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by leandrolimadasilva on 12/04/17.
 */
@PlcAuthenticated
@Path("/entity/estoque-produto")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
@PlcMessageIntercept
public class EstoqueProdutoRest extends PlcAbstractEntityRest<Long, PosicaoEstoqueProdutoEntity>{

    @Inject
    private IPosicaoEstoqueProdutoService posicaoEstoqueProdutoService;

    @Inject
    private PlcMsgUtil msgUtil;

    @Override
    protected IPlcEntityService<Long, PosicaoEstoqueProdutoEntity> getEntityService() {
        return posicaoEstoqueProdutoService;
    }

    /** consulta posicao estoque de um produto
     *
     * @param idProduto
     * @return
     * @throws PlcException
     */
    @GET
    @Path("/posicao-estoque/{idProduto}")
    public PosicaoEstoqueProdutoEntity getPosicaoEstoque(@PathParam("idProduto") String idProduto) throws PlcException {
        ProdutoEntity produto = new ProdutoEntity(Long.parseLong(idProduto));
        return posicaoEstoqueProdutoService.recuperaPosicaoEstoqueProduto(produto);
    }

    @Override
    public PosicaoEstoqueProdutoEntity get(Long entityId) throws PlcException {
        throw new PlcException(PlcBeanMessages.ACESSO_NEGADO_033);
    }

    @Override
    public List<PosicaoEstoqueProdutoEntity> findAll() throws PlcException {
        throw new PlcException(PlcBeanMessages.ACESSO_NEGADO_033);
    }

    @Override
    public PosicaoEstoqueProdutoEntity save(PosicaoEstoqueProdutoEntity entity) throws PlcException {
        throw new PlcException(PlcBeanMessages.ACESSO_NEGADO_033);
    }

    @Override
    public boolean remove(PosicaoEstoqueProdutoEntity entity) throws PlcException {
        throw new PlcException(PlcBeanMessages.ACESSO_NEGADO_033);
    }

    @Override
    public PlcValidationConstraintsDTO getEntityBeanValidationMetadata() {
        throw new PlcException(PlcBeanMessages.ACESSO_NEGADO_033);
    }
}
