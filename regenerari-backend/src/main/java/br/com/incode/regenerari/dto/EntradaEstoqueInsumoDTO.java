package br.com.incode.regenerari.dto;

import br.com.incode.regenerari.entity.InsumoEntity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by leandrolimadasilva on 12/04/17.
 */
public class EntradaEstoqueInsumoDTO {

    @NotNull(message = "O Campo 'Insumo' é obrigatório.")
    private InsumoEntity insumo;
    @NotNull(message = "O Campo 'Quantidade' é obrigatório.")
    private BigDecimal quantidade;
    @NotNull(message = "O Campo 'Quantidade' é obrigatório.")
    @Past
    private Date data;
    @NotNull(message = "O Campo 'Valor Compra Total' é obrigatório.")
    private BigDecimal valorCompraTotal;

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
     * @return the valorCompraTotal
     */
    public BigDecimal getValorCompraTotal() {
        return valorCompraTotal;
    }

    /**
     * @param valorCompraTotal the valorCompraTotal to set
     */
    public void setValorCompraTotal(BigDecimal valorCompraTotal) {
        this.valorCompraTotal = valorCompraTotal;
    }

    /**
     * @return the data
     */
    public Date getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Date data) {
        this.data = data;
    }
}
