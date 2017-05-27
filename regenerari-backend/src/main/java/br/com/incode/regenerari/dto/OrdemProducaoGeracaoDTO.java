package br.com.incode.regenerari.dto;

import br.com.incode.regenerari.entity.ProdutoEntity;
import br.com.incode.regenerari.enums.MotivoOrdemProducao;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by leandrolimadasilva on 26/05/17.
 */
public class OrdemProducaoGeracaoDTO {

    @NotNull(message = "O Campo 'Produto' é obrigatório.")
    private ProdutoEntity produto;
    @NotNull(message = "O Campo 'Quantidade' é obrigatório.")
    private BigDecimal quantidade;
    @NotNull(message = "O Campo 'Data Limite' é obrigatório.")
    @Future
    private Date dataLimite;
    @NotNull(message = "O Campo 'Número' é obrigatório.")
    private String numero;
    @NotNull(message = "O Campo 'Motivo' é obrigatório.")
    private MotivoOrdemProducao motivo;

    /**
     * @return the produto
     */
    public ProdutoEntity getProduto() {
        return produto;
    }

    /**
     * @param produto the produto to set
     */
    public void setProduto(ProdutoEntity produto) {
        this.produto = produto;
    }

    /**
     * @return the quantidade
     */
    public BigDecimal getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the dataLimite
     */
    public Date getDataLimite() {
        return dataLimite;
    }

    /**
     * @param dataLimite the dataLimite to set
     */
    public void setDataLimite(Date dataLimite) {
        this.dataLimite = dataLimite;
    }

    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @return the motivo
     */
    public MotivoOrdemProducao getMotivo() {
        return motivo;
    }

    /**
     * @param motivo the motivo to set
     */
    public void setMotivo(MotivoOrdemProducao motivo) {
        this.motivo = motivo;
    }
}
