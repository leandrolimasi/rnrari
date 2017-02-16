package br.com.incode.regenerari.bo;

import br.com.incode.regenerari.entity.UsuarioEntity;
import br.com.incode.regenerari.entity.UsuarioRoleEntity;
import br.com.incode.regenerari.enums.Status;
import br.com.incode.regenerari.util.AppUtil;
import org.apache.commons.collections.CollectionUtils;

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
    public void configuraUsuario(UsuarioEntity usuario){

        if (usuario.getId() == null){
            usuario.setSenha(appUtil.encriptaSenha(usuario.getSenha()));
        }

        if (CollectionUtils.isNotEmpty(usuario.getRoles())){
            for (UsuarioRoleEntity role: usuario.getRoles()){
                role.setUsuario(usuario);
                role.setLogin(usuario.getLogin());
            }
        }
    }

}
