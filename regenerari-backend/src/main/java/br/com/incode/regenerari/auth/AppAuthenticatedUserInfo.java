package br.com.incode.regenerari.auth;

import br.com.incode.regenerari.entity.UsuarioEntity;
import com.powerlogic.jcompany.core.rest.auth.PlcAuthenticatedUserInfo;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Specializes;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.security.Principal;
import java.util.List;

/**
 * Created by leandrolimadasilva on 21/02/17.
 */
@SessionScoped
@Specializes
public class AppAuthenticatedUserInfo extends PlcAuthenticatedUserInfo {

    private UsuarioEntity usuario;

    /*
     */
    public AppAuthenticatedUserInfo(){}

    /**
     *
     * @param userPrincipal
     * @param host
     * @param roles
     * @param usuario
     */
    public AppAuthenticatedUserInfo(Principal userPrincipal, String host, List<String> roles, UsuarioEntity usuario) {
        super(userPrincipal.getName(), host, roles);
        this.usuario = usuario;
    }

    /**
     * @return the usuario
     */
    public UsuarioEntity getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }
}
