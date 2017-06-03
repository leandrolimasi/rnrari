package br.com.incode.regenerari.dto;

import br.com.incode.regenerari.entity.ComposicaoProdutoEntity;
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
    private ComposicaoProdutoEntity composicaoProduto;
    @NotNull(message = "O Campo 'Quantidade' é obrigatório.")
    private BigDecimal quantidade;
    @NotNull(message = "O Campo 'Data Limite' é obrigatório.")
    @Future
    private Date dataLimite;
    @NotNull(message = "O Campo 'Número' é obrigatório.")
    private String numero;
    @NotNull(message = "O Campo 'Motivo' é obrigatório.")
    private MotivoOrdemProducao motivoOrdemProducao;

    /**
     * @return the composicaoProduto
     */
    public ComposicaoProdutoEntity getComposicaoProduto() {
        return composicaoProduto;
    }

    /**
     * @param composicaoProduto the composicaoProduto to set
     */
    public void setComposicaoProduto(ComposicaoProdutoEntity composicaoProduto) {
        this.composicaoProduto = composicaoProduto;
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
     * @return the motivoOrdemProducao
     */
    public MotivoOrdemProducao getMotivoOrdemProducao() {
        return motivoOrdemProducao;
    }

    /**
     * @param motivoOrdemProducao the motivoOrdemProducao to set
     */
    public void setMotivoOrdemProducao(MotivoOrdemProducao motivoOrdemProducao) {
        this.motivoOrdemProducao = motivoOrdemProducao;
    }
}
