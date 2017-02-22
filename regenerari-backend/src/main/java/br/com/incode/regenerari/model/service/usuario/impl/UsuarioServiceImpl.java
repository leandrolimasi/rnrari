package br.com.incode.regenerari.model.service.usuario.impl;

import br.com.incode.regenerari.bo.UsuarioBO;
import br.com.incode.regenerari.dto.AlterarSenhaDTO;
import br.com.incode.regenerari.entity.UsuarioEntity;
import br.com.incode.regenerari.messages.AppBeanMessages;
import br.com.incode.regenerari.model.repository.usuario.UsuarioRepository;
import br.com.incode.regenerari.model.service.usuario.IUsuarioService;
import br.com.incode.regenerari.util.AppUtil;
import com.powerlogic.jcompany.commons.interceptor.validation.PlcValidationInterceptor;
import com.powerlogic.jcompany.core.exception.PlcException;
import com.powerlogic.jcompany.core.messages.PlcMessageType;
import com.powerlogic.jcompany.core.model.repository.IPlcEntityRepository;
import com.powerlogic.jcompany.core.model.service.PlcAbstractServiceEntity;
import org.apache.commons.collections.CollectionUtils;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.validation.Valid;

/**
 * Created by leandrolimadasilva on 20/12/16.
 */
@Stateless
@Interceptors({PlcValidationInterceptor.class})
public class UsuarioServiceImpl extends PlcAbstractServiceEntity<Long, UsuarioEntity> implements IUsuarioService {
    @Inject
    private UsuarioRepository usuarioRepository;
    @Inject
    private UsuarioBO usuarioBO;
    @Inject
    private AppUtil appUtil;
    @Override
    protected IPlcEntityRepository<Long, UsuarioEntity> getEntityRepository() {
        return usuarioRepository;
    }
    @Override
    public UsuarioEntity save(@Valid UsuarioEntity entity) throws PlcException {

        //verifica perfil usuario
        if (CollectionUtils.isEmpty(entity.getRoles()) ||
                ( entity.getRoles().get(0) != null && entity.getRoles().get(0).getPerfil() == null)){
            throw  new PlcException(AppBeanMessages.USUARIO_ERROR_PERFIL);
        }

        checaSenha(entity);

        //verifica usuario ja cadastrado
        if (entity.getId() == null && findUsuarioByLogin(entity.getLogin()) != null){
            throw  new PlcException(AppBeanMessages.USUARIO_ERROR_JA_CADASTRADO);
        }

        // recuperando senha
        if (entity.getId() != null){
            UsuarioEntity ant = usuarioRepository.get(entity.getId());
            entity.setSenha(ant.getSenha());
        }

        usuarioBO.configuraUsuario(entity);

        return super.save(entity);
    }

    private void checaSenha(@Valid UsuarioEntity entity) {

        //verifica os campos senha e confirmaSenha
        if (entity.getId() == null && !entity.getSenha().equals(entity.getConfirmaSenha())){
            throw  new PlcException(AppBeanMessages.USUARIO_ERROR_SENHA_CONFIRMASENHA_INVALIDOS);
        }else if (entity.getId() != null && !entity.getSenha().equals(entity.getConfirmaSenha())){
            throw  new PlcException(AppBeanMessages.USUARIO_ERROR_NOVA_SENHA_CONFIRMASENHA_INVALIDOS);
        }

        //verifica senha valida
        if (!appUtil.validaSenha(entity.getSenha())){
            PlcException e = new PlcException(AppBeanMessages.USUARIO_ERROR_SENHA_INVALIDA);
            e.getMessageMap().addMessage(AppBeanMessages.USUARIO_ERROR_SENHA_INVALIDA_INFO, PlcMessageType.ERROR);
            throw e;
        }
    }

    /**
     * Recupera usuario por login.
     *
     * @param login login de acesso do usuario
     *
     * @return usuario
     */
    @Override
    public UsuarioEntity findUsuarioByLogin(String login) {
        return usuarioRepository.findUsuarioByLogin(login);
    }

    /**
     * Altera a senha de um usuario
     *
     * @param dto AlterarSenhaDTO
     *
     * @return
     */
    @Override
    public UsuarioEntity alteraSenha(AlterarSenhaDTO dto) {
        UsuarioEntity usuarioAtual = usuarioRepository.get(dto.getIdUsuario());

        String senhaCripto = appUtil.encriptaSenha(dto.getSenhaAtual());
        String novaSenhaCripto = appUtil.encriptaSenha(dto.getNovaSenha());
        String confirmaNovaSenhaCripto = appUtil.encriptaSenha(dto.getConfirmaNovaSenha());

        //confere senha atual
        if (!usuarioAtual.getSenha().equals(senhaCripto)){
            throw  new PlcException(AppBeanMessages.USUARIO_ERROR_SENHA_ATUAL);
        }

        usuarioAtual.setSenha(novaSenhaCripto);
        usuarioAtual.setConfirmaSenha(confirmaNovaSenhaCripto);
        checaSenha(usuarioAtual);

        return usuarioRepository.save(usuarioAtual);
    }

}