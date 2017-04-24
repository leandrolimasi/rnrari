package br.com.incode.regenerari.messages;

import com.powerlogic.jcompany.core.exception.PlcException;
import com.powerlogic.jcompany.core.messages.IPlcMessageKey;

/**
 * Created by leandrolimadasilva on 21/12/16.
 */
public enum AppBeanMessages implements IPlcMessageKey {

    USUARIO_ERROR_NOVA_SENHA_CONFIRMASENHA_INVALIDOS,
    USUARIO_ERROR_SENHA_CONFIRMASENHA_INVALIDOS,
    USUARIO_ERROR_SENHA_INVALIDA,
    USUARIO_ERROR_SENHA_INVALIDA_INFO,
    USUARIO_ERROR_PERFIL,
    USUARIO_ERROR_JA_CADASTRADO,
    USUARIO_SUCCESS_ALTERAR_SENHA,
    USUARIO_ERROR_SENHA_ATUAL,
    USUARIO_SUCCESS_REGISTER,


    PRODUTO_ERROR_CODIGO_ALTERADO,
    PRODUTO_ERROR_NOME_ALTERADO,
    PRODUTO_ERROR_PRESCRICAO_ALTERADO,
    PRODUTO_ERROR_UNIDADE_MEDIDA_ALTERADO,
    PRODUTO_ERROR_APRESENTACAO_ALTERADO,
    PRODUTO_ERROR_CATEGORIA_ALTERADO,
    PRODUTO_ERROR_QUANTIDADE_ALTERADO,
    PRODUTO_ERROR_VINCULO_COMPOSICAO,

    POSICAO_ESTOQUE_INSUMO_QUANTIDADE_ZERO,


    INSUMO_ERROR_VINCULO_COMPOSICAO,

    ESTOQUE_INSUMO_SUCCESS_ENTRADA,
    ESTOQUE_INSUMO_QUANTIDADE_ZERO,
    ESTOQUE_INSUMO_VALORCOMPRATOTAL_ZERO,

    BAIXA_INSUMO_QUANTIDADE_ZERO,
    ESTOQUE_INSUMO_SUCCESS_BAIXA_EXCEPCIONAL,

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
