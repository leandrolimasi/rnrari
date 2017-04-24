package br.com.incode.regenerari.dto;

import br.com.incode.regenerari.entity.InsumoEntity;
import br.com.incode.regenerari.enums.MotivoBaixaExcepcional;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * Created by leandrolimadasilva on 24/04/17.
 */
public class BaixaInsumoExcepcionalDTO {

    @NotNull(message = "O Campo 'Insumo' é obrigatório.")
    private InsumoEntity insumo;
    @NotNull(message = "O Campo 'Quantidade' é obrigatório.")
    private BigDecimal quantidade;
    @NotNull(message = "O Campo 'Motivo' é obrigatório.")
    private MotivoBaixaExcepcional motivoBaixaExcepcional;
    private String observacao;

    /**
     * @return the insumo
     */
    public InsumoEntity getInsumo() {
        return insumo;
    }

    /**
     * @param insumo the insumo to set
     */
    public void setInsumo(InsumoEntity insumo) {
        this.insumo = insumo;
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
     * @return the motivoBaixaExcepcional
     */
    public MotivoBaixaExcepcional getMotivoBaixaExcepcional() {
        return motivoBaixaExcepcional;
    }

    /**
     * @param motivoBaixaExcepcional the motivoBaixaExcepcional to set
     */
    public void setMotivoBaixaExcepcional(MotivoBaixaExcepcional motivoBaixaExcepcional) {
        this.motivoBaixaExcepcional = motivoBaixaExcepcional;
    }

    /**
     * @return the observacao
     */
    public String getObservacao() {
        return observacao;
    }

    /**
     * @param observacao the observacao to set
     */
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
