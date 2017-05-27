package br.com.incode.regenerari.rest;

import br.com.incode.regenerari.dto.OrdemProducaoGeracaoDTO;
import br.com.incode.regenerari.entity.OrdemProducaoEntity;
import br.com.incode.regenerari.messages.AppBeanMessages;
import br.com.incode.regenerari.model.service.ordemProducao.IOrdemProducaoService;
import com.powerlogic.jcompany.commons.util.message.PlcMsgUtil;
import com.powerlogic.jcompany.core.exception.PlcException;
import com.powerlogic.jcompany.core.messages.PlcMessageType;
import com.powerlogic.jcompany.core.rest.PlcAbstractRest;
import com.powerlogic.jcompany.core.rest.auth.PlcAuthenticated;
import com.powerlogic.jcompany.core.rest.messages.PlcMessageIntercept;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by leandrolimadasilva on 26/05/17
 */
@PlcAuthenticated
@Path("/entity/ordem-producao")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
@PlcMessageIntercept
public class OrdemProducaoRest extends PlcAbstractRest {

    @Inject
    private IOrdemProducaoService ordemProducaoService;

    @Inject
    private PlcMsgUtil msgUtil;

    /** Ordem de producao Geracao
     *
     * @param dto
     * @return
     * @throws PlcException
     */
    @POST
    @Path("/geracao")
    public OrdemProducaoEntity entrada(OrdemProducaoGeracaoDTO dto) throws PlcException {
        msgUtil.msg(AppBeanMessages.ESTOQUE_INSUMO_SUCCESS_ENTRADA, PlcMessageType.SUCCESS);
        return null;
    }




}
