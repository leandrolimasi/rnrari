package br.com.incode.regenerari.entity;

import br.com.incode.regenerari.enums.ApresentacaoProduto;
import br.com.incode.regenerari.enums.CategoriaProduto;
import br.com.incode.regenerari.enums.UnidadeMedidaProduto;
import br.com.incode.regenerari.listener.AuditListener;
import com.powerlogic.jcompany.core.model.domain.PlcSituacao;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by leandrolimadasilva on 12/04/17.
 */
@Entity
@Table(name = "ESTOQUE_INSUMO")
@Access(AccessType.FIELD)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@EntityListeners(AuditListener.class)
@SequenceGenerator(name = "SE_ESTOQUE_INSUMO", sequenceName = "SE_ESTOQUE_INSUMO")
public class EstoqueInsumoEntity extends AppBaseEntity {

    /** atributo chave primaria
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SE_ESTOQUE_INSUMO")
    @Column(name = "ID_ESTOQUE_INSUMO", unique = true, nullable = false)
    private Long id;

    @ManyToOne (targetEntity = InsumoEntity.class)
    @JoinColumn(name = "ID_INSUMO")
    private InsumoEntity insumoEntity;

    @Column(name = "QUANTIDADE")
    private BigDecimal quantidade;

    @Column(name = "VALOR_COMPRA_TOTAL")
    private BigDecimal valorCompraTotal;

    @Column(name = "VALOR_COMPRA_UNITARIO")
    private BigDecimal valorCompraUnitario;


    /**
     * Default
     */
    public EstoqueInsumoEntity(){}

    /**
     * @return the id
     */
    @Override
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    @Override
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the insumoEntity
     */
    public InsumoEntity getInsumoEntity() {
        return insumoEntity;
    }

    /**
     * @param insumoEntity the insumoEntity to set
     */
    public void setInsumoEntity(InsumoEntity insumoEntity) {
        this.insumoEntity = insumoEntity;
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
     * @return the valorCompraUnitario
     */
    public BigDecimal getValorCompraUnitario() {
        return valorCompraUnitario;
    }

    /**
     * @param valorCompraUnitario the valorCompraUnitario to set
     */
    public void setValorCompraUnitario(BigDecimal valorCompraUnitario) {
        this.valorCompraUnitario = valorCompraUnitario;
    }
}
