package br.com.incode.regenerari.dto;

/**
 * Created by leandro.lima on 21/02/2017.
 */
public class AlterarSenhaDTO {

    private Long idUsuario;
    private String senhaAtual;
    private String novaSenha;
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
