package br.com.incode.regenerari.auth;

import br.com.incode.regenerari.entity.UsuarioEntity;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
@SessionScoped
public class UserInfoBean implements Serializable {
    private UsuarioEntity usuario;
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
