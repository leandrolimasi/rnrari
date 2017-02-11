package br.com.incode.regenerari.bo;

import br.com.incode.regenerari.entity.UsuarioEntity;
import br.com.incode.regenerari.entity.UsuarioRoleEntity;
import br.com.incode.regenerari.enums.Status;
import br.com.incode.regenerari.util.AppUtil;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by leandrolimadasilva on 30/01/17.
 */
public class UsuarioBO {

    @Inject
    private AppUtil appUtil;

    /** Configura valores iniciais do usuario.
     *
     * @param usuario
     */
    public void configuraNovoUsuario(UsuarioEntity usuario){
        if (usuario.getId() == null){
            usuario.setSenha(appUtil.encriptaSenha(usuario.getSenha()));
            usuario.setConfirmaSenha(appUtil.encriptaSenha(usuario.getConfirmaSenha()));
            usuario.setStatus(Status.ATIVO);
            List<UsuarioRoleEntity> roles = new ArrayList<>();
            UsuarioRoleEntity role = new UsuarioRoleEntity();
            role.setUsuario(usuario);
            roles.add(role);
            usuario.setRoles(roles);
        }
    }

}
