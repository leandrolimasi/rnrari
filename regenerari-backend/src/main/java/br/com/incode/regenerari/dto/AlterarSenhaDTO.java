package br.com.incode.regenerari.dto;

import javax.validation.constraints.NotNull;

/**
 * Created by leandro.lima on 21/02/2017.
 */
public class AlterarSenhaDTO {


    private Long idUsuario;
    @NotNull(message = "O Campo 'Senha Atual' é obrigatório.")
    private String senhaAtual;
    @NotNull(message = "O Campo 'Nova Senha' é obrigatório.")
    private String novaSenha;
    @NotNull(message = "O Campo 'Confirma Nova Senha' é obrigatório.")
    private String confirmaNovaSenha;

    /**
     * @return the idUsuario
     */
    public Long getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * @return the senhaAtual
     */
    public String getSenhaAtual() {
        return senhaAtual;
    }

    /**
     * @param senhaAtual the senhaAtual to set
     */
    public void setSenhaAtual(String senhaAtual) {
        this.senhaAtual = senhaAtual;
    }

    /**
     * @return the novaSenha
     */
    public String getNovaSenha() {
        return novaSenha;
    }

    /**
     * @param novaSenha the novaSenha to set
     */
    public void setNovaSenha(String novaSenha) {
        this.novaSenha = novaSenha;
    }

    /**
     * @return the confirmaNovaSenha
     */
    public String getConfirmaNovaSenha() {
        return confirmaNovaSenha;
    }

    /**
     * @param confirmaNovaSenha the confirmaNovaSenha to set
     */
    public void setConfirmaNovaSenha(String confirmaNovaSenha) {
        this.confirmaNovaSenha = confirmaNovaSenha;
    }
}
