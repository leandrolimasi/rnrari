package br.com.incode.regenerari.rest;

/**
 * Created by leandrolimadasilva on 30/01/17.
 */

import br.com.incode.regenerari.bo.UsuarioBO;
import br.com.incode.regenerari.entity.UsuarioEntity;
import br.com.incode.regenerari.messages.AppBeanMessages;
import br.com.incode.regenerari.model.service.usuario.IUsuarioService;
import com.powerlogic.jcompany.commons.util.message.PlcMsgUtil;
import com.powerlogic.jcompany.core.exception.PlcException;
import com.powerlogic.jcompany.core.messages.PlcMessageType;
import com.powerlogic.jcompany.core.model.service.IPlcEntityService;
import com.powerlogic.jcompany.core.rest.auth.PlcNotAuthenticated;
import com.powerlogic.jcompany.core.rest.entity.PlcAbstractEntityRest;
import com.powerlogic.jcompany.core.rest.messages.PlcMessageIntercept;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by leandrolimasi on 19/10/16.
 */
@PlcNotAuthenticated
@Path("/entity/usuario")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
@PlcMessageIntercept
public class UsuarioRest extends PlcAbstractEntityRest<Long, UsuarioEntity, Object> {



    @Inject
    private IUsuarioService usuarioService;
    @Inject
    private PlcMsgUtil msgUtil;

    @Override
    protected IPlcEntityService<Long, UsuarioEntity> getEntityService() {
        return usuarioService;
    }

    /** Gravar usuario
     *
     * @param entity
     * @return
     * @throws PlcException
     */
    @POST
    @Path("/save")
    public UsuarioEntity save(UsuarioEntity entity) throws PlcException {
        UsuarioEntity usuario =  usuarioService.save(entity);
        msgUtil.clearMensagens();
        msgUtil.msg(AppBeanMessages.USUARIO_SUCCESS_REGISTER, PlcMessageType.SUCCESS);
        usuario.setSenha(null);
        usuario.setConfirmaSenha(null);
        return usuario;
    }

}
