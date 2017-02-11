package br.com.incode.regenerari.model.service.usuario.impl;

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
    private AppUtil appUtil;
    @Override
    protected IPlcEntityRepository<Long, UsuarioEntity> getEntityRepository() {
        return usuarioRepository;
    }
    @Override
    public UsuarioEntity save(@Valid UsuarioEntity entity) throws PlcException {
        //verifica os campos senha e confirmaSenha
        if (!entity.getSenha().equals(entity.getConfirmaSenha())){
            throw  new PlcException(AppBeanMessages.GERAL_SENHA_CONFIRMASENHA_INVALIDOS);
        }
        //verifica senha valida
        if (!appUtil.validaSenha(entity.getSenha())){
            PlcException e = new PlcException(AppBeanMessages.USUARIO_ERRO_SENHA_INVALIDA);
            e.getMessageMap().addMessage(AppBeanMessages.USUARIO_ERRO_SENHA_INVALIDA_INFO, PlcMessageType.ERROR);
            throw e;
        }
        //verifica empresa ja cadastrada por email ou cnpj iguais
        if (entity.getId() == null && findUsuarioByLogin(entity.getLogin()) != null){
            throw  new PlcException(AppBeanMessages.USUARIO_ERRO_JA_CADASTRADO);
        }
        return super.save(entity);
    }
    /**
     * Recupera usuario por email.
     *
     * @param email login de acesso do usuario (email)
     *
     * @return usuario
     */
    @Override
    public UsuarioEntity findUsuarioByLogin(String email) {
        return usuarioRepository.findUsuarioByLogin(email);
    }

}