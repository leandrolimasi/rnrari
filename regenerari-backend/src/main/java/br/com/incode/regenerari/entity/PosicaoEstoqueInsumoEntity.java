package br.com.incode.regenerari.entity;

import br.com.incode.regenerari.enums.EventoEstoque;
import br.com.incode.regenerari.listener.AuditListener;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

/**
 * Created by leandrolimadasilva on 16/04/17.
 */
@Entity
@Audited
@Table(name = "POSICAO_ESTOQUE_INSUMO")
@Access(AccessType.FIELD)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@EntityListeners(AuditListener.class)
@SequenceGenerator(name = "SE_POSICAO_ESTOQUE_INSUMO", sequenceName = "SE_POSICAO_ESTOQUE_INSUMO")
public class PosicaoEstoqueInsumoEntity extends AppBaseEntity {

    /** atributo chave primaria
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SE_POSICAO_ESTOQUE_INSUMO")
    @Column(name = "ID_POSICAO_ESTOQUE_INSUMO", unique = true, nullable = false)
    private Long id;

    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    @NotNull
    @ManyToOne (targetEntity = InsumoEntity.class)
    @JoinColumn(name = "ID_INSUMO")
    private InsumoEntity insumo;

    @NotNull
    @Column(name = "QUANTIDADE", precision = 15, scale = 3)
    private BigDecimal quantidade;

    @NotNull
    @Column(name = "VALOR_UNITARIO", precision = 15, scale = 3)
    private BigDecimal valorUnitario;

    @Enumerated(EnumType.STRING)
    @Column(name = "EVENTO", length = 10)
    private EventoEstoque eventoEstoque;

    /**
     * Default
     */
    public PosicaoEstoqueInsumoEntity(){}

    /* transients*/
    @Transient
    private BigDecimal quantidadeEstoqueAnterior;

    @Transient
    private BigDecimal valorUnitarioAnterior;


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
     * @return the valorUnitario
     */
    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    /**
     * @param valorUnitario the valorUnitario to set
     */
    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    /**
     * @return the eventoEstoque
     */
    public EventoEstoque getEventoEstoque() {
        return eventoEstoque;
    }

    /**
     * @param eventoEstoque the eventoEstoque to set
     */
    public void setEventoEstoque(EventoEstoque eventoEstoque) {
        this.eventoEstoque = eventoEstoque;
    }

    /**
     * @return the quantidadeEstoqueAnterior
     */
    public BigDecimal getQuantidadeEstoqueAnterior() {
        return quantidadeEstoqueAnterior;
    }

    /**
     * @param quantidadeEstoqueAnterior the quantidadeEstoqueAnterior to set
     */
    public void setQuantidadeEstoqueAnterior(BigDecimal quantidadeEstoqueAnterior) {
        this.quantidadeEstoqueAnterior = quantidadeEstoqueAnterior;
    }

    /**
     * @return the valorUnitarioAnterior
     */
    public BigDecimal getValorUnitarioAnterior() {
        return valorUnitarioAnterior;
    }

    /**
     * @param valorUnitarioAnterior the valorUnitarioAnterior to set
     */
    public void setValorUnitarioAnterior(BigDecimal valorUnitarioAnterior) {
        this.valorUnitarioAnterior = valorUnitarioAnterior;
    }
}
