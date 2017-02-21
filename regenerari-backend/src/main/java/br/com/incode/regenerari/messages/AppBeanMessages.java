package br.com.incode.regenerari.messages;

import com.powerlogic.jcompany.core.exception.PlcException;
import com.powerlogic.jcompany.core.messages.IPlcMessageKey;

/**
 * Created by leandrolimadasilva on 21/12/16.
 */
public enum AppBeanMessages implements IPlcMessageKey {

    USUARIO_ERROR_SENHA_CONFIRMASENHA_INVALIDOS,
    USUARIO_ERROR_SENHA_INVALIDA,
    USUARIO_ERROR_SENHA_INVALIDA_INFO,
    USUARIO_ERROR_PERFIL,
    USUARIO_ERROR_JA_CADASTRADO,
    USUARIO_SUCCESS_ALTERAR_SENHA,
    USUARIO_ERROR_SENHA_ATUAL,
    USUARIO_SUCCESS_REGISTER,

    ;
    public String getName()
    {
        return name();
    }
    public PlcException create()
    {
        return new PlcException(this);
    }
    public PlcException create(String... args)
    {
        return new PlcException(this, args);
    }
}
