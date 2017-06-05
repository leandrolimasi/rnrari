package br.com.incode.regenerari.rest;

import br.com.incode.regenerari.dto.OrdemProducaoGeracaoDTO;
import br.com.incode.regenerari.dto.TimestampDTO;
import br.com.incode.regenerari.entity.OrdemProducaoEntity;
import br.com.incode.regenerari.model.service.ordemProducao.IOrdemProducaoService;
import com.powerlogic.jcompany.commons.util.message.PlcMsgUtil;
import com.powerlogic.jcompany.core.commons.search.PlcPagedResult;
import com.powerlogic.jcompany.core.exception.PlcException;
import com.powerlogic.jcompany.core.model.service.IPlcEntityService;
import com.powerlogic.jcompany.core.rest.auth.PlcAuthenticated;
import com.powerlogic.jcompany.core.rest.entity.PlcAbstractEntityRest;
import com.powerlogic.jcompany.core.rest.messages.PlcMessageIntercept;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by leandrolimadasilva on 26/05/17
 */
@PlcAuthenticated
@Path("/entity/ordem-producao")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
@PlcMessageIntercept
public class OrdemProducaoRest extends PlcAbstractEntityRest<Long, OrdemProducaoEntity> {

    @Inject
    private IOrdemProducaoService ordemProducaoService;

    @Inject
    private PlcMsgUtil msgUtil;

    @Override
    protected IPlcEntityService<Long, OrdemProducaoEntity> getEntityService() {
        return ordemProducaoService;
    }

    /** Ordem de producao Geracao
     *
     * @param dto
     * @return
     * @throws PlcException
     */
    @POST
    @Path("/gerar")
    public OrdemProducaoEntity gerar(OrdemProducaoGeracaoDTO dto) throws PlcException {
        return ordemProducaoService.gerar(dto);
    }

    /** Cancelar de producao Geracao
     *
     * @param entity
     * @return
     * @throws PlcException
     */
    @POST
    @Path("/cancelar")
    public OrdemProducaoEntity cancelar(OrdemProducaoEntity entity) throws PlcException {
        return ordemProducaoService.cancelar(entity);
    }

    @GET
    @Path("/numeroOrdemProducao")
    public TimestampDTO getNumeroOrdemProducao(){
        TimestampDTO dto = new TimestampDTO();
        dto.setTimestamp(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));
        return dto;
    }


    @Override
    public PlcPagedResult<OrdemProducaoEntity> findPaged() throws PlcException {
        PlcPagedResult<OrdemProducaoEntity> result = super.findPaged();

        for (OrdemProducaoEntity ordemProducao: result.getList()){
            ordemProducao.setMotivoOrdemProducaoDescricao(ordemProducao.getMotivoOrdemProducao().getLabel());
            ordemProducao.setStatusOrdemProducaoDescricao(ordemProducao.getStatusOrdemProducao().getLabel());
        }

        return result;
    }
}
