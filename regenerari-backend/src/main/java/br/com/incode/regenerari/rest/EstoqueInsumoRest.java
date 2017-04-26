package br.com.incode.regenerari.rest;

import br.com.incode.regenerari.dto.BaixaInsumoExcepcionalDTO;
import br.com.incode.regenerari.dto.EntradaEstoqueInsumoDTO;
import br.com.incode.regenerari.entity.BaixaInsumoExcepcionalEntity;
import br.com.incode.regenerari.entity.EstoqueInsumoEntity;
import br.com.incode.regenerari.entity.InsumoEntity;
import br.com.incode.regenerari.entity.PosicaoEstoqueInsumoEntity;
import br.com.incode.regenerari.messages.AppBeanMessages;
import br.com.incode.regenerari.model.service.baixaInsumoExcepcional.IBaixaInsumoExcepcionalService;
import br.com.incode.regenerari.model.service.estoqueInsumo.IEstoqueInsumoService;
import br.com.incode.regenerari.model.service.posicaoEstoqueInsumo.IPosicaoEstoqueInsumoService;
import com.powerlogic.jcompany.commons.util.message.PlcMsgUtil;
import com.powerlogic.jcompany.core.exception.PlcException;
import com.powerlogic.jcompany.core.messages.PlcMessageType;
import com.powerlogic.jcompany.core.rest.PlcAbstractRest;
import com.powerlogic.jcompany.core.rest.auth.PlcAuthenticated;
import com.powerlogic.jcompany.core.rest.messages.PlcMessageIntercept;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by leandrolimadasilva on 12/04/17.
 */
@PlcAuthenticated
@Path("/entity/estoque-insumo")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
@PlcMessageIntercept
public class EstoqueInsumoRest extends PlcAbstractRest {

    @Inject
    private IEstoqueInsumoService estoqueInsumoService;

    @Inject
    private IBaixaInsumoExcepcionalService baixaInsumoExcepcionalService;

    @Inject
    private IPosicaoEstoqueInsumoService posicaoEstoqueInsumoService;

    @Inject
    private PlcMsgUtil msgUtil;

    /** Entrada de estoque de Insumos
     *
     * @param dto
     * @return
     * @throws PlcException
     */
    @POST
    @Path("/entrada")
    public PosicaoEstoqueInsumoEntity entrada(EntradaEstoqueInsumoDTO dto) throws PlcException {
        PosicaoEstoqueInsumoEntity posicaoEstoqueInsumo =  estoqueInsumoService.entrada(dto);
        msgUtil.msg(AppBeanMessages.ESTOQUE_INSUMO_SUCCESS_ENTRADA, PlcMessageType.SUCCESS);
        return posicaoEstoqueInsumo;
    }

    /** baixa de estoque de Insumos por evento excepcional
     *
     * @param dto
     * @return
     * @throws PlcException
     */
    @POST
    @Path("/baixa-excepcional")
    public PosicaoEstoqueInsumoEntity entrada(BaixaInsumoExcepcionalDTO dto) throws PlcException {
        PosicaoEstoqueInsumoEntity posicaoEstoqueInsumo =  baixaInsumoExcepcionalService.baixa(dto);
        msgUtil.msg(AppBeanMessages.ESTOQUE_INSUMO_SUCCESS_BAIXA_EXCEPCIONAL, PlcMessageType.SUCCESS);
        return posicaoEstoqueInsumo;
    }

    /** consulta posicao estoque de um insumo
     *
     * @param idInsumo
     * @return
     * @throws PlcException
     */
    @GET
    @Path("/posicao-estoque/{idInsumo}")
    public PosicaoEstoqueInsumoEntity getPosicaoEstoque(@PathParam("idInsumo") String idInsumo) throws PlcException {
        InsumoEntity insumo = new InsumoEntity(Long.parseLong(idInsumo));
        return posicaoEstoqueInsumoService.recuperaPosicaoEstoqueInsumo(insumo);
    }


}
