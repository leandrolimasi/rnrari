package br.com.incode.regenerari.auth;

import br.com.incode.regenerari.entity.UsuarioEntity;
import br.com.incode.regenerari.model.service.usuario.IUsuarioService;
import com.powerlogic.jcompany.core.exception.PlcException;
import com.powerlogic.jcompany.core.rest.auth.PlcAuthenticatedUserInfo;
import com.powerlogic.jcompany.core.rest.auth.PlcAuthenticationProvider;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Specializes;
import javax.enterprise.inject.spi.CDI;
import java.security.Principal;
import java.util.List;

/**
 * Created by leandrolimadasilva on 21/02/17.
 */
@ApplicationScoped
@Specializes
public class AppAuthenticationProvider extends PlcAuthenticationProvider{

    @Override
    public PlcAuthenticatedUserInfo createUser(Principal userPrincipal, String host, List<String> roles) throws PlcException {
        IUsuarioService usuarioService = CDI.current().select(IUsuarioService.class).get();
        UsuarioEntity usuario = usuarioService.findUsuarioByLogin(userPrincipal.getName());
        AppAuthenticatedUserInfo userInfo =  new AppAuthenticatedUserInfo(userPrincipal, host, roles, usuario);
        userInfo.setUsuario(usuario);
        return userInfo;
    }
}
