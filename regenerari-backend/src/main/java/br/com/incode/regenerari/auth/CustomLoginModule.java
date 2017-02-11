package br.com.incode.regenerari.auth;

import br.com.incode.regenerari.entity.UsuarioEntity;
import br.com.incode.regenerari.model.service.usuario.IUsuarioService;
import org.apache.commons.lang3.StringUtils;
import org.jboss.security.SimpleGroup;
import org.jboss.security.SimplePrincipal;
import org.jboss.security.auth.spi.UsernamePasswordLoginModule;

import javax.enterprise.inject.spi.CDI;
import javax.security.auth.login.LoginException;
import java.security.acl.Group;

/**
 * Created by leandrolimadasilva on 19/12/16.
 */
public class CustomLoginModule extends UsernamePasswordLoginModule {


    /**
     * Overriden by subclasses to return the Groups that correspond to the
     * to the role sets assigned to the user. Subclasses should create at
     * least a Group named "Roles" that contains the roles assigned to the user.
     * A second common group is "CallerPrincipal" that provides the application
     * identity of the user rather than the security domain identity.
     *
     * @return Group[] containing the sets of roles
     */
    @Override
    protected Group[] getRoleSets() throws LoginException {
        IUsuarioService usuarioService = CDI.current().select(IUsuarioService.class).get();
        UsuarioEntity usuario = usuarioService.findUsuarioByLogin(this.getIdentity().getName());
        SimpleGroup group = new SimpleGroup("Roles");
        usuario.getRoles().forEach(role->{
            group.addMember(new SimplePrincipal(role.getRole()));
        });
        return new Group[] { group };
    }
    /**
     * Get the expected password for the current username available via
     * the getUsername() method. This is called from within the login()
     * method after the CallbackHandler has returned the username and
     * candidate password.
     *
     * @return the valid password String
     */
    @Override
    protected String getUsersPassword() throws LoginException {
        IUsuarioService usuarioService = CDI.current().select(IUsuarioService.class).get();
        UsuarioEntity usuario = usuarioService.findUsuarioByLogin(this.getIdentity().getName());
        return usuario == null ? StringUtils.EMPTY : usuario.getSenha();
    }
}
