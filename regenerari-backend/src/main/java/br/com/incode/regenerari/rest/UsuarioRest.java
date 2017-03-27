package br.com.incode.regenerari.rest;

/**
 * Created by leandrolimadasilva on 30/01/17.
 */

import br.com.incode.regenerari.dto.AlterarSenhaDTO;
import br.com.incode.regenerari.entity.UsuarioEntity;
import br.com.incode.regenerari.messages.AppBeanMessages;
import br.com.incode.regenerari.model.service.usuario.IUsuarioService;
import com.powerlogic.jcompany.commons.util.message.PlcMsgUtil;
import com.powerlogic.jcompany.core.commons.search.PlcPage;
import com.powerlogic.jcompany.core.commons.search.PlcPagedResult;
import com.powerlogic.jcompany.core.exception.PlcException;
import com.powerlogic.jcompany.core.messages.PlcBeanMessages;
import com.powerlogic.jcompany.core.messages.PlcMessageType;
import com.powerlogic.jcompany.core.model.service.IPlcEntityService;
import com.powerlogic.jcompany.core.rest.PlcSearchBuilder;
import com.powerlogic.jcompany.core.rest.auth.PlcAuthenticated;
import com.powerlogic.jcompany.core.rest.messages.PlcMessageIntercept;
import org.apache.commons.collections.CollectionUtils;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 * Created by leandrolimasi on 19/10/16.
 */
@PlcAuthenticated
@Path("/entity/usuario")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
@PlcMessageIntercept
public class UsuarioRest extends AppBaseRest<Long, UsuarioEntity>{

    @Inject
    private IUsuarioService usuarioService;

    @Inject
    private PlcMsgUtil msgUtil;

    @Context
    private UriInfo uriInfo;



    @Override
    protected IPlcEntityService<Long, UsuarioEntity> getEntityService() {
        return usuarioService;
    }




    @Override
    public PlcPagedResult<UsuarioEntity> findPaged() throws PlcException {
        UsuarioEntity entity = mountEntityFromURI(uriInfo);

        if(!isAdmin()){
            entity.setId(getCurrentUser().getId());
        }

        PlcPage page = mountPaginationFromURI(uriInfo);
        PlcPagedResult<UsuarioEntity> result=  getEntityService().findPaged(entity, PlcSearchBuilder.build(entity.getClass(),
                page.getPage(), page.getSize(),
                page.getOrder(), page.getDirection()));

        if (CollectionUtils.isEmpty(result.getList())) {
            msgUtil.msg(PlcBeanMessages.NENHUM_REGISTRO_ENCONTRADO_022, PlcMessageType.INFO);
        }

        return result;

    }

    /** Gravar usuario
     *
     * @param entity
     * @return
     * @throws PlcException
     */
    @Override
    public UsuarioEntity save(UsuarioEntity entity) throws PlcException {
        UsuarioEntity usuario =  usuarioService.save(entity);
        msgUtil.clearMensagens();
        msgUtil.msg(AppBeanMessages.USUARIO_SUCCESS_REGISTER, PlcMessageType.SUCCESS);
        usuario.setSenha(null);
        usuario.setConfirmaSenha(null);
        return usuario;
    }

    /** Gravar usuario
     *
     * @param dto
     * @return
     * @throws PlcException
     */
    @POST
    @Path("/alterarSenha")
    public UsuarioEntity alterarSenha(AlterarSenhaDTO dto) throws PlcException {
        UsuarioEntity usuario =  usuarioService.alteraSenha(dto);
        msgUtil.clearMensagens();
        msgUtil.msg(AppBeanMessages.USUARIO_SUCCESS_ALTERAR_SENHA, PlcMessageType.SUCCESS);
        usuario.setSenha(null);
        usuario.setConfirmaSenha(null);
        return usuario;
    }

}
