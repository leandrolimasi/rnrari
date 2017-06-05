package br.com.incode.regenerari.dto;

import br.com.incode.regenerari.entity.InsumoEntity;

import java.math.BigDecimal;

/**
 * Created by leandrolimadasilva on 01/06/17.
 */
public class InsumosOrdemProducaoDTO {

    private InsumoEntity insumo;

    private BigDecimal quantidadeEstoque;

    private BigDecimal quantidadeSolicitada;

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
     * @return the quantidadeEstoque
     */
    public BigDecimal getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    /**
     * @param quantidadeEstoque the quantidadeEstoque to set
     */
    public void setQuantidadeEstoque(BigDecimal quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    /**
     * @return the quantidadeSolicitada
     */
    public BigDecimal getQuantidadeSolicitada() {
        return quantidadeSolicitada;
    }

    /**
     * @param quantidadeSolicitada the quantidadeSolicitada to set
     */
    public void setQuantidadeSolicitada(BigDecimal quantidadeSolicitada) {
        this.quantidadeSolicitada = quantidadeSolicitada;
    }
}
