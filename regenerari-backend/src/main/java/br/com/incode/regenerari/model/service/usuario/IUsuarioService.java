package br.com.incode.regenerari.model.service.usuario;

import br.com.incode.regenerari.dto.AlterarSenhaDTO;
import br.com.incode.regenerari.entity.UsuarioEntity;
import com.powerlogic.jcompany.core.model.service.IPlcEntityService;

import javax.ejb.Local;

/**
 * Created by leandrolimadasilva on 19/12/16.
 */
@Local
public  interface IUsuarioService extends IPlcEntityService<Long, UsuarioEntity> {

    /**
     * Recupera usuario por login
     *
     * @param login login de acesso do usuario
     * @return usuario
     */
    UsuarioEntity findUsuarioByLogin(String login);


    /**
     * Altera a senha de um usuario
     *
     * @param dto AlterarSenhaDTO
     *
     * @return usuario
     */
    UsuarioEntity alteraSenha(AlterarSenhaDTO dto);

}
